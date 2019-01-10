package com.github.pawelj_pl.csrf_error;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.SessionRepositoryFilter;

import javax.servlet.DispatcherType;
import java.util.Collections;

@SpringBootApplication
public class StartApp {
    public static void main(final String[] args) {
        SpringApplication.run(StartApp.class, args);
    }

    @Bean
    FilterRegistrationBean<RemoveRequestAttrFilter> removeRequestAttrFilterFilterRegistrationBean() {
        FilterRegistrationBean<RemoveRequestAttrFilter> result = new FilterRegistrationBean<>();
        result.setFilter(new RemoveRequestAttrFilter(Collections.singleton(SessionRepositoryFilter.class.getName().concat(SessionRepositoryFilter.ALREADY_FILTERED_SUFFIX))));
        result.setDispatcherTypes(DispatcherType.ERROR);
        return result;
    }
}
