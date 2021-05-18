package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminAnnouncementDao;


public class AdminAnnouncementWriteCommand implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String noticetitle = request.getParameter("noticetitle");
		String noticetext = request.getParameter("noticetext");

		
		AdminAnnouncementDao adminAnnouncementDao = new AdminAnnouncementDao();
		adminAnnouncementDao.write(noticetitle, noticetext);
	}
}
