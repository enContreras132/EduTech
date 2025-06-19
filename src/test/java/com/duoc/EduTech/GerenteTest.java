package com.duoc.EduTech;

import com.duoc.EduTech.Model.GerenteCursos;
import com.duoc.EduTech.Repository.GerenteRepository;
import com.duoc.EduTech.Service.GerenteCursosService;
import jakarta.persistence.EntityNotFoundException;
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

@SpringBootTest
@AutoConfigureMockMvc

public class GerenteTest {
    @Autowired
    GerenteRepository  GerenteRepository;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GerenteCursosService GerenteCursosService;

    @Test
    void findAllGerentesTest() {
        List<GerenteCursos> gerentes = GerenteRepository.findAll();

            assertNotNull(gerentes);
            assertTrue(gerentes.size() >= 0);


    }
    @Test
    void checkGerenteNombreTest(){
        Optional<GerenteCursos> optionalGerente = GerenteRepository.findById(1);

        assertTrue(optionalGerente.isPresent());
        assertNotNull(optionalGerente.get().getNombre());


    }
    @Test
    void chekGetAllGerentesEndpointTest(){
        Mockito.when(GerenteCursosService.getAllGerente()).thenReturn(String.valueOf(List.of()));

        try {
            mockMvc.perform(get("/gerente"))
                    .andExpect(status().isOk());

        } catch (Exception e){
            fail("fallo el endpoint:" + e.getMessage());

        }



    }
    @Test
    void deleteGerenteByIdTest(){
        GerenteCursos gerente = new GerenteCursos();
        gerente.setNombre("Prueba");
        gerente.setCorreo("prueba@correo.com");
        gerente.setContrasena("1234");
        gerente.setDepartamento("Educación");

        GerenteCursos savedGerente = GerenteRepository.save(gerente);
        int id = savedGerente.getId();

        assertTrue(GerenteRepository.findById(id).isPresent());

        GerenteRepository.deleteById(id);
        assertFalse(GerenteRepository.findById(id).isPresent());


    }
    @Test
    void gerenteNoEncontradoLanzaExepcion(){
        int idInexistente = 999999;

        assertThrows(EntityNotFoundException.class,() -> {
            GerenteCursosService.getGerenteById(idInexistente);
        });


    }




}
