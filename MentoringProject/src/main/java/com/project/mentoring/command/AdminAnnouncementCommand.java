package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.AdminAnnouncementDao;
import com.project.mentoring.dto.AdminAnnouncementDto;

public class AdminAnnouncementCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		AdminAnnouncementDao adminAnnouncementDao = new AdminAnnouncementDao();
		ArrayList<AdminAnnouncementDto> adminAnnouncementDtos = adminAnnouncementDao.noticeList();
		request.setAttribute("noticeList", adminAnnouncementDtos);

	}

}
