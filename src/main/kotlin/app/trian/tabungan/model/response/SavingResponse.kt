package app.trian.tabungan.model.response

import app.trian.tabungan.model.entity.Saving
import app.trian.tabungan.model.entity.User
import app.trian.tabungan.model.entity.Wallet


data class SavingResponse(
    var id_saving:Long,
    var wallet: Wallet?,
    var user: User?,
    var balance:Double,
    var description:String,
    var note:String,
    var receipt:String,
    var granted_by:String,
    var granted:Boolean,
    var created_at:Long,
    var updated_at:Long
)

fun Saving.toResponse():SavingResponse{

    return SavingResponse(
        id_saving = idSaving,
        wallet=wallet!!,
        user=user,
        balance=balance,
        description=description,
        note=note,
        receipt=receipt,
        granted_by=grantedBy,
        granted=granted,
        created_at=createdAt,
        updated_at=updatedAt
    )
}