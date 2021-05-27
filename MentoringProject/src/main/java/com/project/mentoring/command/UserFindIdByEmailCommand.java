package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.project.mentoring.dao.UserFindIdDao;

public class UserFindIdByEmailCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("username");
		String userEmail = request.getParameter("useremail");
		
		System.out.println(userName);
		System.out.println(userEmail);
		
		UserFindIdDao userFindIdByEmailDao = new UserFindIdDao();
		String userFindId = userFindIdByEmailDao.userFindId(userName,userEmail);
		
		if(userFindId.equals("0")) {
			request.setAttribute("findIdResult", userFindId);
			
		}else {
			request.setAttribute("findIdResult", userFindId);
			
		}
		
		
	}

}