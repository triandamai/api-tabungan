package app.trian.tabungan.services

import app.trian.tabungan.model.request.SavingRequest
import app.trian.tabungan.model.response.BaseResponse
import app.trian.tabungan.model.response.SavingResponse
import app.trian.tabungan.services.`interface`.SavingService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * Saving service impl
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 20.07
 */

@Service
class SavingServiceImpl:SavingService {
    override fun getSavingByUser(userId: Long, pageable: Pageable): BaseResponse<List<SavingResponse>> {
        TODO("Not yet implemented")
    }

    override fun getSavingByWallet(walletId: Long, pageable: Pageable): BaseResponse<List<SavingResponse>> {
        TODO("Not yet implemented")
    }

    override fun sendBalance(savingRequest: SavingRequest): BaseResponse<SavingResponse> {
        TODO("Not yet implemented")
    }

    override fun editSaving(savingRequest: SavingRequest): BaseResponse<SavingResponse> {
        TODO("Not yet implemented")
    }

    override fun acceptBalance(savingRequest: SavingRequest): BaseResponse<SavingResponse> {
        TODO("Not yet implemented")
    }

    override fun rejectBalance(savingRequest: SavingRequest): BaseResponse<SavingResponse> {
        TODO("Not yet implemented")
    }
}