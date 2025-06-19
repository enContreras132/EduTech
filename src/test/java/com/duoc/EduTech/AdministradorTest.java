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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

public class AdministradorTest {

    @Autowired
    AdministradorRepository  AdministradorRepository;

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
    void addDeleteAdministradorTest(){
        Administrador admin = new Administrador();
        admin.setNombre("Admin Test"); // pueden poner el nombre que sea puse test para probar
        admin.setCorreo("edutech@test.duocuc");
        admin.setContrasena("1234");

        Administrador guardado = AdministradorRepository.save(admin);
        int id = guardado.getId_admin();
        assertTrue(AdministradorRepository.findById(id).isPresent(),"El administrador se guardado");

        AdministradorRepository.deleteById(id);

        Optional<Administrador> eliminado = AdministradorRepository.findById(id);
        assertFalse(eliminado.isPresent(),"El Administrador se elimino");


    }
    @Test
    void getAdministradorById(){
        Administrador admin = new Administrador();
        admin.setNombre("Buscar Test");
        admin.setCorreo("test@duocuc.cl");
        admin.setContrasena("1234");

        Administrador guardado = AdministradorRepository.save(admin);
        int id = guardado.getId_admin();

        Optional<Administrador> encontrado = AdministradorRepository.findById(id);
        assertTrue(encontrado.isPresent(),"Deberia encontrarse el administrador por ID");

        AdministradorRepository.deleteById(id);

    }

    @Test
    void updateAdministradorTest(){
        Administrador admin = new Administrador();
        admin.setNombre("Original");
        admin.setCorreo("Original@duocuc.cl");
        admin.setContrasena("1234");

        Administrador guardado = AdministradorRepository.save(admin);
        int id = guardado.getId_admin();

        Administrador actualizado = AdministradorRepository.findById(id).get();
        actualizado.setNombre("Modificacion");
        actualizado.setCorreo("Modificacion@duocuc.cl");

        Administrador resultado = AdministradorRepository.findById(id).get();
        assertEquals("Modificacion", resultado.getNombre(), "El nombre deberia haberse actualizado");
        assertEquals("Modificacion@duocuc.cl",resultado.getCorreo(),"El correo deberia haberse actualizado");

        AdministradorRepository.deleteById(id);

    }

}
