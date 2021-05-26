package com.project.mentoring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 클래스설명 : 
 * @version : 2021. 5. 27.
 * @author : biso
 * @분류 : 
 * MentoringProject / package com.project.mentoring.command;
 */

public interface StringCommand {
	
	public String execute(HttpServletRequest request,HttpServletResponse response);

}
