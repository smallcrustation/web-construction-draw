package com.krill.spring.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcDispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// web app config location
		return new Class[] {WebAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// default servlet mapping
		return new String[] {"/"};
	}

}
