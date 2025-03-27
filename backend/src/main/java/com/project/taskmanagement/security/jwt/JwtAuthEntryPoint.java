package com.project.taskmanagement.security.jwt;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthEntryPoint.class);

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        logger.error("Unauthorized error. Message: {}", authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}
