package app.trian.tabungan.services

import app.trian.tabungan.model.entity.User
import app.trian.tabungan.model.request.UserLoginRequest
import app.trian.tabungan.model.request.UserRequest
import app.trian.tabungan.model.request.toUser
import app.trian.tabungan.model.response.*
import app.trian.tabungan.repository.UserRepository
import app.trian.tabungan.services.`interface`.UserService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * UserService impl
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 20.08
 */
@Service
class UserServiceImpl(
    private val userRepository: UserRepository
):UserService {
    override fun getListUser(pageable: Pageable): BaseResponse<BaseCollectionPageable<UserResponse>> {
        val users = userRepository.findAll(pageable)
        val transformCollection = users.content.map {
            it.toResponse()
        }

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = BaseCollectionPageable(
                data = transformCollection,
                page = users.number,
                totalPage = users.totalPages,
                totalELement = users.numberOfElements,
                size = users.size
            ),
            message = "success get data users"
        )

    }

    override fun getProfile(userId: Long): BaseResponse<UserResponse> {
        val users = userRepository.findById(userId)

        return BaseResponse(
            status = StatusResponse.OK,
            data = users.map { it.toResponse() }.get(),
            code = HTTP_OK,
            message = "Your detail profile here"
        )
    }

    override fun registerNewUser(userRequest: UserRequest): BaseResponse<UserResponse> {

        val createdUser = userRepository.save(userRequest.toUser(
            password = "",
            idUser = 0,
            createdAt = 0,
            updatedAt = 0
        ))

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = createdUser.toResponse(),
            message = "Success inserting"
        )
    }

    override fun loginUser(request: UserLoginRequest): BaseResponse<UserResponse> {
        TODO("Not yet implemented")
    }
}