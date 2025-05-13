package com.namnguyen1409.test.configuration;

import com.namnguyen1409.test.exception.ErrorCode;
import com.namnguyen1409.test.exception.GlobalException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) {
        throw new GlobalException(ErrorCode.UNAUTHORIZED);
    }
}
