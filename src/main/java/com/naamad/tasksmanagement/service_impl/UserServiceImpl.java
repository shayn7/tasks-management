package com.naamad.tasksmanagement.service_impl;

import com.naamad.tasksmanagement.dto.UserRequest;
import com.naamad.tasksmanagement.dto.UserResponse;
import com.naamad.tasksmanagement.entity.User;
import com.naamad.tasksmanagement.repository.UserRepository;
import com.naamad.tasksmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User user = User
                .builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .active(userRequest.getActive())
                .password(userRequest.getPassword())
                .build();
        userRepository.save(user);
        return mapToUserResponse(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToUserResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        findUserById(id).ifPresentOrElse(userRepository::delete, () -> { throw new RuntimeException("User does not exist!"); });
    }

    @Override
    public Long updateUser(Long id, UserRequest userRequest) {
        Optional<User> user = findUserById(id);
        if(user.isEmpty()) throw new RuntimeException("User does not exist!");
        user.get().setName(userRequest.getName());
        user.get().setEmail(userRequest.getEmail());
        user.get().setActive(userRequest.getActive());
        user.get().setPassword(userRequest.getPassword());
        return userRepository.save(user.get()).getUserId();
    }

    private UserResponse mapToUserResponse(User user) {
        return UserResponse
                .builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .active(user.getActive())
                .build();
    }
}
