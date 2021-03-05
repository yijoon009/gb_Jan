package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;

public class MemberJoinOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		ActionForward forward = null;
		
		MemberDAO dao = new MemberDAO();
		MemberVO member = new MemberVO();
		
		member.setMemberId(req.getParameter("memberId"));
		member.setMemberPw(req.getParameter("memberPw"));
		member.setMemberName(req.getParameter("memberName"));
		member.setMemberAge(Integer.parseInt(req.getParameter("memberAge")));
		member.setMemberGender(req.getParameter("memberGender"));
		member.setMemberEmail(req.getParameter("memberEmail"));
		member.setMemberZipcode(req.getParameter("memberZipcode"));
		member.setMemberAddress(req.getParameter("memberAddress"));
		member.setMemberAddressDetail(req.getParameter("memberAddressDetail"));
		member.setMemberAddressEtc(req.getParameter("memberAddressEtc"));
		
		if(!dao.join(member)) {
			//실패
			PrintWriter out = resp.getWriter();
			resp.setCharacterEncoding("text/html;charset=utf-8");
			out.print("<script>alert('서버가 불안정합니다. 잠시 후 다시 시도해주세요.');</script>");
			out.close();
		}else {
			//성공
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/MemberLogin.me");
		}
		return forward;
	}

}
