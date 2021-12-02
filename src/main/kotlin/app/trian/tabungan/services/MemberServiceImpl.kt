package app.trian.tabungan.services

import app.trian.tabungan.model.request.MemberRequest
import app.trian.tabungan.model.response.BaseResponse
import app.trian.tabungan.model.response.MemberResponse
import app.trian.tabungan.services.`interface`.MemberService
import org.springframework.data.domain.Pageable

/**
 * Member Service Impl
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 20.08
 */
class MemberServiceImpl:MemberService {
    override fun getWalletByUser(userId: Long, pageable: Pageable): BaseResponse<List<MemberResponse>> {
        TODO("Not yet implemented")
    }

    override fun addNewMember(memberRequest: MemberRequest): BaseResponse<MemberResponse> {
        TODO("Not yet implemented")
    }

    override fun leaveMembership(memberId: Long): BaseResponse<MemberResponse> {
        TODO("Not yet implemented")
    }

    override fun disableMember(memberId: Long): BaseResponse<MemberResponse> {
        TODO("Not yet implemented")
    }
}