package dev.zeyu.springboot.mapper;

import org.mapstruct.Mapper;
import dev.zeyu.springboot.dto.UserDto;
import dev.zeyu.springboot.entity.User;

@Mapper(componentModel = "spring")
public interface AutoUserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto dto);
}
