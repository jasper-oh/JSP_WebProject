package com.project.mentoring.command;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.mentoring.dao.AdminReviewDao;
import com.project.mentoring.dto.AdminReviewDto;
public class AdminReviewListCommand implements Command {
	//페이지당 표시할 게시글의 수
		int numOfTuplesPerPage = 7;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int requestPage = 1;
		HttpSession session = request.getSession();
		String button = request.getParameter("button");			
		String where = request.getParameter("where");			
		String keyword = request.getParameter("keyword");			
		//String orderby = request.getParameter("orderby");			
		if(request.getParameter("button") == null) {
			button = "All";
		}
		if(request.getParameter("where") == null) {
			where = "null";
			keyword = "null";
			//orderby = "";
		}
		//최초 목록 진입시 page값을 넘겨주지 않음 -> 초기값인 1페이지 목록을 보여줌
		//목록에서 page요청 -> 해당 페이지 번호로 requestPage 설정
		if ( request.getParameter("page") != null) {
			requestPage = Integer.parseInt(request.getParameter("page"));
			//content에서 목록보기 요청시 최근 페이지 목록으로 돌아가기 위해 세션에 저
			session.setAttribute("courrentPage", requestPage);
		}
		AdminReviewDao dao = new AdminReviewDao();
		//반환되는 총 튜플의 수
		int countedTuple = dao.countTuple();
		//페이지 목록 (1...n)
		ArrayList<Integer> pageList = calcNumOfPage(countedTuple);
		//페이지 목록을 세션에 담는다. *list에 진입하면 무조건 세션이 갱신되므로 새 글이 생겨도 최신화가 된다.
		session.setAttribute("pageList", pageList);
		//해당 페이지에 알맞은 번호의 게시글
		ArrayList<AdminReviewDto> dto = dao.AdminReviewList(button, where, keyword, requestPage, numOfTuplesPerPage);
		request.setAttribute("ReviewData", dto);
	}
	//총 튜플수를 받아 페이지당 표시할 게시글의 수로 나누어서 페이지수를 계산하고 jsp에서 for-each문을 돌리기 위해 배열에 담는다
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