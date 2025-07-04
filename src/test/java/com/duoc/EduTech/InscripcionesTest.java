package com.duoc.EduTech;

import com.duoc.EduTech.Model.Inscripcion;
import com.duoc.EduTech.Service.InscripcionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class InscripcionesTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    InscripcionService inscripcionService;

    @Test
    void getAllInscripcionesTest() throws Exception {
        Mockito.when(inscripcionService.getAllInscripcion()).thenReturn("Lista de inscripciones");

        mockMvc.perform(get("/inscripcion"))
                .andExpect(status().isOk())
                .andExpect(content().string("Lista de inscripciones"));
    }

    @Test
    void getInscripcionByIdTest() throws Exception {
        int id = 1;
        Mockito.when(inscripcionService.getInscripcionById(id)).thenReturn("Inscripción encontrada");

        mockMvc.perform(get("/inscripcion/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("Inscripción encontrada"));
    }

    @Test
    void addInscripcionTest() throws Exception {
        Mockito.when(inscripcionService.addInscripcion(Mockito.any(Inscripcion.class)))
                .thenReturn("Inscripción agregada");

        mockMvc.perform(post("/inscripcion")
                        .contentType("application/json")
                        .content("""
                            {
                                "nombre": "Curso Test",
                                "descripcion": "Inscripción de prueba"
                            }
                        """))
                .andExpect(status().isOk())
                .andExpect(content().string("Inscripción agregada"));
    }

    @Test
    void updateInscripcionTest() throws Exception {
        int id = 1;
        Mockito.when(inscripcionService.updateIncripcion(Mockito.eq(id), Mockito.any(Inscripcion.class)))
                .thenReturn("Inscripción actualizada");

        mockMvc.perform(put("/inscripcion/{id}", id)
                        .contentType("application/json")
                        .content("""
                            {
                                "nombre": "Curso Modificado",
                                "descripcion": "Descripción modificada"
                            }
                        """))
                .andExpect(status().isOk())
                .andExpect(content().string("Inscripción actualizada"));
    }

    @Test
    void deleteInscripcionTest() throws Exception {
        int id = 1;
        Mockito.when(inscripcionService.deleteInscripcion(id)).thenReturn("Inscripción eliminada");

        mockMvc.perform(delete("/inscripcion/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("Inscripción eliminada"));
    }
}
