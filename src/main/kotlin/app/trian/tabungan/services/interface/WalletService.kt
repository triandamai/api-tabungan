package app.trian.tabungan.services.`interface`

import app.trian.tabungan.model.entity.Wallet
import app.trian.tabungan.model.request.WalletRequest
import app.trian.tabungan.model.response.BaseResponse
import app.trian.tabungan.model.response.WalletResponse
import org.springframework.data.domain.Pageable

interface WalletService {

    fun getWallet(pageable: Pageable):BaseResponse<List<WalletResponse>>

    fun getDetailWallet(idWallet: Long):BaseResponse<WalletResponse>

    fun createWallet(request: WalletRequest):BaseResponse<WalletResponse>

    fun updateWallet(id:Long,request: WalletRequest):BaseResponse<WalletResponse>


}