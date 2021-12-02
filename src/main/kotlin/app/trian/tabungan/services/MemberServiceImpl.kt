package app.trian.tabungan.services

import app.trian.tabungan.model.entity.Member
import app.trian.tabungan.model.entity.ROLE_MEMBER
import app.trian.tabungan.model.entity.STATUS_MEMBER
import app.trian.tabungan.model.request.MemberRequest
import app.trian.tabungan.model.request.toMember
import app.trian.tabungan.model.response.*
import app.trian.tabungan.repository.MemberRepository
import app.trian.tabungan.repository.UserRepository
import app.trian.tabungan.repository.WalletRepository
import app.trian.tabungan.services.`interface`.MemberService
import app.trian.tabungan.utils.DataNotFoundException
import app.trian.tabungan.utils.ValidationUtil
import org.joda.time.DateTime
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

/**
 * Member Service Impl
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 20.08
 */
@Service
class MemberServiceImpl(
    private val validationUtil: ValidationUtil,
    private val memberRepository: MemberRepository,
    private val userRepository: UserRepository,
    private val  walletRepository: WalletRepository
):MemberService {
    override fun getWalletByUser(userId: Long, pageable: Pageable): BaseResponse<BaseCollectionPageable<MemberResponse>> {
        val user = userRepository.findByIdOrNull(userId)
            ?: throw DataNotFoundException("No user with $userId found")
        val members = memberRepository.findAllByUser(user,pageable)

        val transform = members.content.map {
            it.toResponse()
        }

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = BaseCollectionPageable(
                data = transform,
                page = members.number,
                totalPage = members.totalPages,
                totalELement = members.totalElements.toInt(),
                size = members.size
            ),
            message = "data members"
        )
    }

    override fun addNewMember(memberRequest: MemberRequest): BaseResponse<MemberResponse> {
        //validate first

        validationUtil.validate(memberRequest)

        val checkWallet = walletRepository.findByIdOrNull(memberRequest.id_wallet)
            ?: throw DataNotFoundException("Wallet is invalid wallt id = ${memberRequest.id_wallet}")
       val checkUser = userRepository.findByIdOrNull(memberRequest.id_user)
           ?: throw DataNotFoundException("There are no user associate with ${memberRequest.id_user}")
        val date = DateTime().millis
        val prepareData = memberRequest.toMember(
            idMember = date,
            wallet = checkWallet,
            user = checkUser,
            role=ROLE_MEMBER.MEMBER,
            statusMember=STATUS_MEMBER.ACTIVE,
            createdAt = date,
            updatedAt = date
        )

        val save = memberRepository.save(prepareData)

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = save.toResponse(),
            message = "Success create new member to ${checkWallet.name}"
        )
    }

    override fun leaveMembership(request: MemberRequest): BaseResponse<MemberResponse> {
        val member = validateWalletAndUserAndMember(request)

        member.apply {
            statusMembership=STATUS_MEMBER.LEAVE
        }
       val save = memberRepository.save(member)

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = save.toResponse(),
            message = "User ${member.user?.name} has leave ${member.wallet?.name}}"
        )
    }

    override fun disableMember(request: MemberRequest): BaseResponse<MemberResponse> {
        val member = validateWalletAndUserAndMember(request)

        member.apply {
            statusMembership=STATUS_MEMBER.NONACTIVE
        }
        val save = memberRepository.save(member)

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = save.toResponse(),
            message = "User ${member.user?.name} has leave ${member.wallet?.name}"
        )
    }

    override fun makeMemberOwner(request: MemberRequest): BaseResponse<MemberResponse> {
        val member = validateWalletAndUserAndMember(request)

        member.apply {
            role = ROLE_MEMBER.OWNER
        }
        val save = memberRepository.save(member)

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = save.toResponse(),
            message = "User ${member.user?.name} has become owner of ${member.wallet?.name}"
        )
    }

    override fun makeMemberAdmin(request: MemberRequest): BaseResponse<MemberResponse> {
        val member = validateWalletAndUserAndMember(request)

        member.apply {
            role = ROLE_MEMBER.ADMIN
        }
        val save = memberRepository.save(member)

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = save.toResponse(),
            message = "User ${member.user?.name} has become admin of ${member.wallet?.name}"
        )
    }

    override fun makeMemberMember(request: MemberRequest): BaseResponse<MemberResponse> {
        val member = validateWalletAndUserAndMember(request)

        member.apply {
            role = ROLE_MEMBER.MEMBER
        }
        val save = memberRepository.save(member)

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = save.toResponse(),
            message = "User ${member.user?.name} has become member of ${member.wallet?.name}"
        )
    }

    override fun validateWalletAndUserAndMember(request: MemberRequest) :Member{
        validationUtil.validate(request)
        val checkUser = userRepository.findByIdOrNull(request.id_user)
            ?: throw DataNotFoundException("No user found with id ${request.id_user}")
        val checkWallet = walletRepository.findByIdOrNull(request.id_wallet)
            ?: throw  DataNotFoundException("No wallet found with id ${request.id_wallet}")

        val member = memberRepository.findByUserAndWallet(checkUser,checkWallet)
            ?: throw DataNotFoundException("User has not join wallet!")

        return member
    }
}