package com.namnguyen1409.test.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentCreateRequest {

    @NotNull(message = "{user.username.notNull}")
    @Size(min = 6, max = 20, message = "{user.username.size}")
    private String name;

}
