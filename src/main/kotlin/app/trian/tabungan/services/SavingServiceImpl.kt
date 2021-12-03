package app.trian.tabungan.services

import app.trian.tabungan.model.entity.Member
import app.trian.tabungan.model.entity.ROLE_MEMBER
import app.trian.tabungan.model.request.SavingActionRequest
import app.trian.tabungan.model.request.SavingRequest
import app.trian.tabungan.model.request.toSaving
import app.trian.tabungan.model.response.*
import app.trian.tabungan.repository.MemberRepository
import app.trian.tabungan.repository.SavingRepository
import app.trian.tabungan.repository.UserRepository
import app.trian.tabungan.repository.WalletRepository
import app.trian.tabungan.services.`interface`.SavingService
import app.trian.tabungan.utils.AccessDeniedException
import app.trian.tabungan.utils.DataNotFoundException
import app.trian.tabungan.utils.ValidationUtil
import org.joda.time.DateTime
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


/**
 * Saving service impl
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 20.07
 */

@Service
class SavingServiceImpl(
    private val validationUtil: ValidationUtil,
    private val savingRepository: SavingRepository,
    private val userRepository: UserRepository,
    private val walletRepository: WalletRepository,
    private val memberRepository: MemberRepository
): SavingService {
    override fun getSavingByUser(userId: Long, pageable: Pageable): BaseResponse<BaseCollectionPageable<SavingResponse>> {
        val checkUser = userRepository.findByIdOrNull(userId)
            ?: throw DataNotFoundException("User with $userId not found")
        val savingsUser = savingRepository.findAllByUserOrderByCreatedAtDesc(checkUser,pageable)
        val transform = savingsUser.content.map {
            it.toResponse()
        }

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = BaseCollectionPageable(
                data = transform,
                page = savingsUser.number,
                totalELement = savingsUser.totalElements.toInt(),
                totalPage = savingsUser.totalPages,
                size = savingsUser.size
            ),
            message = "Data saving by user"
        )
    }

    override fun getSavingByWallet(walletId: Long, pageable: Pageable): BaseResponse<BaseCollectionPageable<SavingResponse>> {
        val checkWallet = walletRepository.findByIdOrNull(walletId)
            ?: throw DataNotFoundException("No wallet found with $walletId")

        val savingWallet = savingRepository.findAllByWalletOrderByCreatedAtDesc(checkWallet,pageable)
        val transform = savingWallet.content.map {
            it.toResponse()
        }
        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = BaseCollectionPageable(
                data = transform,
                page=savingWallet.number,
                size = savingWallet.size,
                totalPage = savingWallet.totalPages,
                totalELement = savingWallet.totalElements.toInt()
            ),
            message = "Data saving by wallet"
        )
    }

    override fun getDetailSaving(savingId: Long): BaseResponse<SavingResponse> {
        val saving = savingRepository.findByIdOrNull(savingId)
            ?: throw DataNotFoundException("No data saving with $savingId found!")

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = saving.toResponse(),
            message = "Data saving found"
        )
    }

    override fun sendBalance(savingRequest: SavingRequest): BaseResponse<SavingResponse> {
        validationUtil.validate(savingRequest)
        val findUser = userRepository.findByIdOrNull(savingRequest.id_user)
            ?: throw DataNotFoundException("Cannot save balance,User ${savingRequest.id_user} not match to any user")
        val findWallet = walletRepository.findByIdOrNull(savingRequest.id_wallet)
            ?: throw DataNotFoundException("Cannot save balance, Wallet ${savingRequest.id_wallet} not found or have been remove")
        val date = DateTime().millis
        val request = savingRequest.toSaving(
            idSaving = date,
            user=findUser,
            wallet=findWallet,
            createdAt = date,
            updatedAt = date,
            granted = false,
            grantedBy = "no",

        )
        val savedData = savingRepository.save(request)

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = savedData.toResponse(),
            message = "Success send balance to ${findWallet.name}"
        )
    }

    override fun editSaving(idSaving:Long,savingRequest: SavingRequest): BaseResponse<SavingResponse> {
        validationUtil.validate(savingRequest)
        val findSaving = savingRepository.findByIdOrNull(idSaving)
            ?: throw DataNotFoundException("Saving with $idSaving not found!")

        val date = DateTime().millis
        val prepareData = findSaving.apply {
            updatedAt = date
            note= savingRequest.note!!
            description = savingRequest.description!!
            receipt = receipt
        }

        val savedData = savingRepository.save(prepareData)

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = savedData.toResponse(),
            message = "Success edit saving"
        )
    }

    //granted only when user is admin/owner
    override fun acceptBalance(idSaving: Long,savingRequest: SavingActionRequest): BaseResponse<SavingResponse> {

        val member = findMemberByUserAndWallet(savingRequest)
        if(member.role != ROLE_MEMBER.ADMIN || member.role != ROLE_MEMBER.OWNER){
            throw AccessDeniedException("Only admin or owner can accept!")
        }

        val findSaving = savingRepository.findByIdOrNull(idSaving)
            ?: throw DataNotFoundException("No saving found with ${idSaving}}")

        val prepare = findSaving.apply {
            granted = true
            grantedBy = member.user?.idUser.toString()
        }

        val save = savingRepository.save(prepare)

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = save.toResponse(),
            message = "Success accept saving $idSaving by ${member.user?.name}"
        )
    }

    override fun rejectBalance(idSaving: Long,savingRequest: SavingActionRequest): BaseResponse<SavingResponse> {

        val member = findMemberByUserAndWallet(savingRequest)
        if(member.role != ROLE_MEMBER.ADMIN || member.role != ROLE_MEMBER.OWNER){
            throw AccessDeniedException("Only admin or owner can accept!")
        }

        val findSaving = savingRepository.findByIdOrNull(idSaving)
            ?: throw DataNotFoundException("No saving found with ${idSaving}}")

        val prepare = findSaving.apply {
            granted = false
            grantedBy = member.user?.idUser.toString()
            note = ""
        }

        val save = savingRepository.save(prepare)

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = save.toResponse(),
            message = "Success accept saving $idSaving by ${member.user?.name}"
        )
    }

    override fun findMemberByUserAndWallet(savingRequest: SavingActionRequest): Member {
        validationUtil.validate(savingRequest)
        val findUser = userRepository.findByIdOrNull(savingRequest.id_user)
            ?: throw DataNotFoundException("No user found")
        val findWallet = walletRepository.findByIdOrNull(savingRequest.id_wallet)
            ?: throw DataNotFoundException("No wallet found")

        return memberRepository.findByUserAndWallet(findUser, findWallet)
            ?: throw AccessDeniedException("Only admin or owner can accept!")
    }


}