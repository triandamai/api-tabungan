package app.trian.tabungan.model.request

import app.trian.tabungan.model.entity.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class MemberRequest(
    @field:NotBlank
    var role:ROLE_MEMBER?,
    @field:NotNull
    var id_user:Long?,
    @field:NotBlank
    var status:STATUS_MEMBER?
)

fun MemberRequest.toMember(
    wallet: Wallet,
    user: User,
    createdAt:Long,
    updatedAt:Long
):Member{
    return Member(
        idMember = 0,
        user = user,
        wallet=wallet,
        role = role!!,
        statusMembership = status!!,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )
}