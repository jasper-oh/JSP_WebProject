package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.QnaDao;


/**
 * 클래스설명 : 
 * @version : 2021. 5. 23.
 * @author : biso
 * @분류 : 
 * MentoringProject / package com.project.mentoring.command;
 */

public class UserQuestionInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String strUserPk = (String) session.getAttribute("userpk");
		int userpk = Integer.parseInt(strUserPk);
		String questiontitle = request.getParameter("questiontitle");
		String questiontext = request.getParameter("questiontext");
//		System.out.println(answertext);
		QnaDao dao = new QnaDao();
		dao.UserQuestionInsert(userpk, questiontitle, questiontext);
	}

}
