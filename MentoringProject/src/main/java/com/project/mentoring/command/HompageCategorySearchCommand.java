package com.project.mentoring.command;
<<<<<<< HEAD

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.HompageCategorySearchDao;
import com.project.mentoring.dto.HompageCategorySearchDto;


public class HompageCategorySearchCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String strmajornum = request.getParameter("majornum");
		
		System.out.println(strmajornum);
		String majorname = "";
		
=======
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.project.mentoring.dao.HompageCategorySearchDao;
import com.project.mentoring.dto.HompageCategorySearchDto;
public class HompageCategorySearchCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String strmajornum = request.getParameter("majornum");
		System.out.println(strmajornum);
		String majorname = "";
>>>>>>> master
		switch (strmajornum) {
		case "1" :
			majorname = "소프트웨어개발";
			break;
		case "2" :
<<<<<<< HEAD
			majorname = "비즈니스";
			break;
		case "3" :
			majorname = "운동";
			break;
		case "4" :
			majorname = "디자인";
			break;
		}
		
		
		HompageCategorySearchDao hompageCategorySearchDao = new HompageCategorySearchDao();
		ArrayList<HompageCategorySearchDto> hompageCategorySearchDto = hompageCategorySearchDao.hompageCategorySearch(majorname);
		
		
		request.setAttribute("mentorSearchList", hompageCategorySearchDto);

	}

}
=======
			majorname = "디자인";
			break;
		case "3" :
			majorname = "예술";
			break;
		case "4" :
			majorname = "운동";
			break;
		}
		HompageCategorySearchDao hompageCategorySearchDao = new HompageCategorySearchDao();
		ArrayList<HompageCategorySearchDto> hompageCategorySearchDto = hompageCategorySearchDao.hompageCategorySearch(majorname);
		request.setAttribute("mentorSearchList", hompageCategorySearchDto);
	}
}
>>>>>>> master
