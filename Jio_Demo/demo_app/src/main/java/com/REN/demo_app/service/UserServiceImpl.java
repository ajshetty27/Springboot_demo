package com.REN.demo_app.service;

import com.REN.demo_app.data.models.User;
import com.REN.demo_app.data.payloads.request.UserRequest;
import com.REN.demo_app.data.payloads.response.MessageResponse;
import com.REN.demo_app.data.repository.UserRepository;
import com.REN.demo_app.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService{

   @Autowired
   UserRepository userRepository;

   @Override

   public MessageResponse createUser(UserRequest userRequest) {
        User newUser = new User();
        newUser.setFirstName(userRequest.getFirstName());
        newUser.setLastname(userRequest.getLastname());
        newUser.setPhoneNumber(userRequest.getPhoneNumber());
        newUser.setEmail(userRequest.getEmail());
        userRepository.save(newUser);
        return new MessageResponse("New User created successfully");
    }

  @Override
    public Optional<User> updateUser(Integer userId, UserRequest userRequest)  throws ResourceNotFoundException{
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()){
        throw new ResourceNotFoundException("User", "id", userId);
        }
        else
        user.get().setFirstName(userRequest.getFirstName());
        user.get().setLastname(userRequest.getLastname());
        user.get().setPhoneNumber(userRequest.getPhoneNumber());
        user.get().setEmail(userRequest.getEmail());
        userRepository.save(user.get());
        return user;
    }
    @Override
    public User getASingleUser(Integer userId) throws ResourceNotFoundException{
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    @Override
   public List<User> getAllUser() {
       return userRepository.findAll();
   }

   @Override
   public void deleteUser(Integer userId) throws ResourceNotFoundException {
       if (userRepository.getById(userId).getId().equals(userId)){
           userRepository.deleteById(userId);
       }
       else throw new ResourceNotFoundException("User", "id", userId);
   }
}
