package com.duoc.EduTech.Service;

import com.duoc.EduTech.Model.User;
import com.duoc.EduTech.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


}