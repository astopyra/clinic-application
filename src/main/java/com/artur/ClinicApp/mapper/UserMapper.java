package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.domain.dto.UserDto;
import com.artur.ClinicApp.domain.entity.User;
import org.springframework.stereotype.Service;


@Service
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getRoles()
        );
    }

    public UserDto mapToUSerDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
        );
    }
}
