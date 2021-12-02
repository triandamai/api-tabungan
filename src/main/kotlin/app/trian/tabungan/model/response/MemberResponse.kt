package app.trian.tabungan.model.response

import app.trian.tabungan.model.entity.*
import javax.persistence.*

data class MemberResponse(

    val id_member:Long,


    val wallet: Wallet?,


    val user: User?,


    val role: ROLE_MEMBER,


    val statusMembership:STATUS_MEMBER,


    val createdAt:Long,


    val updatedAt:Long
)

fun Member.toResponse():MemberResponse{
    return MemberResponse(
        id_member =idMember,
        wallet = wallet,
        user = user,
        role=role,
        statusMembership=statusMembership,
        createdAt=createdAt,
        updatedAt=updatedAt
    )
}