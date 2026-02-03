package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.fetchAllUsers(),HttpStatus.OK);
    }

    @PostMapping("/api/users")
    public ResponseEntity<String> createUsers(@RequestBody  User user){
        userService.addUsers(user);
        return ResponseEntity.ok("user added successfully");
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUsers(@PathVariable Long id){
        User user = userService.fetchUser(id);
        if (user == null)
       return    ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }
}
