package vn.hoidanit.jobhunter.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.repository.UserRepository;

@Service
public class UserService {
     private final UserRepository userRepository;

     private UserService(UserRepository userRepository) {
          this.userRepository = userRepository;
     }

     public User handleCreateUser(User user) {
          return this.userRepository.save(user);
     }

     public void deleteUser(long userId) {
          this.userRepository.deleteById(userId);
     }

     public User fetchUserById(long userId) {
          Optional<User> optionalUser = this.userRepository.findById(userId);
          if (optionalUser.isPresent()) {
               return optionalUser.get();
          }
          return null;
     }

     public List<User> fetchAllUser() {
          return this.userRepository.findAll();
     }

     public User updateUserById(long id, User userUpdateRequest) {
          var currentUser = this.fetchUserById(id);
          if (currentUser != null) {
               currentUser.setName(userUpdateRequest.getName());
               currentUser.setEmail(userUpdateRequest.getEmail());
               currentUser.setPassword(userUpdateRequest.getPassword());

               currentUser = this.userRepository.save(currentUser);
          }
          return currentUser;
     }
}
