package com.HRApp.controller;

import com.HRApp.lib.dto.LoginRequestDto;
import com.HRApp.entity.Hr;
import com.HRApp.lib.resource.TokenResponse;
import com.HRApp.repository.HrRepo;
import com.HRApp.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/token")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private HrRepo userRepository;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequestDto request) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        final Hr employee = userRepository.findByEmail(request.getEmail());
        final String token = jwtTokenUtil.generateToken(employee);
        return ResponseEntity.ok(new TokenResponse(employee.getEmail(), token));
    }
}
