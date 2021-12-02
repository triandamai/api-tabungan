package app.trian.tabungan.services.`interface`

import app.trian.tabungan.model.entity.Member
import app.trian.tabungan.model.request.MemberRequest
import app.trian.tabungan.model.response.BaseCollectionPageable
import app.trian.tabungan.model.response.BaseResponse
import app.trian.tabungan.model.response.MemberResponse
import org.springframework.data.domain.Pageable

/**
 * Member service
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 20.04
 */
interface MemberService {
    fun getWalletByUser(userId:Long,pageable: Pageable):BaseResponse<BaseCollectionPageable<MemberResponse>>

    fun addNewMember(memberRequest: MemberRequest):BaseResponse<MemberResponse>

    fun leaveMembership(request: MemberRequest):BaseResponse<MemberResponse>

    fun disableMember(request: MemberRequest):BaseResponse<MemberResponse>

    fun makeMemberOwner(request: MemberRequest): BaseResponse<MemberResponse>

    fun makeMemberAdmin(request: MemberRequest): BaseResponse<MemberResponse>

    fun makeMemberMember(request: MemberRequest): BaseResponse<MemberResponse>

    fun validateWalletAndUserAndMember(request: MemberRequest):Member
}