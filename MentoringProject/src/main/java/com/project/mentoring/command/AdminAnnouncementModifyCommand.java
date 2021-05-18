package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminAnnouncementDao;



public class AdminAnnouncementModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String noticepk = request.getParameter("admin_adminpk");
		String admin_adminpk = request.getParameter("admin_adminpk");
		String noticeTitle = request.getParameter("noticeTitle");
		String noticetext = request.getParameter("noticetext");
		
		AdminAnnouncementDao adminAnnouncementDao = new AdminAnnouncementDao();
		adminAnnouncementDao.modify(noticepk, admin_adminpk, noticeTitle, noticetext);

	}

}
