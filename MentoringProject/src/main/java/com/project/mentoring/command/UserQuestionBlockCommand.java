package com.project.mentoring.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.QnaDao;

/**
 * 
 * 1. ClassName : 
 * 2. FileName          : UserQuestionBlockCommand.java
 * 3. Package           : com.project.mentoring.command
 * 4. Commnet           : 
 * 5. 작성자                       : biso
 * 6. 작성일                       : 2021. 5. 24. 오전 2:36:37
 */

public class UserQuestionBlockCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		int questionpk = Integer.parseInt(request.getParameter("questionpk"));
		QnaDao dao = new QnaDao();
		dao.UserQuestionBlock();
	}

}