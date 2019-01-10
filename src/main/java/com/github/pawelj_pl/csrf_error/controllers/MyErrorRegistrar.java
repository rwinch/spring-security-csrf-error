package com.github.pawelj_pl.csrf_error.controllers;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.stereotype.Component;

/**
 * @author Rob Winch
 */
@Component
public class MyErrorRegistrar implements ErrorPageRegistrar {
	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		registry.addErrorPages(new ErrorPage("/error-with-session"));
	}
}
