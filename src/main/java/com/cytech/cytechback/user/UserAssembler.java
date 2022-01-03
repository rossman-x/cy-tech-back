package com.cytech.cytechback.user;

import com.cytech.cytechback.common.SimpleAssembler;
import com.cytech.cytechback.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserAssembler implements SimpleAssembler<UserDTO, User> {

    @Override
    public UserDTO toDto(User u) {
        UserDTO dto = new UserDTO();
        dto.setId(u.getId());
        dto.setAddress(u.getAddress());
        dto.setBirthdayDate(u.getBirthdayDate());
        dto.setEmailAddress(u.getEmailAddress());
        dto.setFirstName(u.getFirstName());
        dto.setLastName(u.getLastName());
        dto.setStatus(u.getStatus());
        dto.setSpeciality(u.getSpeciality());
        dto.setHoursAbsent(u.getHoursAbsent());
        dto.setOrientation(u.getOrientation());
        return dto;
    }

    @Override
    public User fromDto(UserDTO dto) {
        User u = new User();
        u.setPassword(dto.getPassword());
        u.setAddress(dto.getAddress());
        u.setBirthdayDate(dto.getBirthdayDate());
        u.setEmailAddress(dto.getEmailAddress());
        u.setFirstName(dto.getFirstName());
        u.setLastName(dto.getLastName());
        u.setStatus(dto.getStatus());
        u.setSpeciality(dto.getSpeciality());
        u.setHoursAbsent(dto.getHoursAbsent());
        return u;
    }

    @Override
    public List<UserDTO> toDtoList(List<User> users) {
        if (users != null && !users.isEmpty()) {
            return users.stream().map(this::toDto).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<User> fromDtoList(List<UserDTO> dtoList) {
        if (dtoList != null && !dtoList.isEmpty()) {
            return dtoList.stream().map(this::fromDto).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
