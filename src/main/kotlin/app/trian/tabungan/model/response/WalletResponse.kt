package app.trian.tabungan.model.response

import app.trian.tabungan.model.entity.Wallet


data class WalletResponse(
    val id_wallet:Long,

    val name:String,

    val description:String,

    val balance:Double,

    val created_by:Long,

    val createdAt:Long,

    val updatedAt:Long
)

fun Wallet.toResponse():WalletResponse{
    return WalletResponse(
        id_wallet = idWallet,
        name=name,
        description=description,
        balance=balance,
        created_by = createdBy,
        createdAt = createdAt,
        updatedAt=updatedAt
    )
}
