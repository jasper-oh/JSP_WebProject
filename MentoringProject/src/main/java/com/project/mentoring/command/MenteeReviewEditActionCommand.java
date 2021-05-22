package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PaymentDao;

public class MenteeReviewEditActionCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String strreviewpk = request.getParameter("reviewpk");
		int reviewpk = Integer.parseInt(strreviewpk);
		String paymentpk = request.getParameter("paymentpk");
		String reviewtitle =request.getParameter("reviewtitle");
		String revietext = request.getParameter("reviewtext");
		String strreviewscore = request.getParameter("reviewscore");
		int reviewscore = Integer.parseInt(strreviewscore);
		PaymentDao dao = new PaymentDao();
		dao.MMenteeReviewEditAction(reviewpk, paymentpk, reviewtitle,revietext,strreviewscore,reviewscore);
	}

}
