package com.moura.asciinetapi.dto;


import com.moura.asciinetapi.entity.User;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String userName;
    private String email;

    public UserDto(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getUserName();
    }
}
