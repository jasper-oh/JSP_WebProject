package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.QnaDao;

public class AdminAnswerUpdateActionCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		String strAdminPk = (String) session.getAttribute("adminpk");
//		int adminpk = Integer.parseInt(strAdminPk);
		int answerpk = Integer.parseInt(request.getParameter("answerpk"));
		String answertext = request.getParameter("answertext");
		System.out.println(answerpk + answertext);
		QnaDao dao = new QnaDao();
		dao.AdminAnswerUpdateAction(answerpk, answertext);
	}

}
