package org.web.bordcommend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BordQueryCommend {
	void excuteQueryCommend(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;
}
