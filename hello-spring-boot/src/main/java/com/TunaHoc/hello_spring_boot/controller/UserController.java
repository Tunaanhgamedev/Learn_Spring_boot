package com.TunaHoc.hello_spring_boot.controller;


import com.TunaHoc.hello_spring_boot.dto.request.ApiResponse;
import com.TunaHoc.hello_spring_boot.dto.request.UserCreationRequest;
import com.TunaHoc.hello_spring_boot.dto.request.UserUpdateRequest;
import com.TunaHoc.hello_spring_boot.dto.response.UserResponse;
import com.TunaHoc.hello_spring_boot.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;


    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        log.info("Controller: Create User");
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<UserResponse>> getUsers() {
        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }

    @GetMapping({"/{userId}"})
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUser(userId))
                .build();
    }

    @GetMapping({"/myInfo"})
    ApiResponse<UserResponse> getMyInfo() {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }

    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable String userId,
                                   @RequestBody UserUpdateRequest request) {
       return ApiResponse.<UserResponse>builder()
               .result(userService.updateUser(userId, request))
               .build();
    }

    @DeleteMapping({"/{userId}"})
    ApiResponse<String> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ApiResponse.<String>builder()
                .result("user has been deleted")
                .build();
    }
}
