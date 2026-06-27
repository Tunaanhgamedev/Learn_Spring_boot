package com.TunaHoc.hello_spring_boot.mapper;


import com.TunaHoc.hello_spring_boot.Entity.Permission;
import com.TunaHoc.hello_spring_boot.dto.request.PermissionRequest;
import com.TunaHoc.hello_spring_boot.dto.response.PermissionResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
