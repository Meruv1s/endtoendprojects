package com.sumanth.backendconcepts.controller;



import com.sumanth.backendconcepts.payload.JwtAuthResponse;
import com.sumanth.backendconcepts.payload.LoginDto;
import com.sumanth.backendconcepts.payload.UserDto;
import com.sumanth.backendconcepts.security.JwtTokenProvider;
import com.sumanth.backendconcepts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
     @Autowired
      UserService userService;
     @Autowired
     private AuthenticationManager authenticationManager;
     @Autowired
     private JwtTokenProvider jwtTokenProvider;
    @PostMapping("/register")
    public ResponseEntity<UserDto> createuser (@RequestBody UserDto userdto)
    {
return new ResponseEntity<>(  userService.createuser(userdto), HttpStatus.CREATED);

    }
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> loginUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

        System.out.println(authentication);

        SecurityContextHolder.getContext().setAuthentication(authentication);

       String token = jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtAuthResponse(token));
       // return new ResponseEntity<>("user logged in successfully",HttpStatus.OK);
    }

}
