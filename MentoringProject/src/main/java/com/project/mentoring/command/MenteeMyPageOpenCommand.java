package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.MenteeMyPageOpen;
import com.project.mentoring.dao.MentorProfileDao;
import com.project.mentoring.dto.MenteeMyPageOpenDto;
import com.project.mentoring.dto.MentorMyPageShowInfoDto;

public class MenteeMyPageOpenCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String strUserPk = (String) session.getAttribute("userpk");
		int userPk = Integer.parseInt(strUserPk);
//		System.out.println(userPk + " 야호오오");
//		
		MenteeMyPageOpen menteeMyPageOpenDao= new MenteeMyPageOpen();
		ArrayList<MenteeMyPageOpenDto> menteeMyPageOpenDto = menteeMyPageOpenDao.openMenteeMyPage(userPk);
		request.setAttribute("MenteeMyPageOpen", menteeMyPageOpenDto);

	}

}
