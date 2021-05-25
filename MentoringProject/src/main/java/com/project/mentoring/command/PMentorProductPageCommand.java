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
	int numOfTuplesPerPage = 5;
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
		int requestPage = 1;
		HttpSession session = request.getSession();
		if ( request.getParameter("page") != null) {
			requestPage = Integer.parseInt(request.getParameter("page"));
			//content에서 목록보기 요청시 최근 페이지 목록으로 돌아가기 위해 세션에 저
			session.setAttribute("courrentPage", requestPage);
		}
		MentorScheduleActionDao ScheduleDao = new MentorScheduleActionDao();
		int countedTuple = ScheduleDao.countTuple();
		ArrayList<Integer> pageList = calcNumOfPage(countedTuple);
		session.setAttribute("pageList", pageList);
		ArrayList<ScheduleDto> ScheduleDto = ScheduleDao.ScheduleListView(ShareVar.productpk, requestPage, numOfTuplesPerPage);
		request.setAttribute("MentorScheduleList", ScheduleDto);
		//---------------------------------------------------------------
		MentorReviewViewDao ReviewDao = new MentorReviewViewDao();
		String strUserPk = (String) session.getAttribute("userpk");
		int userPk = Integer.parseInt(strUserPk);
		ArrayList<MentorReviewViewDto> ReviewDto = ReviewDao.ProductReviewList(userPk);
		request.setAttribute("mentorReviewView", ReviewDto);
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