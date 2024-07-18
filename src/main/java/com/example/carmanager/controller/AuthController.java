package com.example.carmanager.controller;

import com.example.carmanager.dto.LoginResponse;
import com.example.carmanager.dto.RegisterUserDto;
import com.example.carmanager.dto.UserLoginDto;
import com.example.carmanager.entity.User;
import com.example.carmanager.repository.UserRepository;
import com.example.carmanager.service.AuthenticationService;
import com.example.carmanager.service.JWTService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthController {
    private final JWTService jwtService;
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    public AuthController(JWTService jwtService, AuthenticationService authenticationService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody RegisterUserDto registerUserDto) {
        System.out.println("registerUserDto");
        System.out.println(registerUserDto);
        User registeredUser = authenticationService.signUp(registerUserDto);
        userRepository.save(registeredUser);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserLoginDto userLoginDto){
            User user = authenticationService.authenticate(userLoginDto);
            String jwtToken = jwtService.generateToken(user);
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(jwtToken);
            return ResponseEntity.ok(loginResponse);
    }
}
