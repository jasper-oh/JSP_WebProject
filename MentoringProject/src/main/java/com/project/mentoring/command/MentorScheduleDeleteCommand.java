package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.MetorScheduleActionDao;
import com.project.mentoring.dao.PaymentDao;

public class MentorScheduleDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String strschedulewpk = request.getParameter("schedulepk");
		int schedulepk = Integer.parseInt(strschedulewpk);
		MetorScheduleActionDao dao = new MetorScheduleActionDao();
		dao.scheduleDeleteAction(schedulepk);

	}

}
