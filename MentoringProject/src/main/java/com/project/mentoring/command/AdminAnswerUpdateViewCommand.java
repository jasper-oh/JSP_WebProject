package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.QnaDao;
import com.project.mentoring.dto.QnaDto;

/**
 * 클래스설명 : 
 * @version : 2021. 5. 23.
 * @author : biso
 * @분류 : 
 * MentoringProject / package com.project.mentoring.command;
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
