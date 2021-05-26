package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.UserFindPwDao;

public class UserFindPwCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String userId = request.getParameter("userid");
		String userName = request.getParameter("username");
		String userPhone = request.getParameter("userphone");
		
		UserFindPwDao userFindPwDao = new UserFindPwDao();
		
		String userPw = userFindPwDao.userFindPw(userId,userName,userPhone);
		
		if(userPw.equals("0")) {
			request.setAttribute("findPwResult", userPw);
		}else {
			request.setAttribute("findPwResult", userPw);
			
		}

	}
}