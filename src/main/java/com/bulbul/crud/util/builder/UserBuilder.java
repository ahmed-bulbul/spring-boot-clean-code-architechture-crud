package com.bulbul.crud.util.builder;

import com.bulbul.crud.dto.UserDTO;
import com.bulbul.crud.entity.User;

import java.util.Arrays;
import java.util.List;

public class UserBuilder {
    public static List<UserDTO> getListDTO() {
        return Arrays.asList(new UserDTO(1L,"Bulbul","bd@gmail.com","1234"),
                new UserDTO(2L,"Tamim","tamim@gmail.com","1234"));
    }

    public static List<User> getListEntities() {
        return Arrays.asList(new User(1L,"Bulbul","bd@gmail.com","1234"),
                new User(2L,"Tamim","tamim@gmail.com","1234"));
    }

    public static User getEntity() {
        return new User(1L,"Bulbul","bulbul@gmail.com","1234");
    }

    public static UserDTO getDTO() {
        return new UserDTO(1L,"Bulbul","bulbul@gmail.com","1234");
    }
}
