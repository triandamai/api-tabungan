package app.trian.tabungan.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(
    name = "tb_wallet"
)
data class Wallet(
    @Id
    val id:Long=0,

    @OneToMany(
        mappedBy = "member",
        fetch = FetchType.EAGER
    )
    @JsonIgnore
    var members:List<Member> = emptyList(),

    @Column(
        name = ""
    )
    val name:String=""
)