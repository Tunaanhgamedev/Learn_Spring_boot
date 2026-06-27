package com.TunaHoc.hello_spring_boot.dto.request;


import java.time.LocalDate;

import com.TunaHoc.hello_spring_boot.validator.DobConstraint;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) // Nếu không ghi gì thì mặc định là private
public class UserCreationRequest {

    String id;

    @Size(min = 3, message = "USERNAME_INVALID")
    String username;

    @Size(min = 6, message = "PASSWORD_INVALID")
    String password;

    String firstName;
    String lastName;

    @DobConstraint(min = 16, message = "DOB_INVALID")
    LocalDate dob;



}
