package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.MetorScheduleActionDao;
import com.project.mentoring.dao.PaymentDao;
import com.project.mentoring.dto.MenteeDto;
import com.project.mentoring.dto.ScheduleDto;
import com.project.mentoring.dto.ShareVar;

public class MentorScheduleListViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MetorScheduleActionDao dao = new MetorScheduleActionDao();
		ArrayList<ScheduleDto> dto = dao.ScheduleListView(ShareVar.productpk);

		
		request.setAttribute("MentorScheduleList", dto);
	}

}
