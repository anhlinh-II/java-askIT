package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
     private final UserService userService;

     public UserController(UserService userService) {
          this.userService = userService;
     }
     
     @PostMapping("/user/create")
     public User createNewUser(@RequestBody User user) {
          User addedUser = this.userService.handleCreateUser(user);
          return addedUser;
     }
}