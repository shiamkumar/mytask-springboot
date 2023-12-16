package com.techs.config;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UniqueIDGeneratorInterceptor implements HandlerInterceptor {

	private static final Logger log = LogManager.getLogger(UniqueIDGeneratorInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MDC.put("CorrelationId", getCorrelationId());
		log.debug("************** Request Initialized **************");
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		MDC.remove("CorrelationId");
		log.debug("************** Request Destroyed **************");
	}

	private String getCorrelationId() {
		return UUID.randomUUID().toString();
	}

}
