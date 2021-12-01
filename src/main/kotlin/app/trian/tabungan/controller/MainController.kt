package app.trian.tabungan.controller

import app.trian.tabungan.model.response.BaseResponse
import app.trian.tabungan.model.response.HTTP_OK
import app.trian.tabungan.model.response.StatusResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {
    @GetMapping
    fun index():BaseResponse<String> = BaseResponse(
        status = StatusResponse.OK,
        code = HTTP_OK,
        message = "Welcome",
        data = "Api Tabungan"
    )
}