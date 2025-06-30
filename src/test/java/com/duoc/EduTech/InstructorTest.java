package com.duoc.EduTech;


import com.duoc.EduTech.Model.Instructor;
import com.duoc.EduTech.Repository.InstructorRepository;
import com.duoc.EduTech.Service.InstructorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

public class InstructorTest {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    InstructorService instructorService;


    @Test
    void getAllInstructors() throws Exception {
        when(instructorService.getAllInstructor()).thenReturn("Lista de instructores");

        mockMvc.perform(get("/instructor"))
                .andExpect(status().isOk())
                .andExpect(content().string("Lista de instructores"));
    }

    @Test
    void getInstructorById() throws Exception {
        int id = 1;
        when(instructorService.getInstructorById(id)).thenReturn("Instructor encontrado");

        mockMvc.perform(get("/instructor/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("Instructor encontrado"));
    }

    @Test
    void addInstructor() throws Exception {
        when(instructorService.addInstructor(Mockito.any(Instructor.class)))
                .thenReturn("Instructor añadido");

        mockMvc.perform(post("/instructor")
                        .contentType("application/json")
                        .content("""
                    {
                        "nombre": "Test Instructor",
                        "correo": "instructor@duoc.cl",
                        "contrasena": "1234"
                    }
                """))
                .andExpect(status().isOk())
                .andExpect(content().string("Instructor añadido"));
    }

    @Test
    void updateInstructor() throws Exception {
        int id = 1;
        when(instructorService.updateInstructor(Mockito.eq(id), Mockito.any(Instructor.class)))
                .thenReturn("instructor actualizado");

        mockMvc.perform(put("/instructor/{id}", id)
                        .contentType("application/json")
                        .content("""
                    {
                        "nombre": "Editado",
                        "correo": "editado@duoc.cl",
                        "contrasena": "5678"
                    }
                """))
                .andExpect(status().isOk())
                .andExpect(content().string("instructor actualizado"));
    }

    @Test
    void deleteInstructor() throws Exception {
        int id = 1;
        when(instructorService.deleteInstructor(id)).thenReturn("Instructor elimiando");

        mockMvc.perform(delete("/instructor/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("Instructor elimiando"));
    }

    @Test
    void guardarYEliminarInstructorDesdeRepository() {
        Instructor instructor = new Instructor();
        instructor.setNombre("Persistente");
        instructor.setCorreo("persistente@duoc.cl");
        instructor.setContrasena("clave");

        Instructor guardado = instructorRepository.save(instructor);
        int id = guardado.getId();

        Optional<Instructor> encontrado = instructorRepository.findById(id);
        assertTrue(encontrado.isPresent(), "Instructor debería estar presente en la base de datos");

        instructorRepository.deleteById(id);
        Optional<Instructor> eliminado = instructorRepository.findById(id);
        assertFalse(eliminado.isPresent(), "Instructor debería haber sido eliminado");
    }
}