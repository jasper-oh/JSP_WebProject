package com.project.mentoring.command;

<<<<<<< HEAD
import java.util.ArrayList;

=======
>>>>>>> master
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mentoring.dao.MenteeMyPageModifyDao;
<<<<<<< HEAD
import com.project.mentoring.dao.MenteeMyPageOpen;
import com.project.mentoring.dto.MenteeMyPageOpenDto;
=======
>>>>>>> master

public class MenteeMyPageModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		
		String struserphone = request.getParameter("userphone");
		int userphone = Integer.parseInt(struserphone);
		String useremail = request.getParameter("useremail");
		HttpSession session = request.getSession();
		String strUserPk = (String) session.getAttribute("userpk");
		int userPk = Integer.parseInt(strUserPk);
		
		//		String strUserPk = (String) session1.getAttribute("userpk");

				
	
		MenteeMyPageModifyDao menteeMyPageModifyDao = new MenteeMyPageModifyDao();
		menteeMyPageModifyDao.MenteeMyPageModify(userphone, useremail, userPk);

		//public void MenteeMyPageModify(int userphone, String useremail, int userPk){
=======
		// TODO Auto-generated method stub
				String struserphone = request.getParameter("userphone");
				int userphone = Integer.parseInt(struserphone);
				String useremail = request.getParameter("useremail");
				HttpSession session = request.getSession();
				String strUserPk = (String) session.getAttribute("userpk");
				int userPk = Integer.parseInt(strUserPk);

				MenteeMyPageModifyDao menteeMyPageModifyDao = new MenteeMyPageModifyDao();
				menteeMyPageModifyDao.MenteeMyPageModify(userphone, useremail, userPk);

>>>>>>> master
	}

}
