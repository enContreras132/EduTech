package com.duoc.EduTech;

import com.duoc.EduTech.Model.Curso;
import com.duoc.EduTech.Repository.CursoRepository;
import com.duoc.EduTech.Service.CursoService;
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

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc

public class CursosTest {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    CursoService cursoService;

    @Test
    void FindAllCursosTest() {
        List <Curso> cursos = cursoRepository.findAll();

        assertNotNull(cursos);
        assertEquals(1,cursos.size());

    }

    @Test
    void checkNameCurso() {
        Curso curso = cursoRepository.findById(1).get();

        assertNotNull(curso);
        assertEquals("",curso.getNombre());
    }
    @Test
    void deleteCursoByIdTest() {
        //ESTE TEST ES UNA PRUEBA PARA BORRAR CURSOS

        Curso curso = new Curso();
        curso.setNombre("Curso de Prueba");
        curso.setDescripcion("Este curso será eliminado");
        curso.setCapacidad(20);


        Curso savedCurso = cursoRepository.save(curso);
        int savedId = savedCurso.getId();


        assertTrue(cursoRepository.findById(savedId).isPresent());


        cursoRepository.deleteById(savedId);


        assertFalse(cursoRepository.findById(savedId).isPresent());
    }

    @Test
    public void CheckGetAllCursosRepository() {
        Mockito.when(cursoService.getAllCursos()).thenReturn("ListaCompleta");

        try {
            mockMvc.perform(get("/clase"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("ListaCompleta"));


        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
            fail();
        }
    }
}




