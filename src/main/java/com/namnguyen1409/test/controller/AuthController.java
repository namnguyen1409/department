package com.namnguyen1409.test.controller;

import com.namnguyen1409.test.dto.request.LoginRequest;
import com.namnguyen1409.test.dto.response.ApiResponse;
import com.namnguyen1409.test.dto.response.LoginResponse;
import com.namnguyen1409.test.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        var response = authService.login(request);
        return ApiResponse.<LoginResponse>builder()
                .data(response)
                .build();
    }
}
