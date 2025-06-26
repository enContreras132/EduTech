package com.duoc.EduTech;

import com.duoc.EduTech.Model.GerenteCursos;
import com.duoc.EduTech.Repository.GerenteRepository;
import com.duoc.EduTech.Service.GerenteCursosService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc

public class GerenteTest {
    @Autowired
    GerenteRepository  gerenteRepository;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GerenteCursosService gerenteCursosService;

    //metodo que crea un campo en la base de datos para que la prueba findAllGerentes corra bien
    @BeforeEach
    void guardarCampoBd() {
        GerenteCursos gerente = new GerenteCursos();
        gerente.setNombre("Gerente de Prueba 1");
        gerenteRepository.save(gerente); // Guarda el gerente en la BD de prueba
    }

    @Test
    void findAllGerentesTest() {
        List<GerenteCursos> gerentes = gerenteRepository.findAll();

            assertNotNull(gerentes);
            assertEquals(8,gerentes.size());

    }
    @Test
    void checkGerenteNombreTest(){
        GerenteCursos gerente = gerenteRepository.findById(1).get();

        assertNotNull(gerente);
        assertEquals("Gerente de Prueba 1",gerente.getNombre());

    }
    @Test
    void chekGetAllGerentes(){
        Mockito.when(gerenteCursosService.getAllGerente()).thenReturn("Lista completa");

        try {
            mockMvc.perform(get("/gerente"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Lista completa"));
        } catch (Exception e){
            System.out.println("error: "+e.getMessage());
            fail();

        }



    }






}
