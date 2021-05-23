package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.QnaDao;
import com.project.mentoring.dto.QnaDto;
import com.project.mentoring.dto.ShareVar;

/**
 * 
 * 1. ClassName : 
 * 2. FileName          : AdminAnswerUpdateActionCommand.java
 * 3. Package           : com.project.mentoring.command
 * 4. Commnet           : 
 * 5. 작성자                       : biso
 * 6. 작성일                       : 2021. 5. 24. 오전 2:34:40
 */

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