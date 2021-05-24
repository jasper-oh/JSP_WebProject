package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminMajorListDao;
import com.project.mentoring.dto.AdminMajorListDto;

/**
 * 
 * 1. ClassName : 
 * 2. FileName          : AdminMajorUpdateViewCommand.java
 * 3. Package           : com.project.mentoring.command
 * 4. Commnet           : 
 * 5. 작성자                       : biso
 * 6. 작성일                       : 2021. 5. 24. 오전 1:45:42
 */
public class AdminMajorUpdateViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int majorpk = Integer.parseInt(request.getParameter("majorpk"));
		AdminMajorListDao dao = new AdminMajorListDao();
		AdminMajorListDto dto = dao.AdminMajorUpdateView(majorpk);
		request.setAttribute("Major", dto);
	}

}