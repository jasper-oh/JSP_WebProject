package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.QnaDao;
import com.project.mentoring.dto.QnaDto;

/**
 * 
 * 1. ClassName : 
 * 2. FileName          : AdminAnswerUpdateViewCommand.java
 * 3. Package           : com.project.mentoring.command
 * 4. Commnet           : 
 * 5. 작성자                       : biso
 * 6. 작성일                       : 2021. 5. 24. 오전 2:34:27
 */
public class AdminAnswerUpdateViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int answerpk = Integer.parseInt(request.getParameter("answerpk"));
		QnaDao dao = new QnaDao();
		QnaDto dto = dao.AdminAnswerView(answerpk);
		request.setAttribute("QuestionList", dto);
	}

}
