package app.trian.tabungan.utils

import app.trian.tabungan.model.request.UserRequest
import org.springframework.stereotype.Component
import javax.validation.ConstraintViolationException
import javax.validation.Validator


/**
 * Utility
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 01/12/21 18.54
 */
@Component
class ValidationUtil(
val validator:Validator
) {
    fun validate(any:Any){
        val result = validator.validate(any)
        if(result.size != 0 ){
            throw ConstraintViolationException(result)
        }
    }

    fun validateUser(
        userRequest: UserRequest
    ){
        val result = validator.validate(userRequest)
        if(result.size != 0){
            throw ConstraintViolationException(result)
        }
    }

    fun validateWallet(){

    }
}