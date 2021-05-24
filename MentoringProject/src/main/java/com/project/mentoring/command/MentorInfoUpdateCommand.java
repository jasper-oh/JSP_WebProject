package com.project.mentoring.command;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.mentoring.dao.MentorProfileDao;
import com.project.mentoring.dao.MentorProfileUpdateDao;

public class MentorInfoUpdateCommand implements IntCommand {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("업데이트 커맨드입성 ");
		
		MultipartRequest multipartRequest = null;
		
		String mentorImage = null;
		
		String userEmail = null;
		String userPhone = null;
		String mentorAddress = null;
		int mentorProfileUpdateResult = 0; 
		
		
		int fileSize = 1024 * 1024 * 6;
		
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("/upload");
		
		File folder = new File(uploadPath);
		
		if(!folder.exists()) {
			try {	
				folder.mkdir(); 
				} catch (Exception e) {
					e.getStackTrace();
				}
		}
		
		try {
			HttpSession session = request.getSession();
			String strUserPk =(String) session.getAttribute("userpk");
			int userPk = Integer.parseInt(strUserPk);
			multipartRequest = new MultipartRequest(request, uploadPath,fileSize,"UTF-8",new DefaultFileRenamePolicy());
			
			userEmail = multipartRequest.getParameter("useremail");
			userPhone = multipartRequest.getParameter("userphone");
			String uploadFile = multipartRequest.getFilesystemName("mentorimage");
			mentorImage = "upload/" + uploadFile;
			mentorAddress = multipartRequest.getParameter("mentoraddress");
			
			
			MentorProfileUpdateDao mentorProfileUpdateDao = new MentorProfileUpdateDao();
			
			mentorProfileUpdateResult = mentorProfileUpdateDao.mentorProfileUpdate(userPk, mentorImage,userEmail,userPhone,mentorAddress);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		
			
				
		}
		
		
		return mentorProfileUpdateResult;
	}

}
