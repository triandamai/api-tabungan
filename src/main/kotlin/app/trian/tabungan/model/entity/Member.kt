package app.trian.tabungan.model.entity

import javax.persistence.*

@Entity
@Table(
    name = "tb_member"
)
data class Member(
    @Id
    @Column(
        name = "id_member"
    )
    var idMember:Long=0,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idWallet")
    var wallet:Wallet?=null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    var user:User?=null,

    @Column(name = "role")
    var role:ROLE_MEMBER=ROLE_MEMBER.MEMBER,

    @Column(name = "status_membership")
    var statusMembership:STATUS_MEMBER=STATUS_MEMBER.WAITING_CONFIRMATION,

    @Column(name = "created_at")
    var createdAt:Long=0,

    @Column(name = "updated_at")
    var updatedAt:Long=0

)

