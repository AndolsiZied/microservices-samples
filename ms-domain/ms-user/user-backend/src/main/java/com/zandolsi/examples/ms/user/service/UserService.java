package com.zandolsi.examples.ms.user.service;

import com.zandolsi.examples.ms.user.model.User;
import com.zandolsi.examples.ms.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User get(String id) {
        return userRepository.findOne(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
