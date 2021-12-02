package app.trian.tabungan.model.request

import javax.validation.constraints.NotBlank

/**
 * UserLoginRequest
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 20.11
 */
data class UserLoginRequest(
    @field:NotBlank
    val username:String?,
    @field:NotBlank
    val password:String?
)
