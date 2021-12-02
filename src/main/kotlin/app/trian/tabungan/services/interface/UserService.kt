package app.trian.tabungan.services.`interface`

import app.trian.tabungan.model.request.UserLoginRequest
import app.trian.tabungan.model.request.UserRequest
import app.trian.tabungan.model.response.BaseCollectionPageable
import app.trian.tabungan.model.response.BaseResponse
import app.trian.tabungan.model.response.UserResponse
import org.springframework.data.domain.Pageable

/**
 * User Service
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 20.06
 */
interface UserService {
    fun getListUser(pageable: Pageable):BaseResponse<BaseCollectionPageable<UserResponse>>

    fun getProfile(userId:Long):BaseResponse<UserResponse>

    fun registerNewUser(userRequest: UserRequest):BaseResponse<UserResponse>

    fun loginUser(request: UserLoginRequest):BaseResponse<UserResponse>


}