package app.trian.tabungan.repository

import app.trian.tabungan.model.entity.Saving
import app.trian.tabungan.model.entity.User
import app.trian.tabungan.model.entity.Wallet
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * Saving repository
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 01/12/21 21.15
 */

interface SavingRepository:PagingAndSortingRepository<Saving,Long> {
    fun findAllByUserOrderByCreatedAtDesc(user: User,pageable: Pageable):Page<Saving>

    fun findAllByWalletOrderByCreatedAtDesc(wallet: Wallet,pageable: Pageable):Page<Saving>
}