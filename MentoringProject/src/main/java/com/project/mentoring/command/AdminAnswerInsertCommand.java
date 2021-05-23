package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.QnaDao;
import com.project.mentoring.dto.QnaDto;

/**
 * 클래스설명 : 
 * @version : 2021. 5. 23.
 * @author : biso
 * @분류 : 
 * MentoringProject / package com.project.mentoring.command;
 */

public class AdminAnswerInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		String strAdminPk = (String) session.getAttribute("adminpk");
//		int adminpk = Integer.parseInt(strAdminPk);
		int adminpk = 3;
		String answertext = request.getParameter("answertext");
//		System.out.println(answertext);
		QnaDao dao = new QnaDao();
		dao.AdminAnswerInsert(adminpk, answertext);
	}

}
