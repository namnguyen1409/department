package com.namnguyen1409.test.service.impl;

import com.namnguyen1409.test.dto.request.DepartmentCreateRequest;
import com.namnguyen1409.test.dto.response.DepartmentResponse;
import com.namnguyen1409.test.dto.response.UserResponse;
import com.namnguyen1409.test.mapper.DepartmentMapper;
import com.namnguyen1409.test.mapper.UserMapper;
import com.namnguyen1409.test.repository.DepartmentRepository;
import com.namnguyen1409.test.service.DepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;
    private final UserMapper userMapper;


    @Override
    public DepartmentResponse createDepartment(DepartmentCreateRequest request) {
        var department = departmentMapper.toEntity(request);
        var savedDepartment = departmentRepository.save(department);
        return departmentMapper.toResponse(savedDepartment);

    }

    @Override
    public List<UserResponse> getUsersByDepartmentId(String id) {
        var department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        var users = department.getUsers();
        return users.stream()
                .map(userMapper::toResponse)
                .toList();
    }

}
