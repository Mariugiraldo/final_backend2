package com.example.msusers.controller;

import com.example.msusers.controller.response.UserBillsResponse;
import com.example.msusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserBillsResponse> findUserWithBills(@PathVariable String userId) throws Exception {
        return new ResponseEntity<>(userService.findUserWithBills(userId), HttpStatus.OK);
    }
}
