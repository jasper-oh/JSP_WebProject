package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.QnaDao;


/**
 * 
 * 1. ClassName : 
 * 2. FileName          : UserQuestionInsertCommand.java
 * 3. Package           : com.project.mentoring.command
 * 4. Commnet           : 
 * 5. 작성자                       : biso
 * 6. 작성일                       : 2021. 5. 24. 오전 2:36:46
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