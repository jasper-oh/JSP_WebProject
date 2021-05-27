package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.MentorProfileDao;
import com.project.mentoring.dto.HomePageMentorListDto;

public class HomePageMentorListShowCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MentorProfileDao mentorProfileListDao = new MentorProfileDao();
		ArrayList<HomePageMentorListDto> mentorListDto1 = mentorProfileListDao.getMentorProfileToHomePage(43);
		ArrayList<HomePageMentorListDto> mentorListDto2= mentorProfileListDao.getMentorProfileToHomePage(44);
		ArrayList<HomePageMentorListDto> mentorListDto3 = mentorProfileListDao.getMentorProfileToHomePage(45);
		ArrayList<HomePageMentorListDto> mentorListDto4 = mentorProfileListDao.getMentorProfileToHomePage(46);
		request.setAttribute("mentorProfile1", mentorListDto1 );
		request.setAttribute("mentorProfile2", mentorListDto2 );
		request.setAttribute("mentorProfile3", mentorListDto3 );
		request.setAttribute("mentorProfile4", mentorListDto4 );
		
		HttpSession session = request.getSession();
		session.setAttribute("userCheck", -1);

	}

}
