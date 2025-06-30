package com.duoc.EduTech;


import com.duoc.EduTech.Model.ClienteAlumno;
import com.duoc.EduTech.Repository.ClienteRepository;
import com.duoc.EduTech.Service.ClienteAlumnoService;
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

public class ClienteTest {

    @Autowired
    ClienteRepository  ClienteRepository;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ClienteAlumnoService ClienteAlumnoService;

    @Test
    void getAllClientesTest() throws Exception {
        Mockito.when(ClienteAlumnoService.getAllClientes()).thenReturn("Lista de clientes");

        mockMvc.perform(get("/cliente"))
                .andExpect(status().isOk())
                .andExpect(content().string("Lista de clientes"));
    }
    @Test
    void getClienteByIdTest() throws Exception {
        int id = 1;
        Mockito.when(ClienteAlumnoService.getClienteById(id)).thenReturn("Cliente encontrado");

        mockMvc.perform(get("/cliente/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("Cliente encontrado"));
    }

    @Test
    void addClienteTest() throws Exception {
        Mockito.when(ClienteAlumnoService.addCliente(Mockito.any(ClienteAlumno.class)))
                .thenReturn("Cliente agregado con éxito");

        mockMvc.perform(post("/cliente")
                        .contentType("application/json")
                        .content("""
                                {
                                    "nombre": "Juan",
                                    "correo": "juan@duoc.cl",
                                    "contrasena": "12345"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().string("Cliente agregado con éxito"));
    }

    @Test
    void updateClienteTest() throws Exception {
        int id = 1;
        Mockito.when(ClienteAlumnoService.updateCliente(Mockito.eq(id), Mockito.any(ClienteAlumno.class)))
                .thenReturn("Cliente actualizado");

        mockMvc.perform(put("/cliente/{id}", id)
                        .contentType("application/json")
                        .content("""
                                {
                                    "nombre": "Juan Modificado",
                                    "correo": "nuevo@duoc.cl",
                                    "contrasena": "54321"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().string("Cliente actualizado"));
    }
    @Test
    void deleteClienteTest() throws Exception {
        int id = 1;
        Mockito.when(ClienteAlumnoService.deleteCliente(id)).thenReturn("Cliente eliminado");

        mockMvc.perform(delete("/cliente/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("Cliente eliminado"));
    }


}
