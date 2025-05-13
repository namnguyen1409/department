package com.namnguyen1409.test.repository;

import com.namnguyen1409.test.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}