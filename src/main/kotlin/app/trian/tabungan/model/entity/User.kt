package app.trian.tabungan.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

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
    @Column(
        name = "id_user"
    )
    val idUser:Long=0,

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
        name = "name"
    )
    val name:String="",

    @Column(
        name="username"
    )
    val username:String="",

    @Column(
        name="password"
    )
    val password:String="",

    @Column(
        name="created_at"
    )
    val createdAt:Long=0,

    @Column(
        name="updated_at"
    )
    val updatedAt:Long=0

)
