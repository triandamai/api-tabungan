package app.trian.tabungan.controller

import app.trian.tabungan.model.request.MemberRequest
import app.trian.tabungan.services.`interface`.MemberService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

/**
 * Member controller
 * Created By Trian Damai
 * https://github.com/triandamai
 * Created At 11.08
 */

@RestController
class MemberController(
    private val memberService: MemberService
) {
    @GetMapping(
        value = ["api/v1/member/{id_user}"],
        produces = ["application/json"]
    )
    fun getMemberByUser(@PathVariable("id_user") idUser:Long,pageable: Pageable) =
        memberService.getWalletByUser(idUser,pageable)

    @PostMapping(
        value = ["api/v1/member"],
        consumes = ["application/json", ],
        produces = ["application/json"]
    )
    fun addMember(@RequestBody request: MemberRequest) =
        memberService.addNewMember(request)

    @PostMapping(
        value = ["api/v1/member/leave"],
        consumes = ["application/json", ],
        produces = ["application/json"]
    )
    fun leaveMember(@RequestBody request: MemberRequest)=
        memberService.leaveMembership(request)

    @PostMapping(
        value = ["api/v1/member/disable"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun disableMember(@RequestBody request: MemberRequest)=
        memberService.disableMember(request)

    @PostMapping(
        value = ["api/v1/member/makeowner"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun makeMemberOwner(@RequestBody request: MemberRequest)=
        memberService.makeMemberOwner(request)

    @PostMapping(
        value = ["api/v1/member/makeadmin"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun makeMemberAdmin(@RequestBody request: MemberRequest)=
        memberService.makeMemberAdmin(request)


    @PostMapping(
        value = ["api/v1/member/makemember"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun makeMemberAMember(@RequestBody request: MemberRequest)=
        memberService.makeMemberMember(request)


}