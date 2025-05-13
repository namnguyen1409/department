package com.namnguyen1409.test.utils;


import com.namnguyen1409.test.exception.ErrorCode;
import com.namnguyen1409.test.exception.GlobalException;
import com.namnguyen1409.test.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import java.util.Base64;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SecurityUtils {

    @NonFinal
    @Value("${jwt.private-key-location}")
    Resource privateKeyLocation;


    public RSAPrivateKey loadPrivateKey() {
        try (InputStream inputStream = privateKeyLocation.getInputStream()) {
            String pem = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .filter(line -> !line.startsWith("-----"))
                    .collect(Collectors.joining());

            byte[] keyBytes = Base64.getDecoder().decode(pem);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            log.error("Error loading private key: {}", e.getMessage());
            throw new GlobalException(ErrorCode.UNCATEGORIZED);
        }
    }


}
