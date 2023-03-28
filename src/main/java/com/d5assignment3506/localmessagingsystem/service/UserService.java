package com.d5assignment3506.localmessagingsystem.service;

import com.d5assignment3506.localmessagingsystem.entity.User;
import com.d5assignment3506.localmessagingsystem.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User get(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User editUser(Long id, String firstName, String lastName, String email, String title) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setTitle(title);
        return userRepository.save(user);
    }

    public User createUser(String firstName, String lastName, String username, String email, String title) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setTitle(title);
        return userRepository.save(user);
    }
}
