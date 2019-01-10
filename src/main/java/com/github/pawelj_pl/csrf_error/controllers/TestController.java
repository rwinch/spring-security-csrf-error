package com.github.pawelj_pl.csrf_error.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class TestController {
    @GetMapping("/fail")
    public void fail(HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }

    @GetMapping("/session")
    public String session(HttpSession s) {
        return s.getId();
    }

    @RequestMapping("/error-with-session")
    public String error(HttpServletRequest r) {
        return "session = " + r.getSession(false);
    }
}
