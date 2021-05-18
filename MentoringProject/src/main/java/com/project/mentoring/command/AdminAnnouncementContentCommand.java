package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminAnnouncementDao;
import com.project.mentoring.dto.AdminAnnouncementDto;


public class AdminAnnouncementContentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bId = request.getParameter("bId");
		AdminAnnouncementDao adminAnnouncementDao = new AdminAnnouncementDao();
		AdminAnnouncementDto adminAnnouncementDto = adminAnnouncementDao.adminAnnouncementContentView(bId);
		
		request.setAttribute("adminAnnouncementContentView", adminAnnouncementDto);
	}
}