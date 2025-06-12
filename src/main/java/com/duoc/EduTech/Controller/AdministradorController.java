package com.duoc.EduTech.Controller;

import com.duoc.EduTech.Model.Administrador;
import com.duoc.EduTech.Service.AdministradorService;
import com.duoc.EduTech.Service.ClienteAlumnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Tag(name ="Administradores", description = "Super administradores del sistema")
public class AdministradorController {

    @Autowired
    AdministradorService AdministradorService;

    @GetMapping
    @Operation(summary = "obtener todos los administradores del sistema", description = "una lista con los datos de los administradores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "se muestra la lista de administradores")
    })
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
