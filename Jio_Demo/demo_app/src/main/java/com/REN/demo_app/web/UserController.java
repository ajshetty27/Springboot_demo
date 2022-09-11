package com.REN.demo_app.web;

import com.REN.demo_app.data.models.User;
import com.REN.demo_app.data.payloads.request.UserRequest;
import com.REN.demo_app.data.payloads.response.MessageResponse;
import com.REN.demo_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")


public class UserController {

    @Autowired

    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") Integer id) {
        User user = userService.getASingleUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addUser( @RequestBody UserRequest user) {
        MessageResponse newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
  public Optional<User> updateUser(@PathVariable Integer id, @RequestBody UserRequest user) {
      return userService.updateUser(id, user);

  }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
