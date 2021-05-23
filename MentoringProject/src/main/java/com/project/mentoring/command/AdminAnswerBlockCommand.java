package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.QnaDao;


/**
 * 
 * 1. ClassName : 
 * 2. FileName          : AdminAnswerBlockCommand.java
 * 3. Package           : com.project.mentoring.command
 * 4. Commnet           : 
 * 5. 작성자                       : biso
 * 6. 작성일                       : 2021. 5. 24. 오전 2:35:32
 */
public class AdminAnswerBlockCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		String strAdminPk = (String) session.getAttribute("adminpk");
//		int adminpk = Integer.parseInt(strAdminPk);
		int answerpk = Integer.parseInt(request.getParameter("answerpk"));
		int check = Integer.parseInt(request.getParameter("check"));
		QnaDao dao = new QnaDao();
		dao.AdminAnswerBlock(answerpk, check);
	}

}