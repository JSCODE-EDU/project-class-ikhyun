package com.start.project.user.service;

import com.start.project.model.code.STATUS;
import com.start.project.user.dto.UserSaveRequest;
import com.start.project.user.dto.UserSaveResponse;
import com.start.project.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(final  UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public boolean isUser(String email){
        return userRepository.countByEmail(email) > 0? true : false;
    }

    public UserSaveResponse createUser(UserSaveRequest userSaveRequest){
        userRepository.save(userSaveRequest.toEntity());
        return new UserSaveResponse(STATUS.Success201.getCode(),
                userSaveRequest.getEmail() + " 회원가입이 되었습니다.");
    }
}
