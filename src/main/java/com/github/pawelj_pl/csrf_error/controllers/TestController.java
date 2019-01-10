package com.github.pawelj_pl.csrf_error.controllers;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {
    @GetMapping("/do/something")
    public String doSomethingGet() {
        return "QWERTY";
    }
    
    @PostMapping("/do/something")
    public String doSomething() {
        return "ABC";
    }
    
    @GetMapping("/me/token")
    public String getCsrfToken(final HttpServletRequest request) {
        return ((CsrfToken) request.getAttribute(CsrfToken.class.getName())).getToken();
    }
}
