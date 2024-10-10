package org.lee474.demo.model.mapper;

import org.lee474.demo.dto.UserDto;
import org.lee474.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    private UserMapper() {}

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

    public static List<UserDto> toDto(List<User> users) {
        return users.stream()
                .map(UserMapper::toDto).collect(Collectors.toList());
    }
}
