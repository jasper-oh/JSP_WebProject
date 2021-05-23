package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.AdminQnaDao;
import com.project.mentoring.dto.AdminQnaDto;

/**
 * 
 * 1. ClassName : 
 * 2. FileName          : AdminQnAListCommand.java
 * 3. Package           : com.project.mentoring.command
 * 4. Commnet           : 
 * 5. 작성자                       : biso
 * 6. 작성일                       : 2021. 5. 23. 오후 3:19:33
 */

public class AdminQnaListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String button = request.getParameter("button");					
		//String orderby = request.getParameter("orderby");			
		if(request.getParameter("button") == null) {
			button = "All";
		}
		System.out.println(button);
		AdminQnaDao dao = new AdminQnaDao();
		ArrayList<AdminQnaDto> dto = dao.AdminQnAList(button);
		request.setAttribute("QuestionData", dto);

	}

}
