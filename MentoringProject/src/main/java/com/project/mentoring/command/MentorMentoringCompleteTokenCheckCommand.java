package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.MentorMentoringCompleteTokenCheckDao;

public class MentorMentoringCompleteTokenCheckCommand implements IntCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String strScheduledPk = request.getParameter("schedulepk");
		int scheduledPk = Integer.parseInt(strScheduledPk);
		System.out.println(scheduledPk);
		String token = request.getParameter("token");
		System.out.println(token);
		
		MentorMentoringCompleteTokenCheckDao mentorMentoringCompleteTokenCheckDao = new MentorMentoringCompleteTokenCheckDao();
		
		int schedulePk = mentorMentoringCompleteTokenCheckDao.checkToken(token);
		int tokenCheckResult = 0;
		if(schedulePk !=0) {
			if(scheduledPk == schedulePk) {
				tokenCheckResult = 1;
			}else {
				tokenCheckResult = 0;
			}
		}else {
			tokenCheckResult = 0;
		}
		
		System.out.println(tokenCheckResult);
		
		return tokenCheckResult;
	}

}
