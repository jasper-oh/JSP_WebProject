package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.MentorReviewViewDao;
import com.project.mentoring.dao.MentorScheduleActionDao;
import com.project.mentoring.dao.PaymentDao;
import com.project.mentoring.dto.MentorReviewViewDto;
import com.project.mentoring.dto.PaymentDto;
import com.project.mentoring.dto.ScheduleDto;
import com.project.mentoring.dto.ShareVar;

public class PMentorProductPageCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(request.getParameter("productpk")!=null) {
			String strpk = request.getParameter("productpk");	
			ShareVar.productpk = Integer.parseInt(strpk);			
		}
		PaymentDao dao = new PaymentDao();
		PaymentDto dto = dao.ProductPage(ShareVar.productpk);
		request.setAttribute("ProductPage", dto);
		//---------------------------------------------------------------
		MentorScheduleActionDao ScheduleDao = new MentorScheduleActionDao();
		ArrayList<ScheduleDto> ScheduleDto = ScheduleDao.ScheduleListView(ShareVar.productpk);
		request.setAttribute("MentorScheduleList", ScheduleDto);
		//---------------------------------------------------------------
		MentorReviewViewDao ReviewDao = new MentorReviewViewDao();
		HttpSession session = request.getSession();
		String strUserPk = (String) session.getAttribute("userpk");
		int userPk = Integer.parseInt(strUserPk);
		ArrayList<MentorReviewViewDto> ReviewDto = ReviewDao.ProductReviewList(userPk);
		request.setAttribute("mentorReviewView", ReviewDto);
	}

}
