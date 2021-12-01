package app.trian.tabungan.repository

import app.trian.tabungan.model.entity.User
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * User repository
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 01/12/21 21.16
 */

interface UserRepository:PagingAndSortingRepository<User,Long> {

}