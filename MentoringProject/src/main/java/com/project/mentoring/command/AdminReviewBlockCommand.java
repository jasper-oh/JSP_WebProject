package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminReviewDao;

public class AdminReviewBlockCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//				String button = request.getParameter("button");
				int blindcheck = Integer.parseInt(request.getParameter("id"));
				int reviewpk = Integer.parseInt(request.getParameter("reviewpk"));
				AdminReviewDao dao = new AdminReviewDao();
				dao.AdminReviewBlind(blindcheck, reviewpk);
	}

}
