package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.MentorProductUpdateDao;

public class MentorProductUpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("프러덕트 업데이트 들어옴 ");
		String productPk = request.getParameter("productpk");
		System.out.println(productPk + "무야호");
		
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String introduce = request.getParameter("introduce");
		
		MentorProductUpdateDao mentorProductUpdateDao = new MentorProductUpdateDao();
		
		int productUpdateResult = mentorProductUpdateDao.updateProduct(productPk,title,price,introduce);
		request.setAttribute("updateResult", productUpdateResult);
		
	}

}
