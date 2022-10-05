package com.bulbul.crud.mapper;

import com.bulbul.crud.dto.UserDTO;
import com.bulbul.crud.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    User asEntity(UserDTO dto);
}