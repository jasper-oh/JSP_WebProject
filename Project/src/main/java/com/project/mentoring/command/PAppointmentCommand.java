package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PDao;
import com.project.mentoring.dto.PDto;

public class PAppointmentCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String productpk = request.getParameter("productpk");
		
		PDao dao = new PDao();
		PDto dto = dao.PAppointment(productpk);
		
		request.setAttribute("Appointment", dto);
	}

}
