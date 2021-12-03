package app.trian.tabungan.controller

import app.trian.tabungan.model.request.SavingActionRequest
import app.trian.tabungan.model.request.SavingRequest
import app.trian.tabungan.services.`interface`.SavingService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

/**
 * Balance controller
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 11.05
 */
@RestController
class SavingController(
    private val savingService: SavingService
) {
    @GetMapping(
        value = ["api/v1/saving/{id_user}/user"],
        produces = ["application/json"]
    )
    fun getSavingByUser(@PathVariable("id_user") idUser:Long,pageable: Pageable) =
        savingService.getSavingByUser(idUser,pageable)

    @GetMapping(
        value = ["api/v1/saving/{id_wallet}/wallet"],
        produces = ["application/json"]
    )
    fun getSavingByWallet(@PathVariable("id_wallet") idWallet:Long,pageable: Pageable)=
        savingService.getSavingByWallet(idWallet,pageable)

    @GetMapping(
        value = ["api/v1/saving/{id_saving}"],
        produces = ["application/json"]
    )
    fun getDetailSaving(@PathVariable("id_saving") idSaving:Long) =
        savingService.getDetailSaving(idSaving)

    @PostMapping(
        value = ["api/v1/saving"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createNewSaving(@RequestBody request:SavingRequest) =
        savingService.sendBalance(request)

    @PutMapping(
        value = ["api/v1/saving/{id_saving}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun editSaving(@PathVariable("id_saving") idSaving:Long, @RequestBody request:SavingRequest) =
        savingService.editSaving(idSaving,request)

    @PutMapping(
        value = ["api/v1/saving/{id_saving}/accept"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun accpetSaving(@PathVariable("id_saving") idSaving:Long, @RequestBody request:SavingActionRequest) =
        savingService.acceptBalance(idSaving,request)

    @PutMapping(
        value = ["api/v1/saving/{id_saving}/reject"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun rejectSaving(@PathVariable("id_saving") idSaving:Long, @RequestBody request:SavingActionRequest) =
        savingService.rejectBalance(idSaving,request)
}