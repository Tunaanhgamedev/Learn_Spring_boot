package com.TunaHoc.hello_spring_boot.mapper;


import com.TunaHoc.hello_spring_boot.Entity.User;
import com.TunaHoc.hello_spring_boot.dto.request.UserCreationRequest;
import com.TunaHoc.hello_spring_boot.dto.request.UserUpdateRequest;
import com.TunaHoc.hello_spring_boot.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
