package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PDao;
import com.project.mentoring.dto.PDto;

public class PProductSchedulSelectCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int pk = Integer.parseInt(request.getParameter("productpk"));
		PDao dao = new PDao();
		ArrayList<PDto> dto = dao.productSchedulelist(pk);
		request.setAttribute("ScheduleSelect", dto);
		
	}

}
