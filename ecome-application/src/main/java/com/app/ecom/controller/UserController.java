package com.app.ecom.controller;

import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
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
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return new ResponseEntity<>(userService.fetchAllUsers(),HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUsers(@RequestBody UserRequest userRequest){
        userService.addUsers(userRequest);
        return ResponseEntity.ok("user added successfully");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUsers(@PathVariable Long id){
        return userService.fetchUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUsers(@RequestBody  UserRequest updateUerRequest,@PathVariable Long id){
          boolean updated = userService.updateUser(id,updateUerRequest);
          if (updated)
              return ResponseEntity.ok("user updated successfully");
        return ResponseEntity.notFound().build();
    }
}
