package app.trian.tabungan.model.entity

import javax.persistence.*

@Entity
@Table(
    name = "tb_saving"
)
data class Saving(
    @Id
    @Column(
        name = "id_saving"
    )
    val idSaving:Long=0,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idWallet")
    val wallet:Wallet?=null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    val user:User?=null,

    @Column(
        name = "balance"
    )
    val balance:Double=0.0,

    @Column(
        name = "description"
    )
    val description:String ="",

    @Column(
        name = "note"
    )
    val note:String="",

    @Column(
        name = "receipt"
    )
    val receipt:String="",

    @Column(
        name = "granted_by"
    )
    val grantedBy:String="",

    @Column(
        name = "granted"
    )
    val granted:Boolean=false,

    @Column(
        name = "created_at"
    )
    val createdAt:Long=0,

    @Column(
        name = "updated_at"
    )
    val updatedAt:Long=0


)
