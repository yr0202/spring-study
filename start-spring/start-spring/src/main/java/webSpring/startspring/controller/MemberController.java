package webSpring.startspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import webSpring.startspring.service.MemberService;

@Controller
public class MemberController {
    // 1. 생성자 주입
    private final MemberService memberService;


    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /*
    // 2. 필드 주입
    @Autowired private MemberService memberService;

    // 3. setter 주입
    private MemberService memberService;

    @Autowired
    public setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
    */
}
