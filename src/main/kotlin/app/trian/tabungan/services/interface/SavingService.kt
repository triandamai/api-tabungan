package app.trian.tabungan.services.`interface`

import app.trian.tabungan.model.entity.Member
import app.trian.tabungan.model.request.SavingActionRequest
import app.trian.tabungan.model.request.SavingRequest
import app.trian.tabungan.model.response.BaseCollectionPageable
import app.trian.tabungan.model.response.BaseResponse
import app.trian.tabungan.model.response.MemberResponse
import app.trian.tabungan.model.response.SavingResponse
import org.springframework.data.domain.Pageable

/**
 * SavingService
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 19.37
 */

interface SavingService {

    fun getSavingByUser(userId:Long,pageable: Pageable):BaseResponse<BaseCollectionPageable<SavingResponse>>

    fun getSavingByWallet(walletId:Long,pageable: Pageable):BaseResponse<BaseCollectionPageable<SavingResponse>>

    fun getDetailSaving(savingId:Long):BaseResponse<SavingResponse>

    fun sendBalance(savingRequest: SavingRequest):BaseResponse<SavingResponse>

    fun editSaving(idSaving:Long,savingRequest: SavingRequest):BaseResponse<SavingResponse>

    fun acceptBalance(idSaving:Long,savingRequest: SavingActionRequest):BaseResponse<SavingResponse>

    fun rejectBalance(idSaving:Long,savingRequest: SavingActionRequest):BaseResponse<SavingResponse>

    fun findMemberByUserAndWallet(savingRequest: SavingActionRequest):Member

}