package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.MentorScheduleActionDao;

public class MentorScheduleDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String strschedulewpk = request.getParameter("schedulepk");
		int schedulepk = Integer.parseInt(strschedulewpk);
		MentorScheduleActionDao dao = new MentorScheduleActionDao();
		dao.scheduleDeleteAction(schedulepk);

	}

}
