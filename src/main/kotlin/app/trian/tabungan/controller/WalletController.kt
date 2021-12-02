package app.trian.tabungan.controller

import app.trian.tabungan.model.request.WalletRequest
import app.trian.tabungan.services.`interface`.WalletService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

/**
* Wallet Controller
* Created By Trian Damai
* https://github.com/triandamai
* Created At 11.04
*/
@RestController
class WalletController(
    private val walletService: WalletService
) {
    @GetMapping(
        value = ["api/v1/wallets"],
        produces = ["application/json"]
    )
    fun getWallets(pageable: Pageable) =
    walletService.getWallet(pageable)

    @GetMapping(
        value = ["api/v1/wallet/{id}"],
        produces = ["application/json"]
    )
    fun getWallet(@PathVariable("id") id:Long)=
    walletService.getDetailWallet(id)

    @PostMapping(
        value = ["api/v1/wallet"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createNewWallet(@RequestBody walletRequest: WalletRequest) =
    walletService.createWallet(walletRequest)

    @PutMapping(
        value = ["api/v1/wallet/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateWallet(@PathVariable("id") id:Long,
                     @RequestBody walletRequest: WalletRequest)=walletService.updateWallet(id,walletRequest)
}

