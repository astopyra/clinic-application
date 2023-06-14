package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.admin.AdminDto;
import com.artur.ClinicApp.admin.AdminEntity;
import com.artur.ClinicApp.domain.UserRole;
import com.artur.ClinicApp.domain.dto.UserDto;
import com.artur.ClinicApp.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdminMapperTestSuite {

    @Autowired
    AdminMapper mapper;

    @Test
    void testMaptoAdmin() {
        //given
        AdminDto adminDto = new AdminDto(
                1L, "Jan", "Nowak", "jnowak@o2.pl",
                new UserDto(1L, "jnowak", "jan123", Collections.singleton(UserRole.PATIENT))
        );

        //when
        AdminEntity admin = mapper.mapToAdmin(adminDto);

        //then
        assertEquals(1L, admin.getId());
        assertEquals("Nowak", admin.getLastname());
        assertEquals("jnowak", admin.getUser().getUsername());
    }

    @Test
    void testMapToAdminDto() {
        //given
        AdminEntity admin = new AdminEntity(
                1L, "Tom", "Bush", "tomb@gmail.com",
                new User(1L, "tomb", "tom123", Collections.singleton(UserRole.ADMIN))
        );

        //when
        AdminDto adminDto = mapper.mapToAdminDto(admin);

        //then
        assertEquals("Tom", adminDto.getFirstname());
        assertEquals("tomb@gmail.com", adminDto.getEmail());
        assertEquals("tom123", adminDto.getUserDto().getPassword());
    }
}
