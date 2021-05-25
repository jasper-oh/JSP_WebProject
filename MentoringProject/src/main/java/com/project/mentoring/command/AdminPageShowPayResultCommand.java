package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.AdminShowPayResultDao;
import com.project.mentoring.dto.adminShowPayResultDto;

public class AdminPageShowPayResultCommand implements Command {
	int numOfTuplesPerPage = 10;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			
		
		int requestPage = 1;
		
		AdminShowPayResultDao adminShowPayResultDao = new AdminShowPayResultDao();
		
		HttpSession session = request.getSession();
		
		if(request.getParameter("page") != null) {
			requestPage = Integer.parseInt(request.getParameter("page"));
			
			session.setAttribute("currentPage", requestPage);
		}
		
		
		
		int countedTuple = adminShowPayResultDao.countTuple();
		
		ArrayList<Integer> pageList = calcNumOfPage(countedTuple);
		
		session.setAttribute("pageList", pageList);
		
		ArrayList<adminShowPayResultDto> adminShowPayResultDto = adminShowPayResultDao.adminPayResultList(requestPage,numOfTuplesPerPage);
		
		request.setAttribute("PaymentData", adminShowPayResultDto);

	}
	
	
	public ArrayList<Integer> calcNumOfPage(int countedTuple) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int calcPage = 0;
		// 튜플의 총 갯수가 딱 맞아떨어지는 경우를 대비해 조건분기
		if (countedTuple % numOfTuplesPerPage == 0) {
			calcPage = countedTuple / numOfTuplesPerPage;
		} else {
			calcPage = countedTuple / numOfTuplesPerPage + 1;
		}
		
		for (int i = 1; i <= calcPage; i++) {
			System.out.println(i);
			arr.add(i);
		}
		return arr;
	}

}
