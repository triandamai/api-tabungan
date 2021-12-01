package app.trian.tabungan.repository

import app.trian.tabungan.model.entity.Member
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * Member repository
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 01/12/21 21.16
 */
interface MemberRepository:PagingAndSortingRepository<Member,Long> {
}