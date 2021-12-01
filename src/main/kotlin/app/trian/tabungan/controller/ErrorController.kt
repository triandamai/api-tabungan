package app.trian.tabungan.controller

import app.trian.tabungan.model.response.BaseResponse
import app.trian.tabungan.model.response.HTTP_ERROR
import app.trian.tabungan.model.response.StatusResponse
import org.hibernate.exception.ConstraintViolationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * Error Handling
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 01/12/21 18.43
 */

@RestControllerAdvice
class ErrorController {


    @ExceptionHandler(
        value = [
            ConstraintViolationException::class
        ]
    )
    fun constrainViolationException(error:ConstraintViolationException):BaseResponse<List<Any>> = BaseResponse(
        status = StatusResponse.FAILED,
        code = HTTP_ERROR,
        message = error.message ?:"",
        data = listOf()
    )

    @ExceptionHandler(
        value = [
            NullPointerException::class
        ]
    )
    fun nullPointerException(error:NullPointerException):BaseResponse<List<Any>> = BaseResponse(
        status = StatusResponse.INTERNAL_ERROR,
        code = HTTP_ERROR,
        message = error.message ?: "",
        data = listOf()
    )
}