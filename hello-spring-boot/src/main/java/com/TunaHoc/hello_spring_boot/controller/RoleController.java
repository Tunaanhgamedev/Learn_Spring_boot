package com.TunaHoc.hello_spring_boot.controller;

import com.TunaHoc.hello_spring_boot.dto.request.ApiResponse;
import com.TunaHoc.hello_spring_boot.dto.request.PermissionRequest;
import com.TunaHoc.hello_spring_boot.dto.request.RoleRequest;
import com.TunaHoc.hello_spring_boot.dto.response.PermissionResponse;
import com.TunaHoc.hello_spring_boot.dto.response.RoleResponse;
import com.TunaHoc.hello_spring_boot.service.PermissionService;
import com.TunaHoc.hello_spring_boot.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {

    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> createRole(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping({"/{role}"})
    ApiResponse<Void> delete(@PathVariable String role) {
        roleService.delete(role);
        return ApiResponse.<Void>builder()
                .build();
    }
}
