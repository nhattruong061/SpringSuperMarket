package com.team.service;


import com.team.domain.User;

public interface UserDetailsService {
    User findByEmail(String Email);
}