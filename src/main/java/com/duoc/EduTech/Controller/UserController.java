package com.duoc.EduTech.Controller;

import com.duoc.EduTech.Model.User;
import com.duoc.EduTech.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;


}
