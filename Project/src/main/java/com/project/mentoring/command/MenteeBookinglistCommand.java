package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PDao;
import com.project.mentoring.dto.MenteeDto;

public class MenteeBookinglistCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//String booking = "감자";
		String booking = request.getParameter("booking");			
		if(request.getParameter("booking") == null) {
			booking = "null";
		}
		System.out.println(booking);
		PDao dao = new PDao();
		ArrayList<MenteeDto> dto = dao.MMenteeBookinglist(booking);

		
		request.setAttribute("MenteeBookingList", dto);
		

	}

}
