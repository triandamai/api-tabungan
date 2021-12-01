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
    val idMember:Long=0,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_wallet")
    val wallet:Wallet?=null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    val user:User?=null,

    @Column(name = "role")
    val role:ROLE_MEMBER=ROLE_MEMBER.MEMBER,

    @Column(name = "status_membership")
    val statusMembership:STATUS_MEMBER=STATUS_MEMBER.WAITING_CONFIRMATION,

    @Column(name = "created_at")
    val createdAt:Long=0,

    @Column(name = "updated_at")
    val updatedAt:Long=0

)

enum class ROLE_MEMBER{
    ADMIN,
    MEMBER,
    OWNER
}

enum class STATUS_MEMBER{
    ACTIVE,
    NONACTIVE,
    WAITING_CONFIRMATION
}