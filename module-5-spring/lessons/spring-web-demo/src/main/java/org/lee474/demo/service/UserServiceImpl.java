package org.lee474.demo.service;

import lombok.RequiredArgsConstructor;
import org.lee474.demo.dto.UserDto;
import org.lee474.demo.model.User;
import org.lee474.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.lee474.demo.model.mapper.UserMapper.toDto;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public List<UserDto> getUsers() {
        return toDto(userRepository.findAll());

    }
}
