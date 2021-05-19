package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PDao;
import com.project.mentoring.dto.PDto;
import com.project.mentoring.dto.ShareVar;

public class PProductScheduleSelectCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ShareVar.schedulepk = Integer.parseInt(request.getParameter("schedulepk"));
		System.out.println(ShareVar.schedulepk);
		PDao dao = new PDao();
		PDto dto = dao.beforepayment(ShareVar.schedulepk);
		
		request.setAttribute("Appointment", dto);
	}

}
