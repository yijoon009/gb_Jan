package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;

public class MemberLoginOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		
		MemberDAO dao = new MemberDAO();
		HttpSession session = req.getSession();
		
		if(dao.login(req.getParameter("memberId"), req.getParameter("memberPw"))) {
			//성공
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/board/BoardList.bo");
			session.setAttribute("session_id", req.getParameter("memberId"));
		}else {
			//실패
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/MemberLogin.me?login=false");
		}
		
		return forward;
	}

}
