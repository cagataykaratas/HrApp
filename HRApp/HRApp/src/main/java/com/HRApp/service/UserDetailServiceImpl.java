package com.HRApp.service;

import com.HRApp.entity.Hr;
import com.HRApp.repository.HrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private HrRepo hrRepo;

    @Override
    public UserDetails loadUserByUsername(String hrEmail) throws UsernameNotFoundException {
        Hr hr = hrRepo.findByEmail(hrEmail);
        if (hr == null){
            throw new UsernameNotFoundException("invalid");
        }
        return new org.springframework.security.core.userdetails.User(hr.getEmail(), hr.getPassword(), Arrays.asList((new SimpleGrantedAuthority("APPLICANT"))));
    }
}
