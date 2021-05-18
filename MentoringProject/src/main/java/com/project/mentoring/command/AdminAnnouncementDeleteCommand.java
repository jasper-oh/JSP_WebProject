package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminAnnouncementDao;

public class AdminAnnouncementDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String noticepk = request.getParameter("noticepk");
		AdminAnnouncementDao adminAnnouncementDao = new AdminAnnouncementDao();
		adminAnnouncementDao.delete(noticepk);

	}

}
