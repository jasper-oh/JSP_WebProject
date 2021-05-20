package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PDao;



public class MenteeBookingCancelCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int paymentpk = Integer.parseInt( request.getParameter("paymentpk"));
		
		
		
		PDao dao = new PDao();
		dao.MenteeBookingCancel(paymentpk);

	}

}
