package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.QnaDao;
import com.project.mentoring.dto.QnaDto;
import com.project.mentoring.dto.ShareVar;

/**
 * 클래스설명 : 
 * @version : 2021. 5. 23.
 * @author : biso
 * @분류 : 
 * MentoringProject / package com.project.mentoring.command;
 */

public class AdminQnaViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if (request.getParameter("questionpk") != null) {
			int questionpk = Integer.parseInt(request.getParameter("questionpk"));
			ShareVar.questionpk = questionpk;			
		}
		//System.out.println(ShareVar.productpk);
		QnaDao dao = new QnaDao();
		QnaDto dto = dao.AdminQnaView();
		request.setAttribute("QuestionData", dto);
		ArrayList<QnaDto> dto2 = dao.AdminAnswerList();
		request.setAttribute("AnswerList", dto2);
		
	}

}