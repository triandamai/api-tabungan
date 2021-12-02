package app.trian.tabungan.model.request

import app.trian.tabungan.model.entity.User
import javax.validation.constraints.NotBlank

data class UserRequest(
    @field:NotBlank
    val name:String?,
    @field:NotBlank
    val username:String?,
    @field:NotBlank
    val password:String?,
)

fun UserRequest.toUser(
    password: String="",
    idUser:Long,
    createdAt:Long,
    updatedAt:Long
):User{

    return User(
        idUser = idUser,
        name= name!!,
        username=username!!,
        password= password.ifBlank { this.password!! },
        createdAt=createdAt,
        updatedAt = updatedAt
    )
}