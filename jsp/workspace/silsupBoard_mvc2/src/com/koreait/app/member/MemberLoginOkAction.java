package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;

public class MemberLoginOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		
		MemberDAO dao = new MemberDAO();
		if(dao.login(req.getParameter("memberId"), req.getParameter("memberPw"))) {
			//성공
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/board/BoardList.bo");
		}else {
			//실패
			PrintWriter out = resp.getWriter();
			resp.setCharacterEncoding("text/html;charset=utf-8");
			out.println("<script>alert('서버가 불안정합니다. 잠시 후 다시 시도해주세요.');</script>");
			out.close();
		}
		
		return null;
	}

}
