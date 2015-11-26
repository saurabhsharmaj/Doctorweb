package com.mahdidoc.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class ExceptionResolver extends SimpleMappingExceptionResolver implements HandlerExceptionResolver{
	private final Logger log = LoggerFactory.getLogger(ExceptionResolver.class);
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		String viewName=determineViewName(ex, request);
		log.debug(viewName+" :",ex);
		System.out.println("viewName:"+viewName);
		if (viewName!=null) {
			Integer statusCode = super.determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			request.setAttribute("message", StringUtils.isEmpty(ex.getMessage())?getErrorCause(ex) : ex.getMessage());
			return getModelAndView(viewName, ex, request);
		}
		return null;

	}
	private String getErrorCause(Exception ex) {
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		return errors.toString().substring(0, 250);	
	}
	
	
}