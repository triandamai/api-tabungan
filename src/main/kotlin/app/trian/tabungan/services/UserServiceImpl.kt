package app.trian.tabungan.services

import app.trian.tabungan.model.request.UserRequest
import app.trian.tabungan.model.response.BaseResponse
import app.trian.tabungan.model.response.UserResponse
import app.trian.tabungan.services.`interface`.UserService
import org.springframework.data.domain.Pageable

/**
 * UserService impl
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 20.08
 */
class UserServiceImpl:UserService {
    override fun getListUser(pageable: Pageable): BaseResponse<List<UserResponse>> {
        TODO("Not yet implemented")
    }

    override fun getProfile(userId: Long): BaseResponse<UserResponse> {
        TODO("Not yet implemented")
    }

    override fun registerNewUser(userRequest: UserRequest): BaseResponse<UserResponse> {
        TODO("Not yet implemented")
    }

    override fun loginUser(username: UserRequest): BaseResponse<UserResponse> {
        TODO("Not yet implemented")
    }
}