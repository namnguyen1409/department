package com.namnguyen1409.test.controller;

import com.namnguyen1409.test.dto.request.DepartmentCreateRequest;
import com.namnguyen1409.test.dto.response.ApiResponse;
import com.namnguyen1409.test.dto.response.DepartmentResponse;
import com.namnguyen1409.test.dto.response.UserResponse;
import com.namnguyen1409.test.service.DepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ApiResponse<DepartmentResponse> createDepartment(@RequestBody DepartmentCreateRequest request) {
        var response = departmentService.createDepartment(request);
        return ApiResponse.<DepartmentResponse>builder()
                .data(response)
                .build();
    }

    @GetMapping("/{id}/users")
    public ApiResponse<List<UserResponse>> getUsersByDepartmentId(@PathVariable String id) {
        var response = departmentService.getUsersByDepartmentId(id);
        return ApiResponse.<List<UserResponse>>builder()
                .data(response)
                .build();
    }


}
