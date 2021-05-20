package com.project.mentoring.command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PDao;
import com.project.mentoring.dto.PDto;

public class PPaymentcommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		PDao dao = new PDao();
		PDto dto = dao.PPayment();
		
		request.setAttribute("Payment", dto);

	}

}
