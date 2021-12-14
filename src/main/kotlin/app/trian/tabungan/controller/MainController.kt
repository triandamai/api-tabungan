package app.trian.tabungan.controller

import app.trian.tabungan.model.response.BaseResponse
import app.trian.tabungan.model.response.HTTP_OK
import app.trian.tabungan.model.response.StatusResponse
import app.trian.tabungan.services.`interface`.FileService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class MainController(
    private val fileService: FileService
) {
    @GetMapping
    fun index():BaseResponse<String> = BaseResponse(
        status = StatusResponse.OK,
        code = HTTP_OK,
        message = "Welcome",
        data = "Api Tabungan"
    )

    @PostMapping(
        value = ["api/v1/upload"],
        consumes = [
           "multipart/form-data"
        ],
        produces = [
            "application/json"
        ]
    )
    fun upload(
        @RequestPart("file") file:MultipartFile):BaseResponse<String> {
        val file = fileService.save(file)
        return BaseResponse(
            status = StatusResponse.OK,
            data = "",
            message = "",
            code = HTTP_OK
        )
    }
}