package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PaymentDao;

public class MenteeReviewDeleteActionCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String strreviewpk = request.getParameter("reviewpk");
		int reviewpk = Integer.parseInt(strreviewpk);
		PaymentDao dao = new PaymentDao();
		dao.MMenteeReviewDeleteAction(reviewpk);


	}

}
