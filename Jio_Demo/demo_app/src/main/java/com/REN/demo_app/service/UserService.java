package com.REN.demo_app.service;

import com.REN.demo_app.data.models.User;
import com.REN.demo_app.data.payloads.request.UserRequest;
import com.REN.demo_app.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {
    MessageResponse createUser(UserRequest userRequest);
    Optional<User> updateUser(Integer userId, UserRequest userRequest);
    void deleteUser(Integer userId);
    User getASingleUser(Integer userId);
    List<User> getAllUser();
}
