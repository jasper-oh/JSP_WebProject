package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PDao;
import com.project.mentoring.dto.PDto;

public class PMentorProductPageCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String strpk = request.getParameter("productpk");	
		int pk = Integer.parseInt(strpk);	
		PDao dao = new PDao();
		PDto dto = dao.ProductPage(pk);
		request.setAttribute("ProductPage", dto);

	}

}
