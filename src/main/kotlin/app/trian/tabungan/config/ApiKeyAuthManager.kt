package app.trian.tabungan.config

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.Authentication

/**
 * Handles authenticating api keys against the database.
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 00.03
 */
class ApiKeyAuthManager(

) : AuthenticationManager{
    override fun authenticate(authentication: Authentication?): Authentication {
        val principal = authentication?.principal ?:""

       throw ConcurrentModificationException()
    }

}