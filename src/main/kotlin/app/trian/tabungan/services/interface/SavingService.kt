package app.trian.tabungan.services.`interface`

import app.trian.tabungan.model.request.SavingRequest
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

    fun getSavingByUser(userId:Long,pageable: Pageable):BaseResponse<List<SavingResponse>>

    fun getSavingByWallet(walletId:Long,pageable: Pageable):BaseResponse<List<SavingResponse>>

    fun sendBalance(savingRequest: SavingRequest):BaseResponse<SavingResponse>

    fun editSaving(savingRequest: SavingRequest):BaseResponse<SavingResponse>

    fun acceptBalance(savingRequest: SavingRequest):BaseResponse<SavingResponse>

    fun rejectBalance(savingRequest: SavingRequest):BaseResponse<SavingResponse>




}