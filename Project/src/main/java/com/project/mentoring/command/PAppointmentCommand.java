package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PDao;
import com.project.mentoring.dto.AppointmentDto;
import com.project.mentoring.dto.PDto;
import com.project.mentoring.dto.ShareVar;

public class PAppointmentCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int productpk = Integer.parseInt(request.getParameter("productpk"));
		ShareVar.productpk = productpk;
		//System.out.println(ShareVar.productpk);
		PDao dao = new PDao();
		PDto dto = dao.PAppointment(productpk);
		request.setAttribute("Appointment", dto);
		ArrayList<AppointmentDto> dtoR = dao.ProductReviewList(productpk);
		request.setAttribute("ReviewList", dtoR);
	}

}
