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
    @Id()
    @Column(
        name="id_wallet"
    )
    val id:Long=0,

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
    val savings:List<Saving> = emptyList(),

    @Column(
        name = "title"
    )
    val name:String="",

    @Column(
        name="description"
    )
    val description:String="",

    @Column(
        name="balance"
    )
    val balance:Double=0.0,

    @Column(
        name="created_by"
    )
    val createdBy:Long=0,

    @Column(
        name="created_at"
    )
    val createdAt:Long=0,

    @Column(
        name="updated_at"
    )
    val updatedAt:Long=0
)