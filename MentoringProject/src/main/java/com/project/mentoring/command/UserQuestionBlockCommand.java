package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

public class UserQuestionBlockCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		int questionpk = Integer.parseInt(request.getParameter("questionpk"));
		QnaDao dao = new QnaDao();
		dao.UserQuestionBlock();
	}

}