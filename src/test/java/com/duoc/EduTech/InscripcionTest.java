package com.duoc.EduTech;

import com.duoc.EduTech.Model.Inscripcion;
import com.duoc.EduTech.Repository.InscripcionRepository;

import com.duoc.EduTech.Service.InscripcionService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
@AutoConfigureMockMvc
class InscripcionTest {

    @Autowired
    InscripcionRepository inscripcionRepository;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    InscripcionService inscripcionService;

    @Test
    void findAllInscripcionesTest() {
        List<Inscripcion> inscripciones = inscripcionRepository.findAll();

        assertNotNull(inscripciones);
        assertTrue(inscripciones.size() >= 0);
    }

    @Test
    void checkFechaInscripcion() {
        Optional<Inscripcion> inscripcion = inscripcionRepository.findById(1);
        assertTrue(inscripcion.isPresent());
        assertNotNull(inscripcion.get().getFecha_inscripcion());
    }

    @Test
    void checkGetAllInscripcionesController() {
        Mockito.when(inscripcionService.getAllInscripcion()).thenReturn("Lista De inscripciones");

        try {
            mockMvc.perform(get("/inscripcion"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Lista De inscripciones"));
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            fail();
        }
    }
    @Test
    void checkDeleteInscripcionController() {
        Mockito.when(inscripcionService.deleteInscripcion(1)).thenReturn("inscripcion eliminada.");

        try {
            mockMvc.perform(delete("/inscripcion/1"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("inscripcion eliminada."));
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            fail();


        }

    }


    @Test
    void checkGetInscripcionByIdController() {
        Mockito.when(inscripcionService.getInscripcionById(1))
                .thenReturn("id: 1\nfecha de inscripcion: 2025-06-19\n");

        try {
            mockMvc.perform(get("/inscripcion/1"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("id: 1\nfecha de inscripcion: 2025-06-19\n"));
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            fail();
        }
    }
}






