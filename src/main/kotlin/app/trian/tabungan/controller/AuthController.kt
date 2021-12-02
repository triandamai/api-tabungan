package app.trian.tabungan.controller

import app.trian.tabungan.model.request.UserLoginRequest
import app.trian.tabungan.model.request.UserRequest
import app.trian.tabungan.model.response.BaseCollectionPageable
import app.trian.tabungan.model.response.BaseResponse
import app.trian.tabungan.model.response.UserResponse
import app.trian.tabungan.services.`interface`.UserService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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
        name = "getListUser",
        value = ["api/v1/users"],
        produces = ["application/json"]
    )
    fun getListUser(pageable: Pageable):BaseResponse<BaseCollectionPageable<UserResponse>> = userService.getListUser(pageable)

    @PostMapping(
        name = "login",
        value=[
            "api/v1/login"
        ]
    )
    fun login(@RequestBody userLoginRequest: UserLoginRequest):BaseResponse<UserResponse> = userService.loginUser(userLoginRequest)

    @PostMapping(
        name = "register",
        value = [
            "api/v1/register"
        ],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun register(@RequestBody userRequest: UserRequest):BaseResponse<UserResponse> = userService.registerNewUser(userRequest)
}