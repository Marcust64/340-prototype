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

    /**
     * Finds user by email
     *
     * @param email
     * @return the matching email in repository
     */
    public Optional<User> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    /**
     * Saves user in repository
     *
     * @param user
     * @return
     */
    public User saveUser(User user) {
        return repo.save(user);
    }

    /**
     * Gets user by their id
     *
     * @param id
     * @return that specific user
     */
    public Optional<User> getUserById(Long id) {
        return repo.findById(id);
    }

    /**
     * Updates user information and saves it in repository
     *
     * @param user
     * @return
     */
    public User updateUser(User user) {
        return repo.save(user);
    }

    /**
     * deletes user by id
     *
     * @param id
     */
    public void deleteUser(Long id) {
        repo.deleteById(id);

    }

    /**
     * gets all users in repository
     *
     * @return
     */
    public List<User> getAllUsers() {
        List<User> userList = repo.findAll();
        return userList;
    }
}
