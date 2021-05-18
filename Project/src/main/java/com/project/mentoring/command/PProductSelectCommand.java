package com.project.mentoring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mentoring.dao.PDao;
import com.project.mentoring.dto.PDto;

public class PProductSelectCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		PDao dao = new PDao();
		ArrayList<PDto> dto = dao.ProductSelect();
		request.setAttribute("ProductSelect", dto);

	}

}
