package app.trian.tabungan.services

import app.trian.tabungan.model.request.WalletRequest
import app.trian.tabungan.model.response.BaseResponse
import app.trian.tabungan.model.response.WalletResponse
import app.trian.tabungan.services.`interface`.WalletService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * Service wallet
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 00.28
 */
@Service
class WalletServiceImpl(

):WalletService {
    override fun getWallet(pageable: Pageable): BaseResponse<List<WalletResponse>> {
        TODO("Not yet implemented")
    }

    override fun getDetailWallet(idWallet: Long): BaseResponse<WalletResponse> {
        TODO("Not yet implemented")
    }

    override fun createWallet(request: WalletRequest): BaseResponse<WalletResponse> {
        TODO("Not yet implemented")
    }

    override fun updateWallet(id: Long, request: WalletRequest): BaseResponse<WalletResponse> {
        TODO("Not yet implemented")
    }
}