package org.lee474.demo.service;

import org.lee474.demo.dto.UserDto;
import org.lee474.demo.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
}
