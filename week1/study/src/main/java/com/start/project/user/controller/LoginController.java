package com.start.project.user.controller;

import com.start.project.user.dto.UserSaveRequest;
import com.start.project.user.dto.UserSaveResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/login/*")
public class LoginController {

    @PostMapping("/join")
    public UserSaveResponse join(@RequestBody UserSaveRequest userSaveRequest){

    }
}
