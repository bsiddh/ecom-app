package com.app.ecom.controller;

import com.app.ecom.model.User;
import com.app.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.fetchAllUsers(),HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUsers(@RequestBody  User user){
        userService.addUsers(user);
        return ResponseEntity.ok("user added successfully");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsers(@PathVariable Long id){
        return userService.fetchUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUsers(@RequestBody  User updatedUser,@PathVariable Long id){
          boolean updated = userService.updateUser(id,updatedUser);
          if (updated)
              return ResponseEntity.ok("user updated successfully");
        return ResponseEntity.notFound().build();
    }
}
