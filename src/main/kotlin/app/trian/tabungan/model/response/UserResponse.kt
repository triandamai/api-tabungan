package app.trian.tabungan.model.response

import app.trian.tabungan.model.entity.User

data class UserResponse(
    val id_user:Long,
    val name:String,
    val username:String,
    val createdAt:Long,
    val updatedAt:Long
)

fun User.toResponse():UserResponse{
    return UserResponse(
        id_user=idUser,
        name=name,
        username=username,
        createdAt = createdAt,
        updatedAt=updatedAt
    )
}