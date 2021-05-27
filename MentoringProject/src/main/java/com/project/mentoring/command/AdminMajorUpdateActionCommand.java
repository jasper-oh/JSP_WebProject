package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminMajorListDao;
import com.project.mentoring.dto.AdminMajorListDto;


/**
 * 
 * 1. ClassName : 
 * 2. FileName          : AdminMajorUpdateActionCommand.java
 * 3. Package           : com.project.mentoring.command
 * 4. Commnet           : 
 * 5. 작성자                       : biso
 * 6. 작성일                       : 2021. 5. 24. 오전 1:45:42
 */
public class AdminMajorUpdateActionCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int majorpk = Integer.parseInt(request.getParameter("majorpk"));
		String majorname = request.getParameter("majorname");
		AdminMajorListDao dao = new AdminMajorListDao();
		int result = dao.adminMajorUpdateAction(majorpk, majorname);
		request.setAttribute("result", result);
	}

}
