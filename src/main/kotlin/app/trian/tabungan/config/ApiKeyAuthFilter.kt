package app.trian.tabungan.config

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter
import java.util.*
import javax.servlet.http.HttpServletRequest

/**
 * Filter responsible for getting the api key off of incoming requests that need to be authorized.
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 02/12/21 00.00
 */
class ApiKeyAuthFilter(val headerName:String):AbstractPreAuthenticatedProcessingFilter() {
    override fun getPreAuthenticatedPrincipal(request: HttpServletRequest?): String? {
        return request?.getHeader(headerName)
    }

    override fun getPreAuthenticatedCredentials(request: HttpServletRequest?): Any? {
        return null
    }
}