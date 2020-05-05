package model.mapper;

import model.dto.UserDto;
import model.entity.User;

interface UserMapper {

    UserDto toDto(User user);
    User toUserFromDto(UserDto user);
}
