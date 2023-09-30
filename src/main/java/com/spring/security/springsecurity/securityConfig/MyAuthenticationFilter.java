package com.spring.security.springsecurity.securityConfig;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MyAuthenticationFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(MyAuthenticationFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Before");
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("After");
    }
}
