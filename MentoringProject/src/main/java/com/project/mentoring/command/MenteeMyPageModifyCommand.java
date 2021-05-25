package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.MenteeMyPageModifyDao;

public class MenteeMyPageModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String struserphone = request.getParameter("userphone");
				int userphone = Integer.parseInt(struserphone);
				String useremail = request.getParameter("useremail");
				HttpSession session = request.getSession();
				String strUserPk = (String) session.getAttribute("userpk");
				int userPk = Integer.parseInt(strUserPk);

				MenteeMyPageModifyDao menteeMyPageModifyDao = new MenteeMyPageModifyDao();
				menteeMyPageModifyDao.MenteeMyPageModify(userphone, useremail, userPk);

	}

}
