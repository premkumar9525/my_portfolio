package com.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.repository.UserRepository;

@Service
public class UserService {
@Autowired
UserRepository userRepo;
}
