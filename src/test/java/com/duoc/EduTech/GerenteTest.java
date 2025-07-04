package com.duoc.EduTech;

import com.duoc.EduTech.Model.GerenteCursos;
import com.duoc.EduTech.Repository.GerenteRepository;
import com.duoc.EduTech.Service.GerenteCursosService;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

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
        when(gerenteCursosService.getAllGerente()).thenReturn("Lista completa");

        try {
            mockMvc.perform(get("/gerente"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Lista completa"));
        } catch (Exception e){
            System.out.println("error: "+e.getMessage());
            fail();

        }



    }
    @Test
    void addGerenteTest() throws Exception {
        when(gerenteCursosService.addGerente(Mockito.any(GerenteCursos.class)))
                .thenReturn("Gerente agregado");

        mockMvc.perform(post("/gerente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "nombre": "Test Gerente"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().string("Gerente agregado"));
    }

    @Test
    void updateGerenteTest() throws Exception {
        int id = 1;
        when(gerenteCursosService.updateGerente(Mockito.eq(id), Mockito.any(GerenteCursos.class)))
                .thenReturn("Gerente actualizado");

        mockMvc.perform(put("/gerente/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "nombre": "Gerente Modificado"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().string("Gerente actualizado"));
    }
    @Test
    void deleteGerenteTest() throws Exception {
        int id = 1;
        when(gerenteCursosService.deleteGerente(id)).thenReturn("Gerente eliminado");

        mockMvc.perform(delete("/gerente/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("Gerente eliminado"));
    }
}







