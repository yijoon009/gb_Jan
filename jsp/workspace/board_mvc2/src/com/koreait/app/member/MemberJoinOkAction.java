package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;

//컨트롤러
public class MemberJoinOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
        vo.setMemberId(req.getParameter("memberId"));
        vo.setMemberPw(req.getParameter("memberPw"));
        vo.setMemberName(req.getParameter("memberName"));
        vo.setMemberAge(Integer.parseInt(req.getParameter("memberAge")));
        vo.setMemberGender(req.getParameter("memberGender"));
        vo.setMemberEmail(req.getParameter("memberEmail"));
        vo.setMemberZipcode(req.getParameter("memberZipcode"));
        vo.setMemberAddress(req.getParameter("memberAddress"));
        vo.setMemberAddressDetail(req.getParameter("memberAddressDetail"));
        vo.setMemberAddressEtc(req.getParameter("memberAddressEtc"));
		
		if(!dao.join(vo)) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");
			out.println("<script>alert('서버가 불안정합니다. 잠시 후 다시 시도해주세요.');</script>");
			out.close();
		}else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/MemberLogin.me");
		}
		
		//alert 창 띄우고 페이지 이동 :오류, 절대 불가능
		//컨트롤러에서 응답은 반드시 한 번만 가능하다
		
		return forward;
	}
	
}
