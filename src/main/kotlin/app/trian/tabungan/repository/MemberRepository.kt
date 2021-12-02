package app.trian.tabungan.repository

import app.trian.tabungan.model.entity.Member
import app.trian.tabungan.model.entity.User
import app.trian.tabungan.model.entity.Wallet
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * Member repository
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 01/12/21 21.16
 */
interface MemberRepository:PagingAndSortingRepository<Member,Long> {
    fun findAllByUser(user: User, pageable: Pageable):Page<Member>

    fun findByUserAndWallet(user: User, wallet: Wallet):Member?

}