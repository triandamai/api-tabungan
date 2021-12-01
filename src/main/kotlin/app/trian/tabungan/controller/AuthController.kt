package app.trian.tabungan.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
* Auth Controller
* Created By Trian Damai
* https://github.com/triandamai
* Created At 11.04
*/
@RestController
class AuthController {
    @GetMapping(
        name = "login",
        value=[
            "/login"
        ]
    )
    fun login():String{
        return  "hahah"
    }
}