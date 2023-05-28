package com.start.project.user;

import com.start.project.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final  UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean isUser(String email){
        return userRepository.countByEmail(email) > 0? true : false;
    }
}
