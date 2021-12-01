package app.trian.tabungan.model.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * User
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 01/12/21 19.41
 */
@Entity
@Table(
    name = "tb_user"
)
data class User(
    @Id
    val id_user:Long=0
)
