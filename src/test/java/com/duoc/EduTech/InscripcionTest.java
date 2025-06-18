package com.duoc.EduTech;


import com.duoc.EduTech.Repository.InscripcionRepository;

import com.duoc.EduTech.Service.InscripcionService;
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

public class InscripcionTest {

    @Autowired
    InscripcionRepository InscripcionRepository;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    InscripcionService InscripcionService;

    @Test
    void addInscripcion(){ // Agregar


    }
    @Test
    void getAllInscripcion(){   //Listar


    }
    @Test
    void deleteInscripcion(){   //Borrar/Delete


    }
    @Test
    void getInscripcionById(){    //Listar por ID


    }
    @Test
    void updateInscripcion(){     // Actualizar Inscripcion//Update Inscripcion


    }






}
