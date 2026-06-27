package com.TunaHoc.hello_spring_boot.mapper;


import com.TunaHoc.hello_spring_boot.Entity.Role;
import com.TunaHoc.hello_spring_boot.dto.request.RoleRequest;
import com.TunaHoc.hello_spring_boot.dto.response.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);


    RoleResponse toRoleResponse(Role role);
}
