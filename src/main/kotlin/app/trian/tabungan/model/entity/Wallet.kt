package app.trian.tabungan.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(
    name = "tb_wallet"
)
data class Wallet(
    @Id
    @Column(
        name="id_wallet"
    )
    var idWallet:Long=0,

    @OneToMany(
        mappedBy = "idMember",
        fetch = FetchType.EAGER,
        cascade = [CascadeType.ALL]
    )
    @Fetch(
        value = FetchMode.SUBSELECT
    )
    @JsonIgnore
    var members:List<Member> = emptyList(),

    @OneToMany(
        mappedBy = "idSaving",
        fetch = FetchType.EAGER,
        cascade = [CascadeType.ALL]
    )
    @Fetch(
        value = FetchMode.SUBSELECT
    )
    @JsonIgnore
    var savings:List<Saving> = emptyList(),

    @Column(
        name = "title"
    )
    var name:String="",

    @Column(
        name="description"
    )
    var description:String="",

    @Column(
        name="balance"
    )
    var balance:Double=0.0,

    @Column(
        name="created_by"
    )
    var createdBy:Long=0,

    @Column(
        name="created_at"
    )
    var createdAt:Long=0,

    @Column(
        name="updated_at"
    )
    var updatedAt:Long=0
)