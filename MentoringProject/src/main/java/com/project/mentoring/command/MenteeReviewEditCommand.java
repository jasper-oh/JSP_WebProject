package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PaymentDao;
import com.project.mentoring.dto.MenteeDto;

public class MenteeReviewEditCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String strreviewpk = request.getParameter("reviewpk");
		int reviewpk = Integer.parseInt(strreviewpk);
		PaymentDao dao = new PaymentDao();
		ArrayList<MenteeDto> dto = dao.MMenteeReviewEditPage(reviewpk);
		request.setAttribute("MenteeReviewList", dto);
	}

}
