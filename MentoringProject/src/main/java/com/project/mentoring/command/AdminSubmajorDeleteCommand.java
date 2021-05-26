package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminSubMajorListDao;
import com.project.mentoring.dto.AdminSubMajorListDto;

public class AdminSubmajorDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String strMajorPk = request.getParameter("majorpk");
		String majorname = request.getParameter("majorname");
		String strsubmajorpk = request.getParameter("submajorpk");
		int majorPk = Integer.parseInt(strMajorPk);
		int submajorpk = Integer.parseInt(strsubmajorpk);
		
		AdminSubMajorListDao adminSubMajorListDao = new AdminSubMajorListDao();
		
		int result = adminSubMajorListDao.adminSubMajorDeleteAction(submajorpk);
		
		request.setAttribute("subMajorDeleteResult", result);
				
	}

}