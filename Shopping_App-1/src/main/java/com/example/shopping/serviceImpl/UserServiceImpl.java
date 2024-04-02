package com.example.shopping.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.entity.User;
import com.example.shopping.repository.UserRepository;
import com.example.shopping.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                             .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id)
                                         .orElseThrow(() -> new RuntimeException("User not found"));
        // Update existing user fields with new values
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        // Update other fields as needed

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                                 .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
