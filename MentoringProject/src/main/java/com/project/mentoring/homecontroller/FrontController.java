package com.project.mentoring.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.project.mentoring.command.AdminAnnouncementCommand;
import com.project.mentoring.command.AdminAnnouncementContentCommand;
import com.project.mentoring.command.AdminAnnouncementDeleteCommand;
import com.project.mentoring.command.AdminAnnouncementModifyCommand;
import com.project.mentoring.command.AdminAnnouncementWriteCommand;
import com.project.mentoring.command.AdminPageMajorInsertCommand;
import com.project.mentoring.command.AdminPageMajorListShowCommand;
import com.project.mentoring.command.AdminPageSubMajorInsertCommand;
import com.project.mentoring.command.AdminPageSubMajorListShowCommand;
import com.project.mentoring.command.AdminPageUserListShowCommand;
import com.project.mentoring.command.Command;
import com.project.mentoring.command.IntCommand;
import com.project.mentoring.command.MentorProfileInsertCommand;
import com.project.mentoring.command.MentorProfileIntroduceInsertCommand;
import com.project.mentoring.command.MentorProfileSubMajorFindCommand;
import com.project.mentoring.command.MentorSelectMentorPkCommand;
import com.project.mentoring.command.UserLoginPageSelectCommand;
import com.project.mentoring.command.UserSignUpPageInsertCommand;
import com.project.mentoring.dao.UserLoginDao;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost()");
		actionDo(request,response);

	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo()");
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		String viewPage = null;
		
		Command command = null;
		IntCommand intCommand = null;
		
		System.out.println(com);
		
		switch(com) {
		
		case("/home.do"):
			viewPage = "visitorPage.jsp";
			break;
			
		//-- adminPage 의 *.do
		case("/adminPage.do"):
			viewPage ="adminPage.jsp";
			break;
			
//----------여기서부터
			
		case("/adminAnnouncement.do"):
			command = new AdminAnnouncementCommand();
			command.execute(request, response);
			viewPage = "adminAnnouncement.jsp";
			break;
			
		case("/adminAnnouncementWriteView.do"):
			viewPage = "adminAnnouncementWriteView.jsp";
			break;
			
		case("/adminAnnouncementWrite.do"):
			command = new AdminAnnouncementWriteCommand();
			command.execute(request, response);
			viewPage = "adminAnnouncement.do";
			break;
			
		case("/adminAnnouncementContentView.do"):
			command = new AdminAnnouncementContentCommand();
			command.execute(request, response);
			viewPage = "adminAnnouncementContentView.jsp";
			break;
			
		case("/adminAnnouncementModify.do"):
			command = new AdminAnnouncementModifyCommand();
			command.execute(request, response);
			viewPage = "adminAnnouncement.do";
			break;
			
		case("/adminAnnouncementDelete.do"):
			command = new AdminAnnouncementDeleteCommand();
			command.execute(request, response);
			viewPage = "adminAnnouncement.do";
			break;
		
			
//----------김민규 수정
			
		case("/adminUserListShowPage.do"):
			command = new AdminPageUserListShowCommand();
			command.execute(request, response);
			viewPage = "adminUserListShowPage.jsp";
			break;
			
		case("/adminMajorListShowPage.do"):
			command = new AdminPageMajorListShowCommand();
			command.execute(request, response);
			viewPage = "adminManagementMajor.jsp";
			break;
			
		case("/adminInsertMajor.do"):
			intCommand = new AdminPageMajorInsertCommand();
			int majorInsertResult = intCommand.execute(request, response);
			
			if(majorInsertResult == 1) {
				request.setAttribute("majorInsertResult", majorInsertResult);
				viewPage="adminManagementMajorInsertPage.jsp";
			}else {
				request.setAttribute("majorInsertResult", majorInsertResult);
				viewPage="adminManagementMajorInsertPage.jsp";
			}
			break;
		case("/adminSubMajorListShowPage.do"):
			command = new AdminPageSubMajorListShowCommand();
			command.execute(request, response);
			viewPage = "adminManagementSubMajor.jsp";
			break;
			
		case("/adminInsertSubMajor.do"):
			intCommand = new AdminPageSubMajorInsertCommand();
			int subMajorInsertResult = intCommand.execute(request, response);
			
			if(subMajorInsertResult == 1) {
				request.setAttribute("subMajorInsertResult", subMajorInsertResult);
				viewPage="adminManagementSubMajorInsertPage.jsp";
				
			}else {
				request.setAttribute("subMajorInsertResult", subMajorInsertResult);
				viewPage="adminManagementSubMajorInsertPage.jsp";
				
			}
			break;
			
			
		// -- userPage 의 *.do
		case("/userLoginPage.do"):
			intCommand = new UserLoginPageSelectCommand();
			
			int loginResult = intCommand.execute(request, response);
			
			if(loginResult == 1) {
				request.setAttribute("loginResult", loginResult);
				
				String userId = request.getParameter("userid");
				String userpk = UserLoginDao.userPk;
					
				HttpSession session = request.getSession();
				session.setAttribute("userid", userId);
				session.setAttribute("userpk", userpk);
				viewPage = "homePage.jsp";
				System.out.println("로그인 성공! ");
			}else {
				request.setAttribute("loginResult", loginResult);
				viewPage = "visitorPage.jsp";
				System.out.println("로그인 실패! ");
			}
			break;
		
		case("/userSignUpPage.do"):
			intCommand = new UserSignUpPageInsertCommand();
			int signUpResult = intCommand.execute(request,response);
			
			if(signUpResult == 1) {
				
				viewPage = "homePage.jsp";
				
			}else {
				viewPage = "userSignUpPage.jsp";
			}
			
			break;
			
		// -- mentorPage 의 *.do
		case("/mentorProfile.do"):
			intCommand = new MentorProfileInsertCommand();
		
			int mentorProfileInsertResult = intCommand.execute(request, response);
			
			if(mentorProfileInsertResult == 1) {
				
				
				System.out.println("프로필 등록 성공");
				viewPage = "userBeMentorPage2.jsp";
				
			}else {
			
				System.out.println("프로필 등록 실패");
				viewPage = "userBeMentorPage.jsp";
			}
			break;
		
		case("/mentorProfileMajor.do"):
			intCommand = new MentorProfileSubMajorFindCommand();
			MentorSelectMentorPkCommand mentorSelectMentorPkCommand = new MentorSelectMentorPkCommand();
			int mentorPk = mentorSelectMentorPkCommand.execute(request, response);
			
			int majorPk = intCommand.execute(request, response);
			
			HttpSession session = request.getSession();
			session.setAttribute("mentorPk", mentorPk);
			
			request.setAttribute("majorPk", majorPk);
			viewPage = "userBeMentorPage3.jsp";

			break;
			
		case("/mentorProfileIntroduce.do"):
			intCommand = new MentorProfileIntroduceInsertCommand();
			
			int mentorProfileIntroduceResult = intCommand.execute(request, response);
			
			if(mentorProfileIntroduceResult == 1) {
				System.out.println("상품 정보 등록 성공");
				viewPage="mentorPage.jsp";
			}else {
				System.out.println("상품 정보 등록 실패");
				viewPage="userBeMentorPage3.jsp";
			}
			
			break;
			
		
		}
		
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		
	}

}//-- end Line
