package servletproject.servletproject.web.frontcontroller.v3.controller;

import servletproject.servletproject.domain.member.Member;
import servletproject.servletproject.domain.member.MemberRepository;
import servletproject.servletproject.web.frontcontroller.ModelView;
import servletproject.servletproject.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }
}
