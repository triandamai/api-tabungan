package app.trian.tabungan.services.`interface`

import app.trian.tabungan.model.request.MemberRequest
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
    fun getWalletByUser(userId:Long,pageable: Pageable):BaseResponse<List<MemberResponse>>

    fun addNewMember(memberRequest: MemberRequest):BaseResponse<MemberResponse>

    fun leaveMembership(memberId: Long):BaseResponse<MemberResponse>

    fun disableMember(memberId:Long):BaseResponse<MemberResponse>
}