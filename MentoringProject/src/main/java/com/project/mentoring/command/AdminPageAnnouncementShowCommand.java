package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminAnnouncementListDao;
import com.project.mentoring.dto.AdminAnnouncementListDto;

public class AdminPageAnnouncementShowCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		AdminAnnouncementListDao adminAnnouncementListDao = new AdminAnnouncementListDao();
		ArrayList<AdminAnnouncementListDto> announcementList = adminAnnouncementListDao.showAnnouncement();
		request.setAttribute("announcementList", announcementList);

	}

}
