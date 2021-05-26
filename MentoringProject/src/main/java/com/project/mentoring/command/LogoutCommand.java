package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("세션값 제거! ");
		
		HttpSession session = request.getSession();
		session.removeAttribute("userid");
		session.removeAttribute("userpk");
		session.removeAttribute("usename");
		session.setAttribute("userCheck", -1);
		
		
	}

}
