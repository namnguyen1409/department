package com.namnguyen1409.test.mapper;

import com.namnguyen1409.test.dto.request.DepartmentCreateRequest;
import com.namnguyen1409.test.dto.response.DepartmentResponse;
import com.namnguyen1409.test.entity.Department;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentMapper {
    Department toEntity(DepartmentCreateRequest departmentCreateRequest);

    DepartmentCreateRequest toDto(Department department);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Department partialUpdate(DepartmentCreateRequest departmentCreateRequest, @MappingTarget Department department);

    DepartmentResponse toResponse(Department department);
}