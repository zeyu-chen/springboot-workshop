package dev.zeyu.springboot.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import dev.zeyu.springboot.dto.UserDto;
import dev.zeyu.springboot.entity.User;
import dev.zeyu.springboot.exception.EmailAlreadyExistsException;
import dev.zeyu.springboot.exception.ResourceNotFoundException;
import dev.zeyu.springboot.mapper.AutoUserMapper;
import dev.zeyu.springboot.repository.UserRepository;
import dev.zeyu.springboot.service.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AutoUserMapper autoUserMapper;

    @Override
    public UserDto createUser(final UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new EmailAlreadyExistsException(userDto.getEmail());
        }
        final User user = autoUserMapper.toEntity(userDto);
        final User savedUser = userRepository.save(user);
        return autoUserMapper.toDto(savedUser);
    }

    @Override
    public UserDto getUserById(final Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return autoUserMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        final List<User> users = userRepository.findAll();
        return users.stream().map(autoUserMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(final UserDto userDto) {
        final User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userDto.getId()));
        final User updatedUser = autoUserMapper.toEntity(userDto);
        updatedUser.setId(user.getId());
        return autoUserMapper.toDto(userRepository.save(updatedUser));
    }

    @Override
    public void deleteUser(final Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(id);
    }

}
