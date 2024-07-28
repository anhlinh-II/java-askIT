package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import vn.hoidanit.jobhunter.service.error.IdInvalidException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("users")
@RestController
public class UserController {
     private final UserService userService;

     public UserController(UserService userService) {
          this.userService = userService;
     }

     @PostMapping("")
     public ResponseEntity<User> createNewUser(@RequestBody User user) {
          User addedUser = this.userService.handleCreateUser(user);
          return ResponseEntity.status(HttpStatus.CREATED).body(addedUser);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteNewUser(@PathVariable("id") long id) {
          this.userService.deleteUser(id);
          // return ResponseEntity.status(HttpStatus.OK).body("null");
          return ResponseEntity.ok("nll");
     }

     @GetMapping("/{id}")
     public ResponseEntity<User> getUserByIdUser(@PathVariable("id") long id) throws IdInvalidException {
          if (id > 1500) {
               throw new IdInvalidException("id cannot be greater than 1500");
          }
          User fetchUser = this.userService.fetchUserById(id);
          return ResponseEntity.ok(fetchUser);
     }

     @GetMapping()
     public ResponseEntity<List<User>> getAllUser() {
          var fetchListUsers = this.userService.fetchAllUser();
          return ResponseEntity.status(HttpStatus.OK).body(fetchListUsers);
     }

     @PutMapping()
     public ResponseEntity<User> updateUserById(@RequestBody User user) {
          var id = user.getId();
          var updateUser = this.userService.updateUserById(id, user);
          return ResponseEntity.ok(updateUser);
     }

}
