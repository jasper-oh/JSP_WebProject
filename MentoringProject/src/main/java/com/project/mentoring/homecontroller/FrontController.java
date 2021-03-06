package com.project.mentoring.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.command.AdminAnswerBlockCommand;
import com.project.mentoring.command.AdminAnswerInsertCommand;
import com.project.mentoring.command.AdminAnswerUpdateActionCommand;
import com.project.mentoring.command.AdminAnswerUpdateViewCommand;
import com.project.mentoring.command.AdminCancelPaymentCommand;
import com.project.mentoring.command.AdminMajorUpdateActionCommand;
import com.project.mentoring.command.AdminMajorUpdateViewCommand;
import com.project.mentoring.command.AdminPageAnnouncementContentCommand;
import com.project.mentoring.command.AdminPageAnnouncementDeleteCommand;
import com.project.mentoring.command.AdminPageAnnouncementListCommand;
import com.project.mentoring.command.AdminPageAnnouncementModifyCommand;
import com.project.mentoring.command.AdminPageAnnouncementWriteCommand;
import com.project.mentoring.command.AdminPageMajorInsertCommand;
import com.project.mentoring.command.AdminPageMajorListShowCommand;
import com.project.mentoring.command.AdminPageShowPayResultCommand;
import com.project.mentoring.command.AdminPageSubMajorInsertCommand;
import com.project.mentoring.command.AdminPageSubMajorListShowCommand;
import com.project.mentoring.command.AdminPageUserListShowCommand;
import com.project.mentoring.command.AdminQnaListCommand;
import com.project.mentoring.command.AdminQnaViewCommand;
import com.project.mentoring.command.AdminReviewBlockCommand;
import com.project.mentoring.command.AdminReviewListCommand;
import com.project.mentoring.command.AdminSubMajorUpdateActionCommand;
import com.project.mentoring.command.AdminSubMajorUpdateViewCommand;
import com.project.mentoring.command.AdminSubmajorDeleteCommand;
import com.project.mentoring.command.AdminUserBlockCommand;
import com.project.mentoring.command.Command;
import com.project.mentoring.command.HelpPageShowCommand;
import com.project.mentoring.command.HomePageMentorListShowCommand;
import com.project.mentoring.command.HompageCategorySearchCommand;
import com.project.mentoring.command.IntCommand;
import com.project.mentoring.command.LogoutCommand;
import com.project.mentoring.command.MenteeBookingCancelCommand;
import com.project.mentoring.command.MenteeBookinglistCommand;
import com.project.mentoring.command.MenteeMentoringListCommand;
import com.project.mentoring.command.MenteeMentoringReviewCommand;
import com.project.mentoring.command.MenteeMyPageModifyCommand;
import com.project.mentoring.command.MenteeMyPageOpenCommand;
import com.project.mentoring.command.MenteeReviewDeleteActionCommand;
import com.project.mentoring.command.MenteeReviewEditActionCommand;
import com.project.mentoring.command.MenteeReviewEditCommand;
import com.project.mentoring.command.MenteeReviewListCommand;
import com.project.mentoring.command.MentorInfoShowCommand;
import com.project.mentoring.command.MentorInfoUpdateCommand;
import com.project.mentoring.command.MentorMentoringCompleteTokenCheckCommand;
import com.project.mentoring.command.MentorMentoringCompleteUpdatePaymentSendDateCommand;
import com.project.mentoring.command.MentorPayReceiveListCommand;
import com.project.mentoring.command.MentorProductUpdateCommand;
import com.project.mentoring.command.MentorProfileInsertCommand;
import com.project.mentoring.command.MentorProfileIntroduceInsertCommand;
import com.project.mentoring.command.MentorProfileSubMajorFindCommand;
import com.project.mentoring.command.MentorReviewViewCommand;
import com.project.mentoring.command.MentorScheduleDeleteCommand;
import com.project.mentoring.command.MentorScheduleListViewCommand;
import com.project.mentoring.command.MentorScheduledCompleteListShowCommand;
import com.project.mentoring.command.MentorScheduledListShowCommand;
import com.project.mentoring.command.MentorSelectMentorPkCommand;
import com.project.mentoring.command.MentorTokenUpdateCommand;
import com.project.mentoring.command.PAppointmentCommand;
import com.project.mentoring.command.PMentorProductListCommand;
import com.project.mentoring.command.PMentorProductPageCommand;
import com.project.mentoring.command.PPaymentCommand;
import com.project.mentoring.command.PProductScheduleSelectCommand;
import com.project.mentoring.command.PProductScheduleViewCommand;
import com.project.mentoring.command.PScheduleInsertCommand;
import com.project.mentoring.command.UserCheckSelectCommand;
import com.project.mentoring.command.UserCheckUpdateToMentorCommand;
import com.project.mentoring.command.UserFindIdByEmailCommand;
import com.project.mentoring.command.UserFindIdByPhoneCommand;
import com.project.mentoring.command.UserFindPwCommand;
import com.project.mentoring.command.UserLoginPageSelectCommand;
import com.project.mentoring.command.UserQnaListCommand;
import com.project.mentoring.command.UserQnaViewCommand;
import com.project.mentoring.command.UserQuestionBlockCommand;
import com.project.mentoring.command.UserQuestionInsertCommand;
import com.project.mentoring.command.UserSearchPageShowCommand;
import com.project.mentoring.command.UserSignUpPageInsertCommand;
import com.project.mentoring.command.userShowAnnouncementPageCommand;
import com.project.mentoring.dao.UserLoginDao;

