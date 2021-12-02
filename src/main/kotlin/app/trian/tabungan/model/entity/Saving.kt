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
    var idSaving:Long=0,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idWallet")
    var wallet:Wallet?=null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    var user:User?=null,

    @Column(
        name = "balance"
    )
    var balance:Double=0.0,

    @Column(
        name = "description"
    )
    var description:String ="",

    @Column(
        name = "note"
    )
    var note:String="",

    @Column(
        name = "receipt"
    )
    var receipt:String="",

    @Column(
        name = "granted_by"
    )
    var grantedBy:String="",

    @Column(
        name = "granted"
    )
    var granted:Boolean=false,

    @Column(
        name = "created_at"
    )
    var createdAt:Long=0,

    @Column(
        name = "updated_at"
    )
    var updatedAt:Long=0


)
