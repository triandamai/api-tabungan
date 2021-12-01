package app.trian.tabungan.repository

import app.trian.tabungan.model.entity.Saving
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * Saving repository
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 01/12/21 21.15
 */

interface SavingRepository:PagingAndSortingRepository<Saving,Long> {

}