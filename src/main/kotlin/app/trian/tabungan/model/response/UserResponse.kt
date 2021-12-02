package app.trian.tabungan.model.response

import app.trian.tabungan.model.entity.User

data class UserResponse(val name:String)

fun User.toResponse():UserResponse{
    return UserResponse("")
}