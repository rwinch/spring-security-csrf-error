package com.github.pawelj_pl.csrf_error;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @author Rob Winch
 */
public class RemoveRequestAttrFilter implements Filter {
	private final Set<String> attrNames;

	public RemoveRequestAttrFilter(Set<String> attrNames) {
		this.attrNames = attrNames;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		for (String attrName : this.attrNames) {
			request.removeAttribute(attrName);
		}

		chain.doFilter(request, response);
	}
}
