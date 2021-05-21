package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PDao;

public class MenteeMentoringReviewCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		

		String reviewtitle = request.getParameter("reviewtitle");
		String reviewtext = request.getParameter("reviewtext");
		String strreviewscore = request.getParameter("reviewscore");
		int reviewscore = Integer.parseInt(strreviewscore);
		String paymentpk = request.getParameter("paymentpk");
		
		System.out.println(paymentpk);
		
		// int userpk = session.getParameter("USERPK");
		// 병합시 유저피케이 넣어주기
		int userpk = 5;
		

		PDao dao = new PDao();
		dao.MMenteeMentoringReview(userpk, reviewtitle, reviewtext, reviewscore, paymentpk);

	}

}
