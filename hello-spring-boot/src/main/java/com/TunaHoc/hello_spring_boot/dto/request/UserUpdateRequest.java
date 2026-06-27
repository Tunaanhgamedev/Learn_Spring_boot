package com.TunaHoc.hello_spring_boot.dto.request;


import com.TunaHoc.hello_spring_boot.validator.DobConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE) // Nếu không ghi gì thì mặc định là private
public class UserUpdateRequest {

    String password;
    String firstName;
    String lastName;

    @DobConstraint(min = 16, message = "DOB_INVALID")
    LocalDate dob;

    List<String> roles;
}
