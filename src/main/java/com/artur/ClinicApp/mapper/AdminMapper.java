package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.admin.AdminDto;
import com.artur.ClinicApp.admin.AdminEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminMapper {

    private final UserMapper userMapper;

    public AdminEntity mapToAdmin(final AdminDto adminDto) {
        return new AdminEntity(
                adminDto.getId(),
                adminDto.getFirstname(),
                adminDto.getLastname(),
                adminDto.getEmail(),
                userMapper.mapToUser(adminDto.getUserDto())
        );
    }

    public AdminDto mapToAdminDto(final AdminEntity admin) {
        return new AdminDto(
                admin.getId(),
                admin.getFirstname(),
                admin.getLastname(),
                admin.getEmail(),
                userMapper.mapToUSerDto(admin.getUser())
        );
    }
}
