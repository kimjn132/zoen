package com.jsplec.bss.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ZCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