// ?????? ?????????

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
		
		case("/logout.do"):
			command = new LogoutCommand();
			command.execute(request, response);
		
		case("/home.do"):
			command = new HomePageMentorListShowCommand();
			command.execute(request, response);
			viewPage = "visitorPage.jsp";
			break;
			
		//-- adminPage ??? *.do
		case("/adminPage.do"):
			viewPage ="adminPage.jsp";
			break;
			
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
		case("/AdminAnnouncementList.do"):
			command=new AdminPageAnnouncementListCommand();
			command.execute(request, response);
			viewPage="adminAnnouncementPage.jsp";
			break;
		case("/AdminAnnouncementWrite_view.do"):
			viewPage="adminAnnouncementWritePage.jsp";
			break;
		case("/AdminAnnouncementWrite.do"):
			System.out.println("?????? ?????????");
			command=new AdminPageAnnouncementWriteCommand();
			command.execute(request, response);
			viewPage="AdminAnnouncementList.do";
			break;
		case("/AdminAnnouncementContent.do"):
			command=new AdminPageAnnouncementContentCommand();
			command.execute(request, response);
			viewPage="adminAnnouncementContentPage.jsp";
			break;
		case("/AdminAnnouncementModify.do"):
			System.out.println("?????? ?????????");
			command=new AdminPageAnnouncementModifyCommand();
			command.execute(request, response);
			viewPage="AdminAnnouncementList.do";
			break;
		case("/AdminAnnouncementDelete.do"):
			command=new AdminPageAnnouncementDeleteCommand();
			command.execute(request, response);
			viewPage="AdminAnnouncementList.do";
			break;
		case("/adminPageShowPayResult.do"):
			command = new AdminPageShowPayResultCommand();
			command.execute(request, response);
			viewPage="adminShowPayResultPage.jsp";
			break;
		case("/adminCancelPayment.do"):
			command = new AdminCancelPaymentCommand();
			command.execute(request, response);
			viewPage="adminPageShowPayResult.do";
			break;
			
		// -- userPage ??? *.do
		case("/userLoginPage.do"):
			intCommand = new UserLoginPageSelectCommand();
			
			
			int loginResult = intCommand.execute(request, response);
			
			if(loginResult == 1) {
				command = new HomePageMentorListShowCommand();
				command.execute(request, response);
				request.setAttribute("loginResult", loginResult);
				
				String userId = request.getParameter("userid");
				String userpk = UserLoginDao.userPk;
				String userName = UserLoginDao.userName;	
				HttpSession session = request.getSession();
				session.setAttribute("userid", userId);
				session.setAttribute("userpk", userpk);
				session.setAttribute("username", userName);
				
				
				System.out.println("????????? ??????! ");
				
				UserCheckSelectCommand userCheckSelectCommand = new UserCheckSelectCommand();
				int userCheck = userCheckSelectCommand.execute(request, response);
				session.setAttribute("userCheck", userCheck);
				// ????????? ????????? ??????????????? ?????? ?????? ????????? ?????? ?????? ??????
				if(userCheck == 1) {
					
					System.out.println("?????????????????? ??????");
					viewPage = "mentorPage.jsp";
				}else {
					System.out.println("?????? ?????? ???????????? ??????");
					viewPage = "homePage.jsp";
				}
				
				
			}else {
				command = new HomePageMentorListShowCommand();
				command.execute(request, response);
				HttpSession session = request.getSession();
				session.invalidate();
				request.setAttribute("loginResult", loginResult);
				viewPage = "userLoginPage.jsp";
				
				System.out.println("????????? ??????! ");
				
				
			}
			break;
			
		case("/userHomePage.do"):
			command = new HomePageMentorListShowCommand();
			command.execute(request, response);
			viewPage = "homePage.jsp";
			break;
			
			
		case("/mentorHomePage.do"):
			command = new HomePageMentorListShowCommand();
			command.execute(request, response);
			viewPage="mentorPage.jsp";
			break;
			
			
		case("/menteeMyPageOpen.do"):
			System.out.println("?????? ?????? ???????????? ?????? ?????? ?????????");
			command = new MenteeMyPageOpenCommand();
			command.execute(request, response);
			viewPage="userMyPage.jsp";
			
			break;
			
		case("/menteeMyPageModify.do"):
			System.out.println("?????? ?????? ???????????? ?????? ?????? ?????????");
				command = new MenteeMyPageModifyCommand();
				command.execute(request, response);
				viewPage="/menteeMyPageOpen.do";
			break;
		
		case("/userSignUpPage.do"):
			command = new UserSignUpPageInsertCommand();
			command.execute(request,response);
				//viewPage = "visitorPage.jsp"
			viewPage = "userSignUpPage.jsp";
			break;
			
		case("/userFindIdByEmail.do"):
			command = new UserFindIdByEmailCommand();
			command.execute(request, response);
			viewPage="userFindId.jsp";
			break;
			
		case("/userFindIdByPhone.do"):
			command = new UserFindIdByPhoneCommand();
			command.execute(request, response);
			viewPage="userFindId.jsp";
			break;
		case("/userFindPwResult.do"):
			command = new UserFindPwCommand();
			command.execute(request, response);
			viewPage="userFindPw.jsp";
			break;
		case("/userShowSearchListPage.do"):
			intCommand = new UserSearchPageShowCommand();
			int searchResult = intCommand.execute(request, response);
			
			if(searchResult == 0) {
				HttpSession session = request.getSession();
				request.setAttribute("userCheck", session.getAttribute("userCheck"));
				viewPage = "searchPage.jsp";
				
			}else {
				
				viewPage = "visitorPage.jsp";
			}
			
			break;
		
			
		case("/help.do"):
