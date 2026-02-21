package com.vshm.service;

import com.vshm.entity.Role;
import com.vshm.entity.User;
import com.vshm.exception.ResourceNotFoundException;
import com.vshm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;

    public List<User> users() {
        return userRepository.findAll();
    }

    public User setActive(Long id, boolean active) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setActive(active);
        return userRepository.save(user);
    }

    public User setRole(Long id, Role role) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setRole(role);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
