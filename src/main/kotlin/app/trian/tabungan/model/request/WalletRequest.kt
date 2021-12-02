package app.trian.tabungan.model.request

import app.trian.tabungan.model.entity.Wallet
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class WalletRequest(
    @field:NotBlank
    val name:String?,
    @field:NotNull
    val balance:Double?,
    @field:NotBlank
    val description:String?,

)

fun WalletRequest.toWallet(
    idWallet:Long,
    idUser:Long,
    createdAt:Long,
    updateAt:Long
):Wallet{

    return Wallet(
        idWallet = idWallet,
        name = name!!,
        description = description!!,
        balance = balance!!,
        createdBy = idUser,
        createdAt = createdAt,
        updatedAt = updateAt
    )
}