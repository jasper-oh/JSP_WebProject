package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PaymentDao;
import com.project.mentoring.dto.PaymentDto;
import com.project.mentoring.dto.ShareVar;

public class PMentorProductPageCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String strpk = request.getParameter("productpk");	
		ShareVar.productpk = Integer.parseInt(strpk);
		PaymentDao dao = new PaymentDao();
		PaymentDto dto = dao.ProductPage(ShareVar.productpk);
		request.setAttribute("ProductPage", dto);

	}

}
