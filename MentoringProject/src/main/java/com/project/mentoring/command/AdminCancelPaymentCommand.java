package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminShowPayResultDao;

public class AdminCancelPaymentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String paymentPk = request.getParameter("paymentPk");
		
		AdminShowPayResultDao adminPayResultDao = new AdminShowPayResultDao();
		
		adminPayResultDao.cancelPayment(paymentPk);
	}

}
