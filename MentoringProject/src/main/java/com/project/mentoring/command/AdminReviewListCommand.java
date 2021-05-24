package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminReviewDao;
import com.project.mentoring.dto.AdminReviewDto;

public class AdminReviewListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String button = request.getParameter("button");			
		String where = request.getParameter("where");			
		String keyword = request.getParameter("keyword");			
		//String orderby = request.getParameter("orderby");			
		if(request.getParameter("button") == null) {
			button = "All";
		}
		if(request.getParameter("where") == null) {
			where = "null";
			keyword = "null";
			//orderby = "";
		}
		System.out.println(button);
		AdminReviewDao dao = new AdminReviewDao();
		ArrayList<AdminReviewDto> dto = dao.AdminReviewList(button, where, keyword);
		request.setAttribute("ReviewData", dto);

	}

}