//			???????????? announement ???????????? command
			command = new userShowAnnouncementPageCommand();
			command.execute(request, response);
//			???????????? ???????????? q&a ???????????? command
			UserQnaListCommand userQnaListCommand = new UserQnaListCommand();
			userQnaListCommand.execute(request, response);

			viewPage="helpPage.jsp";
			break;
			
		case("/userShowAnnouncementPage.do"):
			command = new userShowAnnouncementPageCommand();
			command.execute(request, response);
			viewPage = "userAnnouncementPage.jsp";
			break;
			
		case("/HompageCategorySearch.do"):
			System.out.println("?????????????????? ???????????? ??????");
			command = new HompageCategorySearchCommand();
			command.execute(request, response);
			viewPage="searchPage.jsp";
			break;
						
			
		case("/mentorProfile.do"):
			// ???????????? 1
			intCommand = new MentorProfileInsertCommand();
		
			int mentorProfileInsertResult = intCommand.execute(request, response);
			
			
			if(mentorProfileInsertResult == 1) {
				System.out.println("????????? ?????? ??????");
				viewPage = "userBeMentorPage2.jsp";
				
			}else {
				
				
				System.out.println("????????? ?????? ??????");
				viewPage = "userBeMentorPage.jsp";
			}
			break;
		case("/mentorBookingList.do"):
			System.out.println("??????(??????)????????????????????????");
			command = new MenteeBookinglistCommand();
			command.execute(request, response);
			viewPage = "mentorBookingList.jsp";
			break;
			
		case("/mentorMentoringList.do"):
			System.out.println("??????(??????)??????????????????????????????");
			command = new MenteeMentoringListCommand();
			command.execute(request, response);
			viewPage = "mentorMentoringList.jsp";
			break;
			
		
		case("/mentorProfileMajor.do"):
			// ???????????? 2
			
			intCommand = new MentorProfileSubMajorFindCommand();
			MentorSelectMentorPkCommand mentorSelectMentorPkCommand = new MentorSelectMentorPkCommand();
			int mentorPk = mentorSelectMentorPkCommand.execute(request, response);
			
			int majorPk = intCommand.execute(request, response);
			
			HttpSession session = request.getSession();
			session.setAttribute("mentorPk", mentorPk);
			request.setAttribute("userCheck", session.getAttribute("userCheck"));
			
			request.setAttribute("majorPk", majorPk);
			
			
			viewPage = "userBeMentorPage3.jsp";

			break;
			
		case("/mentorProfileMajorAdd.do"):
			intCommand = new MentorProfileSubMajorFindCommand();
			MentorSelectMentorPkCommand mentorSelectMentorPkCommand1 = new MentorSelectMentorPkCommand();
			int mentorPk1 = mentorSelectMentorPkCommand1.execute(request, response);
		
			int majorPk1 = intCommand.execute(request, response);
		
			HttpSession session1 = request.getSession();
			session1.setAttribute("mentorPk", mentorPk1);
			request.setAttribute("userCheck", session1.getAttribute("userCheck"));
		
			request.setAttribute("majorPk", majorPk1);
		
		
			viewPage = "mentorBeAnotherMentor3.jsp";
			break;
			
			
		case("/mentorProfileIntroduce.do"):
