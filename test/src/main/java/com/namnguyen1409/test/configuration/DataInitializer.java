package com.namnguyen1409.test.configuration;

import com.namnguyen1409.test.entity.User;
import com.namnguyen1409.test.service.SetupService;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class DataInitializer {

    private final SetupService setupService;

    @PostConstruct
    public void init() {
        log.info("Initializing data...");
        setupService.SetupAdmin();
        setupService.setUpDepartment(10);
    }
}
