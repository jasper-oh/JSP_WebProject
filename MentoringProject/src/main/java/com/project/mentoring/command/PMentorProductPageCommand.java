package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PaymentDao;
import com.project.mentoring.dto.PaymentDto;

public class PMentorProductPageCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String strpk = request.getParameter("productpk");	
		int productpk = Integer.parseInt(strpk);	
		PaymentDao dao = new PaymentDao();
		PaymentDto dto = dao.ProductPage(productpk);
		request.setAttribute("ProductPage", dto);
		ArrayList<PaymentDto> dtoS = dao.ProductList(productpk);
		request.setAttribute("ProductList", dtoS);
		

	}

}
