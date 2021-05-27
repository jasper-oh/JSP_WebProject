package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.QnaDao;
import com.project.mentoring.dto.QnaDto;
import com.project.mentoring.dto.ShareVar;

/**
 * 
 * 1. ClassName : 
 * 2. FileName          : UserQnaViewCommand.java
 * 3. Package           : com.project.mentoring.command
 * 4. Commnet           : 
 * 5. 작성자                       : biso
 * 6. 작성일                       : 2021. 5. 24. 오전 2:36:17
 */

public class UserQnaViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if (request.getParameter("questionpk") != null) {
			int questionpk = Integer.parseInt(request.getParameter("questionpk"));
			ShareVar.questionpk = questionpk;			
		}
		System.out.println(ShareVar.questionpk);
		//System.out.println(ShareVar.productpk);
		QnaDao dao = new QnaDao();
		QnaDto dto = dao.AdminQnaView();
		request.setAttribute("QuestionData", dto);
		ArrayList<QnaDto> dto2 = dao.AdminAnswerList();
		request.setAttribute("AnswerList", dto2);
		
	}
}
