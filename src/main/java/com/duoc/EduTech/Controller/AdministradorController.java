package com.duoc.EduTech.Controller;

import com.duoc.EduTech.Model.Administrador;
import com.duoc.EduTech.Service.AdministradorService;
import com.duoc.EduTech.Service.ClienteAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdministradorController {

    @Autowired
    AdministradorService AdministradorService;

    @GetMapping
    public String getAllAdministrador(){
        return AdministradorService.getAllAdministrador();
    }

    @GetMapping("/{id}")
    public String getAdministradorById(@PathVariable int id){
        return AdministradorService.getAdministradorById(id);
    }

    @PostMapping
    public String addAdministrador(@RequestBody Administrador administrador){
        return AdministradorService.addAdministrador(administrador);
    }

    @DeleteMapping("/{id}")
    public String deleteAdminstradorById(@PathVariable int id){
        return AdministradorService.deleteAdministrador(id);
    }

    @PutMapping("/{id}")
    public String updateAdministrador(@PathVariable int id,@RequestBody Administrador administrador){
        return  AdministradorService.updateAdminstrador(id,administrador);
    }

}
