package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PaymentDao;
import com.project.mentoring.dto.ShareVar;

public class PScheduleInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String startday = request.getParameter("startday");
		String endday = request.getParameter("endday");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		System.out.println(startday+ endday+ starttime+ endtime+ ShareVar.productpk);
		PaymentDao dao=new PaymentDao();
		dao.createschedule(startday, endday, starttime, endtime, ShareVar.productpk);
	}

}
