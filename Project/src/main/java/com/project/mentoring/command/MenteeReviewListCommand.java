package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PDao;
import com.project.mentoring.dto.MenteeDto;

public class MenteeReviewListCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PDao dao = new PDao();
		ArrayList<MenteeDto> dto = dao.MMenteeReviewList();
		
		request.setAttribute("MenteeReviewList", dto);

	}

}
