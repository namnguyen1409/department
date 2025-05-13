package com.namnguyen1409.test.service;

import com.namnguyen1409.test.dto.request.LoginRequest;
import com.namnguyen1409.test.dto.response.LoginResponse;
import org.springframework.transaction.annotation.Transactional;

public interface AuthService {

    @Transactional
    LoginResponse login(LoginRequest request);
}
