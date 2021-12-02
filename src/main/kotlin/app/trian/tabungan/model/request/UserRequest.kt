package app.trian.tabungan.model.request

import app.trian.tabungan.model.entity.User

data class UserRequest(
    val name:String,
    val username:String,
    val password:String,
)

fun UserRequest.toUser(
    password: String="",
    idUser:Long,
    createdAt:Long,
    updatedAt:Long
):User{

    return User(
        idUser = idUser,
        name= name,
        username=username,
        password= password.ifBlank { this.password },
        createdAt=createdAt,
        updatedAt = updatedAt
    )
}