package com.pickandgo.demo.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 *
 * @author Marcus Thompson
 */

@Service
public class UserService {
    
    @Autowired
    UserRepository repo;


    public Optional<User> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    
    public User saveUser(User user) {
       return repo.save(user);
     }
  
    //Get a user by ID
    public Optional<User> getUserById(Long id) {
        return repo.findById(id);
    }

    // Update a user
    public User updateUser(User user) {
        return repo.save(user);
    }

    // Delete a user
    public void deleteUser(Long id) {
        repo.deleteById(id);

    }
}
