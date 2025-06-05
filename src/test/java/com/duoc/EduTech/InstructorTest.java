package com.duoc.EduTech;


import com.duoc.EduTech.Repository.InstructorRepository;
import com.duoc.EduTech.Service.InstructorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

public class InstructorTest {

    @Autowired
    InstructorRepository InstructorRepository;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    InstructorService InstructorService;

}
