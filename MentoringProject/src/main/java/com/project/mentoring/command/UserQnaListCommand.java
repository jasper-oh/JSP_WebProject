package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.QnaDao;
import com.project.mentoring.dto.QnaDto;

/**
 * 
 * 1. ClassName : 
 * 2. FileName          : AdminQnAListCommand.java
 * 3. Package           : com.project.mentoring.command
 * 4. Commnet           : 
 * 5. 작성자                       : biso
 * 6. 작성일                       : 2021. 5. 23. 오후 3:19:33
 */

public class UserQnaListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String strUserPk = (String) session.getAttribute("userpk");
		int userpk = Integer.parseInt(strUserPk);
		
		QnaDao dao = new QnaDao();
		ArrayList<QnaDto> dto = dao.UserQnAList(userpk);
		request.setAttribute("QuestionList", dto);
		
		
	}

}
