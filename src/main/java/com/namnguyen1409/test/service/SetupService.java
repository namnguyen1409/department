package com.namnguyen1409.test.service;

import com.namnguyen1409.test.entity.Department;
import com.namnguyen1409.test.entity.User;
import com.namnguyen1409.test.repository.DepartmentRepository;
import com.namnguyen1409.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SetupService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;


    @Transactional
    public void SetupAdmin() {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole("ADMIN");
        userRepository.save(admin);
    }

    @Transactional
    public void setUpDepartment(int number) {
        long currentDepartments = departmentRepository.count();

        if (currentDepartments >= number) {
            return;
        }

        int departmentsToAdd = number - (int) currentDepartments;
        long startingUserIndex = userRepository.count();

        for (int i = 0; i < departmentsToAdd; i++) {
            Department department = new Department();
            department.setName("Department " + (currentDepartments + i + 1));

            Set<User> users = new LinkedHashSet<>();
            for (int j = 0; j < 10; j++) {
                User user = new User();
                user.setUsername("user" + (startingUserIndex + (i * 10L) + j + 1));
                user.setPassword(passwordEncoder.encode("123456"));
                user.setRole("USER");
                user.setDepartment(department);
                users.add(user);
            }

            department.setUsers(users);
            departmentRepository.save(department);
        }
    }

}
