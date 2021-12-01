package app.trian.tabungan.model.response

/**
 * For base response
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 01/12/21 18.42
 */
data class BaseResponse<T>(
    val status:StatusResponse,
    val code:Int,
    val data:T,
    val message:String
)

enum class StatusResponse{
    OK,
    FAILED,
    UNKNOWN,
    UNAUTHORIZED,
    INTERNAL_ERROR,
    VALIDATION_ERROR,
    NOT_FOUND
}

val HTTP_OK=200
val HTTP_ERROR = 400
val HTTP_UNAUTHORIZeD = 401
val HTTP_NOTFOUND =404