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
    InstructorRepository InstructorRepository;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    InstructorService InstructorService;

    @Test
    void checkNombreInstructor() {
        Optional<Instructor> optionalInstructor = InstructorRepository.findById(1);
        assertTrue(optionalInstructor.isPresent());

        Instructor instructor = optionalInstructor.get();
        assertEquals("", instructor.getNombre());
    }

    @Test
    void deleteInstructorByIdTest() {
        Instructor instructor = new Instructor();
        instructor.setNombre("Instructor Prueba");
        instructor.setEspecialidad("Test");
        instructor.setCorreo("test@edu.com");
        instructor.setContrasena("1234");

        Instructor saved = InstructorRepository.save(instructor);
        int id = saved.getId();

        assertTrue(InstructorRepository.findById(id).isPresent());

        InstructorRepository.deleteById(id);

        assertFalse(InstructorRepository.findById(id).isPresent());
    }

    @Test
    void findAllInstructoresTest() {
        List<Instructor> instructors = InstructorRepository.findAll();

        assertNotNull(instructors);

        assertTrue(instructors.size() >= 1);
    }

    @Test
    void VerNombreInstuctor() {
        Optional<Instructor> optInstructor = InstructorRepository.findById(1);
        assertTrue(optInstructor.isPresent());
        Instructor instructor = optInstructor.get();


        assertEquals("NombreEsperado", instructor.getNombre());
    }

    @Test
     void GuardarInstructor() {
        Instructor instructor = new Instructor();
        instructor.setNombre("Instructor Test");
        instructor.setEspecialidad("Test Especialidad");
        instructor.setCorreo("test@edu.com");
        instructor.setContrasena("1234");


        Instructor saved = InstructorRepository.save(instructor);
        int savedId = saved.getId();


        assertTrue(InstructorRepository.findById(savedId).isPresent());


        InstructorRepository.deleteById(savedId);


        assertFalse(InstructorRepository.findById(savedId).isPresent());
    }

    @Test
    void getAllInstructoresEndpointTest() throws Exception {
        List<Instructor> mockList = Arrays.asList(
                new Instructor(),
                new Instructor()
        );

        when(InstructorService.obtenerTodos()).thenReturn(mockList);

        mockMvc.perform(get("/instructores"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Luis")));

        verify(InstructorService).obtenerTodos();
    }

    @Test
    void deleteInstructorEndpointTest() throws Exception {
        int idToDelete = 5;

        Mockito.doNothing().when(InstructorService).deleteInstructor(idToDelete);

        mockMvc.perform(delete("/instructores/" + idToDelete))
                .andExpect(status().isOk())
               
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Eliminado")));

        verify(InstructorService).getInstructorById(1);


    }
}