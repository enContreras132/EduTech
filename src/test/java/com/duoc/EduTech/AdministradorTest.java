package com.duoc.EduTech;


import com.duoc.EduTech.Model.Administrador;
import com.duoc.EduTech.Repository.AdministradorRepository;
import com.duoc.EduTech.Service.AdministradorService;
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

public class AdministradorTest {

    @Autowired
    AdministradorRepository administradorRepository;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    AdministradorService  AdministradorService;

    @Test
    void getAllAdministradoresTest(){
        Mockito.when(AdministradorService.getAllAdministrador()).thenReturn("Lista de administradores");

        try {
            mockMvc.perform(get("/admin"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Lista de administradores"));
        }catch (Exception e){
            fail("Fallo la peticion get /admin:" + e.getMessage());


        }


    }

    @Test
    void getAdministradorByIdTest() throws Exception {
        int id = 1;
        Mockito.when(AdministradorService.getAdministradorById(id)).thenReturn("Admin encontrado");

        mockMvc.perform(get("/admin/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("Admin encontrado"));
    }

    @Test
    void addAdministradorTest() throws Exception {
        Administrador admin = new Administrador();
        admin.setNombre("Test");
        admin.setCorreo("test@duoc.cl");
        admin.setContrasena("1234");

        Mockito.when(AdministradorService.addAdministrador(Mockito.any(Administrador.class)))
                .thenReturn("Administrador añadido con exito");

        mockMvc.perform(post("/admin")
                        .contentType("application/json")
                        .content("""
                    {
                        "nombre": "Test",
                        "correo": "test@duoc.cl",
                        "contrasena": "1234"
                    }
                    """))
                .andExpect(status().isOk())
                .andExpect(content().string("Administrador añadido con exito"));
    }

    @Test
    void deleteAdministradorTest() throws Exception {
        int id = 1;
        Mockito.when(AdministradorService.deleteAdministrador(id)).thenReturn("Administrador eliminado con exito");

        mockMvc.perform(delete("/admin/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("Administrador eliminado con exito"));
    }

    @Test
    void updateAdministradorTest() throws Exception {
        int id = 1;
        Mockito.when(AdministradorService.updateAdminstrador(Mockito.eq(id), Mockito.any(Administrador.class)))
                .thenReturn("Admin actualizado con exito");

        mockMvc.perform(put("/admin/{id}", id)
                        .contentType("application/json")
                        .content("""
                    {
                        "nombre": "Modificado",
                        "correo": "nuevo@duoc.cl",
                        "contrasena": "5678"
                    }
                    """))
                .andExpect(status().isOk())
                .andExpect(content().string("Admin actualizado con exito"));
    }










}
