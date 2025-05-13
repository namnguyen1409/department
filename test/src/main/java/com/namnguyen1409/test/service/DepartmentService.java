package com.namnguyen1409.test.service;

import com.namnguyen1409.test.dto.request.DepartmentCreateRequest;
import com.namnguyen1409.test.dto.response.DepartmentResponse;
import com.namnguyen1409.test.dto.response.UserResponse;

import java.util.List;

public interface DepartmentService {
    DepartmentResponse createDepartment(DepartmentCreateRequest request);

    List<UserResponse> getUsersByDepartmentId(String id);
}
