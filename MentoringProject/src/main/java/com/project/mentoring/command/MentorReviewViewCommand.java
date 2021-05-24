package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.MentorReviewViewDao;
import com.project.mentoring.dto.MentorReviewViewDto;

public class MentorReviewViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MentorReviewViewDao dao = new MentorReviewViewDao();
		
		HttpSession session = request.getSession();
		String strUserPk = (String) session.getAttribute("userpk");
		int userPk = Integer.parseInt(strUserPk);
		
		System.out.println(userPk);
		
		
		ArrayList<MentorReviewViewDto> dto = dao.showReviewView(userPk);
		request.setAttribute("mentorReviewView", dto);
		
		System.out.println("out");
	}

}
