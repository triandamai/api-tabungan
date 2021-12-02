package app.trian.tabungan.controller

import app.trian.tabungan.model.request.UserLoginRequest
import app.trian.tabungan.model.request.UserRequest
import app.trian.tabungan.model.response.BaseResponse
import app.trian.tabungan.model.response.UserResponse
import app.trian.tabungan.services.`interface`.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
* Auth Controller
* Created By Trian Damai
* https://github.com/triandamai
* Created At 11.04
*/
@RestController
class AuthController(
    private val userService: UserService
) {
    @GetMapping(
        name = "login",
        value=[
            "api/v1/login"
        ]
    )
    fun login(userLoginRequest: UserLoginRequest):BaseResponse<UserResponse> = userService.loginUser(userLoginRequest)

    @GetMapping(
        name = "register",
        value = [
            "api/v1/register"
        ]
    )
    fun register(userRequest: UserRequest):BaseResponse<UserResponse> = userService.registerNewUser(userRequest)
}