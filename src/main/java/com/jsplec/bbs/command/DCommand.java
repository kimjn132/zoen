package com.jsplec.bbs.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DCommand {

	
	public void execute(HttpServletRequest request, HttpServletResponse response);
}  // 인터페이스 커맨드


