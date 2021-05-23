package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.MentorProfileDao;
import com.project.mentoring.dto.MentorMyPageShowInfoDto;

public class MentorInfoShowCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("커맨드 들어옴");
		HttpSession session = request.getSession();
		String strUserPk = (String) session.getAttribute("userpk");
		int userPk = Integer.parseInt(strUserPk);
		System.out.println(userPk + " 야호오오");
		
		MentorProfileDao mentorInfoShowDao= new MentorProfileDao();
		ArrayList<MentorMyPageShowInfoDto> mentorMyPageInfoDto = mentorInfoShowDao.getMentorMyPageShowInfo(userPk);
		request.setAttribute("mentorMyPageInfo", mentorMyPageInfoDto);
		
	}

}
