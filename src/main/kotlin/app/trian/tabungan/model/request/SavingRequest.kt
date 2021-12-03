package app.trian.tabungan.model.request

import app.trian.tabungan.model.entity.Saving
import app.trian.tabungan.model.entity.User
import app.trian.tabungan.model.entity.Wallet
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Request from client
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 20.51
 */
data class SavingRequest(
    @field:NotBlank
    var name:String?,
    @field:NotNull
    var id_user:Long?,
    @field:NotNull
    var id_wallet:Long?,
    @field:NotNull
    var balance:Double?,
    @field:NotBlank
    var description:String?,
    @field:NotBlank
    var note:String?,
    @field:NotBlank
    var receipt:String?,
)

data class SavingActionRequest(
    @field:NotBlank
    var name:String?,
    @field:NotNull
    var id_user:Long?,
    @field:NotNull
    var id_wallet:Long?,
    @field:NotBlank
    var note:String?
)

fun SavingRequest.toSaving(
    idSaving:Long,
    grantedBy:String,
    granted:Boolean,
    wallet: Wallet,
    user: User,
    createdAt:Long,
    updatedAt:Long
):Saving{
    return Saving(
        idSaving = idSaving,
        wallet = wallet,
        user = user,
        balance = balance!!,
        description = description!!,
        note = note!!,
        receipt = receipt!!,
        grantedBy = grantedBy,
        granted = granted,
        createdAt = createdAt,
        updatedAt = updatedAt

    )
}