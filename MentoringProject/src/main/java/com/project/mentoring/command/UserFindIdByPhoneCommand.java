package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.project.mentoring.dao.UserFindIdDao;

public class UserFindIdByPhoneCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("username");
		String userPhone = request.getParameter("userphone");
		
		System.out.println(userName);
		System.out.println(userPhone);
		
		UserFindIdDao userFindIdByEmailDao = new UserFindIdDao();
		String userFindId = userFindIdByEmailDao.userFindIdByPhone(userName,userPhone);
		
		if(userFindId.equals("0")) {
			request.setAttribute("findIdResult", userFindId);
		}else {
			request.setAttribute("findIdResult", userFindId);
			
		}
		
	}

}