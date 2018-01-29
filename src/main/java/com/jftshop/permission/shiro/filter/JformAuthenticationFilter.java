package com.jftshop.permission.shiro.filter;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class JformAuthenticationFilter extends FormAuthenticationFilter {

	private static final Logger LOG = LoggerFactory.getLogger(JformAuthenticationFilter.class);

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

		if (request.getAttribute(getFailureKeyAttribute()) != null) {
			return true;
		}

		return super.onAccessDenied(request, response, mappedValue);
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
		WebUtils.getAndClearSavedRequest( request );
		this.issueSuccessRedirect(request, response);
		return false;
	}

}
