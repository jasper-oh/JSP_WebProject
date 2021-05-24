package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.MentorMentoringCompleteTokenCheckDao;

public class MentorMentoringCompleteUpdatePaymentSendDateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("sendDate Update 진행");
		String strScheduledPk = request.getParameter("schedulepk");
		int scheduledPk = Integer.parseInt(strScheduledPk);
		System.out.println(scheduledPk);
		
		String token = request.getParameter("token");
		System.out.println(token);
		
		MentorMentoringCompleteTokenCheckDao mentorMentoringCompleteUpdateSendDateDao = new MentorMentoringCompleteTokenCheckDao();
		mentorMentoringCompleteUpdateSendDateDao.updateSendDate(scheduledPk,token );
		

	}

}
