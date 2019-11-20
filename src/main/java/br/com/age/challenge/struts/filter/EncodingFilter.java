package br.com.age.challenge.struts.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		servletRequest.setCharacterEncoding("UTF-8");
		servletResponse.setContentType("text/html; charset=UTF-8");
		filterChain.doFilter(servletRequest, servletResponse);
	}

}
