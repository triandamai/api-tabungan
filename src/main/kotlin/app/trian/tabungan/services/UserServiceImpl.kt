package app.trian.tabungan.services

import app.trian.tabungan.model.entity.User
import app.trian.tabungan.model.request.UserLoginRequest
import app.trian.tabungan.model.request.UserRequest
import app.trian.tabungan.model.request.toUser
import app.trian.tabungan.model.response.*
import app.trian.tabungan.repository.UserRepository
import app.trian.tabungan.services.`interface`.UserService
import app.trian.tabungan.utils.AuthenticationException
import app.trian.tabungan.utils.DataExistUniqueException
import app.trian.tabungan.utils.ValidationUtil
import org.joda.time.DateTime
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
    private val userRepository: UserRepository,
    private val validationUtil: ValidationUtil
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

        //validate first
        validationUtil.validate(userRequest)

        //check if user already exist
        val check = userRepository.findTopByUsername(userRequest.username!!)

        if(check != null){
            throw DataExistUniqueException(message = "Username already exist!")
        }
        val date = DateTime()
        val createdUser = userRepository.save(userRequest.toUser(
            password = "",
            idUser = date.millis,
            createdAt = date.millis,
            updatedAt = date.millis
        ))

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = createdUser.toResponse(),
            message = "Success registering a new user"
        )
    }

    override fun loginUser(request: UserLoginRequest): BaseResponse<UserResponse> {
        //validate first
        validationUtil.validate(request)

        val userCheck = userRepository.findTopByUsername(request.username!!)
            ?: throw AuthenticationException("User with ${request.username} not found")

       if(userCheck.password != request.password){
            throw AuthenticationException("username and password not match with any user")
       }

        return BaseResponse(
            status = StatusResponse.OK,
            code = HTTP_OK,
            data = userCheck.toResponse(),
            message = "Login success! feel free use all feature"
        )
    }
}