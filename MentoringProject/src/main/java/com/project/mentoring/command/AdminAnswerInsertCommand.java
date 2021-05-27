package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.QnaDao;
import com.project.mentoring.dto.QnaDto;

/**
 * 
 * 1. ClassName : 
 * 2. FileName          : AdminAnswerInsertCommand.java
 * 3. Package           : com.project.mentoring.command
 * 4. Commnet           : 
 * 5. 작성자                       : biso
 * 6. 작성일                       : 2021. 5. 24. 오후 2:34:48
 */

public class AdminAnswerInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		String strAdminPk = (String) session.getAttribute("adminpk");
//		int adminpk = Integer.parseInt(strAdminPk);
		int adminpk = 1;
		String answertext = request.getParameter("answertext");
//		System.out.println(answertext);
		QnaDao dao = new QnaDao();
		dao.AdminAnswerInsert(adminpk, answertext);
	}

}