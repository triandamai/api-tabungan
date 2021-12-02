package app.trian.tabungan.model.request

import app.trian.tabungan.model.entity.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class MemberRequest(
    @field:NotNull
    var id_user:Long?,
    @field:NotNull
    var id_wallet:Long?,
)

fun MemberRequest.toMember(
    idMember:Long,
    wallet: Wallet,
    user: User,
    statusMember: STATUS_MEMBER,
    role :ROLE_MEMBER,
    createdAt:Long,
    updatedAt:Long
):Member{
    return Member(
        idMember = idMember,
        user = user,
        wallet=wallet,
        role = role,
        statusMembership = statusMember,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )
}