//			???????????? 3
			intCommand = new MentorProfileIntroduceInsertCommand();
			int mentorProfileIntroduceResult = intCommand.execute(request, response);

			if(mentorProfileIntroduceResult == 1) {
				System.out.println("?????? ?????? ?????? ??????");
				viewPage="userBeMentorPage4.jsp";
			}else {
				System.out.println("?????? ?????? ?????? ??????");
				viewPage="userBeMentorPage3.jsp";
			}
			
			break;
			
		case("/mentorProfileIntroduceAdd.do"):
			intCommand = new MentorProfileIntroduceInsertCommand();
			int mentorProfileIntroduceResult1 = intCommand.execute(request, response);

			if(mentorProfileIntroduceResult1 == 1) {
				System.out.println("?????? ?????? ?????? ??????");
				viewPage="mentorBeAnotherMentor4.jsp";
			}else {
				System.out.println("?????? ?????? ?????? ??????");
				viewPage="mentorBeAnotherMentor4.jsp";
			}
			break;
		
		case("/showMentorMyPage.do"):
			System.out.println("??????????????? ?????? ?????? ?????????");
			command = new MentorInfoShowCommand();
			command.execute(request, response);
			viewPage="mentorMyPage.jsp";
			break;
			

		case("/mentorInfoUpdatePage.do"):
			System.out.println("??????????????? ?????? ?????? ?????????");
			command = new MentorInfoShowCommand();
			command.execute(request, response);
			viewPage="mentorMyPage.jsp";
			break;
			
			
		case("/mentorInfoUpdate.do"):
			System.out.println("?????? ???????????? ????????? ?????????");
		    intCommand = new MentorInfoUpdateCommand();
		    int updateResult = intCommand.execute(request, response);
		    
		    if(updateResult == 1) {
		    	System.out.println("???????????? ??????");
		    	viewPage="/mentorInfoUpdatePage.do";
		    	
		    }else {
		    	System.out.println("???????????? ??????");
		    	viewPage="/mentorInfoUpdatePage.do";
		    }
		    
		    		
		    break;
		
		
		case("/userCheckUpdate.do"):
			intCommand = new UserCheckUpdateToMentorCommand();
		
			int userCheckUpdateToMentorResult = intCommand.execute(request, response);
			
			if(userCheckUpdateToMentorResult == 1) {
				
				viewPage="mentorPage.jsp";
				
			}else {
				
				viewPage="userBeMentorPage4";
			}
		 break;
		 
		case("/mentorScheduledList.do"):
			command = new MentorScheduledListShowCommand();
			command.execute(request, response);
			viewPage="mentorScheduledList.jsp";
			break;
			
		case("/mentorScheduledCompleteList.do"):
			System.out.println("???????????? ???????????? ?????????");
			intCommand = new MentorTokenUpdateCommand();
			int tokenSendResult = intCommand.execute(request, response);
			
			if(tokenSendResult == 1) {
				command = new MentorScheduledCompleteListShowCommand();
				command.execute(request, response);
				viewPage="mentorScheduledCompletePage.jsp";
				
			}else {
				viewPage = "mentorScheduledList.jsp";
			}
			break;
		case("/mentorScheduledCompleteListPage.do"):
			command = new MentorScheduledCompleteListShowCommand();
			command.execute(request, response);
			viewPage="mentorScheduledCompletePage.jsp";
			break;
		 
 
		case("/mentorPayReceiveList.do"):
			System.out.println("????????????????????? ????????? ??????");
			command = new MentorPayReceiveListCommand();
			command.execute(request, response);
			viewPage="mentorPayReceivePage.jsp";

			break;	
			
		case("/mentorReviewView.do"):
			System.out.println("??????????????? ??????");
			command = new MentorReviewViewCommand();
			command.execute(request, response);
			viewPage="mentorReviewView.jsp";

			break;
		
			
		case("/mentorProductList.do"):
			System.out.println("?????? ??????????????? product");
			command=new PMentorProductListCommand();
			command.execute(request, response);
			viewPage="mentorProductList.jsp";
			break;
			//

	
		case("/mentorProductPage.do"):
			command=new PMentorProductPageCommand();
			command.execute(request, response);
			viewPage="mentorProductPage.jsp";
			break;
		
		case("/mentorProductUpdate.do"):
			command = new MentorProductUpdateCommand();
			command.execute(request, response);
			viewPage="/mentorProductList.do";
			break;
			
			
		case("/mentorScheduleListView.do"):
			System.out.println("product->schedule");
			command=new MentorScheduleListViewCommand();
			command.execute(request, response);
			viewPage="mentorScheduleListView.jsp";
			break;
			//
		case("/deleteSchedule.do"):
			System.out.println("schedule->delete");
			command=new MentorScheduleDeleteCommand();
			command.execute(request, response);
			viewPage="mentorProductPage.do";
			break;
			
		case("/insertScheduleView.do"):
			System.out.println("????????? ?????? ??????");
			viewPage="productInsertSchedule.jsp";
			break;
			
			//-> ?????? ?????? ?????? ??????
		
		case("/insertScheduleAction.do"):
			System.out.println("????????? ??????");
			command=new PScheduleInsertCommand();
			command.execute(request, response);
			viewPage="/mentorProductPage.do";
			break;

			// ?????? ??????
		case("/adminReviewList.do"):
			System.out.println("***admin Review List***");
			command = new AdminReviewListCommand();
			command.execute(request, response);
			viewPage = "adminReviewList.jsp";
			break;
			//
		case("/adminReviewBlock.do"):
			System.out.println("***admin Review Block***");
			command = new AdminReviewBlockCommand();
			command.execute(request, response);
			viewPage = "adminReviewList.do";
			break;
			//
		case("/adminQnaList.do"):
			System.out.println("***admin QNA List***");
			command = new AdminQnaListCommand();
			command.execute(request, response);
			viewPage = "adminQnaList.jsp";
			break;
			//
		case("/adminQnaView.do"):
			System.out.println("***admin QNA List ??????***");
			command = new AdminQnaViewCommand();
			command.execute(request, response);
			viewPage="adminQnaView.jsp";
			break;
			//
		case("/answerInsertAction.do"):
			System.out.println("***admin Answer Insert***");
			command = new AdminAnswerInsertCommand();
			command.execute(request, response);
			viewPage = "/adminQnaView.do";
			break;
			//
		case("/adminAnswerBlock.do"):
			System.out.println("***admin Answer Block***");
			command = new AdminAnswerBlockCommand();
			command.execute(request, response);
			viewPage = "adminQnaView.do";
			break;
			//
		case("/adminAnswerUpdateView.do"):
			System.out.println("***admin Answer View Popup***");
			command = new AdminAnswerUpdateViewCommand();
			command.execute(request, response);
			viewPage = "adminAnswerUpdateView.jsp";
			break;			
			//
		case("/adminAnswerUpdateAction.do"):
			System.out.println("***admin Answer Update***");
			command = new AdminAnswerUpdateActionCommand();
			command.execute(request, response);
			viewPage = "adminAnswerUpdateView.do";
			break;
			//
		case("/userQnaList.do"):
			System.out.println("***User QNA List***");
			command = new UserQnaListCommand();
			command.execute(request, response);
			viewPage = "userQnaList.jsp";
			break;
			//
		case("/userQnaInsert.do"):
			System.out.println("***User Question Insert***");
			command = new UserQuestionInsertCommand();
			command.execute(request, response);
			viewPage = "userQnaList.do";
			break;
			//
		case("/userQanView.do"):
			System.out.println("***User QNA List ??????***");
			command = new UserQnaViewCommand();
			command.execute(request, response);
			viewPage="userQnaView.jsp";
			break;
			//
		case("/userQuestionBlock.do"):
			System.out.println("***User Question Block***");
			command = new UserQuestionBlockCommand();
			command.execute(request, response);
			viewPage = "userQnaList.do";
			break;
			//
		case("/adminSubmajorDeleteAction.do"):
			command = new AdminSubmajorDeleteCommand();
			command.execute(request, response);
			viewPage = "adminSubMajorListShowPage.do";
			break;
			//
		case("/adminUserBlock.do"):
			System.out.println("***admin User Block***");
			command = new AdminUserBlockCommand();
			command.execute(request, response);
			viewPage = "adminUserListShowPage.do";
			break;
			//
		case("/adminMajorUpdateView.do"):
			System.out.println("***ADMIN MAJOR UPDATE ??????***");
			command = new AdminMajorUpdateViewCommand();
			command.execute(request, response);
			viewPage="adminMajorUpdateView.jsp";
			break;
			//
		case("/adminMajorUpdateAction.do"):
			System.out.println("***ADMIN MAJOR UPDATE***");
			command = new AdminMajorUpdateActionCommand();
			command.execute(request, response);
			viewPage="adminMajorUpdateView.do";
			break;
			//
		case("/adminSubMajorUpdateView.do"):
			System.out.println("***ADMIN SUBMAJOR UPDATE ??????***");
			command = new AdminSubMajorUpdateViewCommand();
			command.execute(request, response);
			viewPage="adminSubMajorUpdateView.jsp";
			break;
			//
		case("/adminSubMajorUpdateAction.do"):
			System.out.println("***ADMIN SUBMAJOR UPDATE***");
			command = new AdminSubMajorUpdateActionCommand();
			command.execute(request, response);
			viewPage="adminSubMajorUpdateView.do";
			break;
			
		case("/mentorMentoringCompleteTokenCheck.do"):
			System.out.println("?????? ?????? ?????? ??????");
			intCommand = new MentorMentoringCompleteTokenCheckCommand();
			int tokenInsertResult = intCommand.execute(request, response);
			
			if(tokenInsertResult == 1) {
				command = new MentorMentoringCompleteUpdatePaymentSendDateCommand();
				command.execute(request, response);
				System.out.println("22SendDateUpdate Complete");
				System.out.println("?????? ?????? ??????");
				viewPage="tokenCheckSuccessPaymentSuccessPage.jsp";
			}else {
				System.out.println("?????? ?????? ?????????");
				viewPage="mentorMentoringComplete.jsp";
			}
			break;
			
			
		// ?????? ?????? ??? .do
		case("/appointment.do"):
			System.out.println("product ?????? pageview");
			command = new PAppointmentCommand();
			command.execute(request, response);
			viewPage="appointment.jsp";
			break;
			
			//
			
		case("/paymentScheduleSelect.do"):
			System.out.println("???????????? ?????? calendarview");
			command = new PProductScheduleViewCommand();
			command.execute(request, response);
			viewPage = "paymentScheduleSelect.jsp";
			break;
			
			//
			
		case("/paymentDatatView.do"):
			System.out.println("payment ??? ?????? view");
			command = new PProductScheduleSelectCommand();
			command.execute(request, response);
			viewPage = "paymentDataView.jsp";
			break;
			
			//
			
		case("/paymentSuccess.do"):
			System.out.println("payment db insert process");
			command = new PPaymentCommand();
			command.execute(request, response);
			viewPage = "paymentSuccess.jsp";
			break;
			//
			
		case("/menteeBookingList.do"):
			System.out.println("??????????????????????????????");
			command = new MenteeBookinglistCommand();
			command.execute(request, response);
			viewPage = "menteeBookingList.jsp";
			break;
			
			//
			
		case("/menteeBookingCancel.do"):
			System.out.println("????????? ?????? ??????");
			command = new MenteeBookingCancelCommand();
			command.execute(request, response);
			viewPage = "menteeBookingList.do";
			break;
			
			//
			
		case("/mentorBookingCancel.do"):
			System.out.println("????????? ?????? ??????");
			command = new MenteeBookingCancelCommand();
			command.execute(request, response);
			viewPage="mentorScheduledList.do";
			break;
		
			//
		case("/menteeMentoringList.do"):
			System.out.println("????????????????????????????????????");
			command = new MenteeMentoringListCommand();
			command.execute(request, response);
			viewPage = "menteeMentoringList.jsp";
			break;
			
			//
			
			

		case("/menteeMentoringReview.do"):
			System.out.println("?????????????????? ??????");
			command = new MenteeMentoringReviewCommand();
			command.execute(request, response);
			viewPage = "menteeReviewList.do";
			break;
			
			//
			
		case("/menteeReviewList.do"):
			System.out.println("????????????????????? ??????");
			command = new MenteeReviewListCommand();
			command.execute(request, response);
			viewPage = "menteeReviewList.jsp";
			break;	
			
			//
		
		case("/menteeReviewEdit.do"):
			System.out.println("?????????????????????????????????????????????");
		command = new MenteeReviewEditCommand();
		command.execute(request, response);
		viewPage = "menteeReviewEditPage.jsp";
		break;	
		
		case("/menteeReviewEditAction.do"):
			System.out.println("????????????????????????????????????");
		command = new MenteeReviewEditActionCommand();
		command.execute(request, response);
		viewPage = "/menteeReviewList.do";
		break;	
		
		case("/menteeReviewDeleteAction.do"):
			System.out.println("??????????????????");
		command = new MenteeReviewDeleteActionCommand();
		command.execute(request, response);
		viewPage = "/menteeReviewList.do";
		break;
			
//		????????? ????????? jsp .do ??????????????? ?????????
		case("/sessionCheck.do"):
			
			viewPage="sessionCheck.jsp";
			
		
		}
		
		
		
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		
	}

}//-- end Line
