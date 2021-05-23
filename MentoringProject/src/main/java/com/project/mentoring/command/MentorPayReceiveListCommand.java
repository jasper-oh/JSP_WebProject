package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.MentorPayReceiveListDao;
import com.project.mentoring.dto.MentorPayReceiveListDto;

public class MentorPayReceiveListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MentorPayReceiveListDao mentorPayReceiveListDao = new MentorPayReceiveListDao();
		
		HttpSession session = request.getSession();
		String strUserPk = (String) session.getAttribute("userpk");
		int userPk = Integer.parseInt(strUserPk);
		
		System.out.println(userPk);
		
		
		ArrayList<MentorPayReceiveListDto> mentorPayReceiveListDto = mentorPayReceiveListDao.showPayReceiveList(userPk);
		request.setAttribute("mentorPayReceiveList", mentorPayReceiveListDto);
		
		System.out.println("out");
	}

}
