package app.trian.tabungan.repository

import app.trian.tabungan.model.entity.Wallet
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * Wallet Repository
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 01/12/21 20.11
 */
interface WalletRepository:PagingAndSortingRepository<Wallet,Long> {

}