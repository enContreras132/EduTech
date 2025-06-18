package com.duoc.EduTech.Controller;

import com.duoc.EduTech.Model.Administrador;
import com.duoc.EduTech.Service.AdministradorService;
import com.duoc.EduTech.Service.ClienteAlumnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
            @ApiResponse(responseCode = "200", description = "se muestra la lista de administradores"),
            @ApiResponse(responseCode = "400", description = "No se ha podido encontrar a los administradores")

    })
    public String getAllAdministrador(){
        return AdministradorService.getAllAdministrador();
    }

    @GetMapping("/{id}")
    @Operation(summary = "obtener administrador por id", description = "Muestra el adminsitrador que tienen ese id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "se muestra una lista de adminstrador que tiene el id especificado"),
            @ApiResponse(responseCode = "400", description = "No se ha podido obtener al adminstrador")

    })
    public String getAdministradorById(@PathVariable int id){
        return AdministradorService.getAdministradorById(id);
    }

    @PostMapping
    @Operation(summary = "Añadir adminstrador", description = "Añade un administrador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Administrador añadido con exito"),
            @ApiResponse(responseCode = "400", description = "Ha ocurrido un problema al añadir el adminitrador")

    })
    public String addAdministrador(@RequestBody Administrador administrador){
        return AdministradorService.addAdministrador(administrador);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar administrador por id", description = "elimina al adminstador que posee ese id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Administrador eliminado con exito"),
            @ApiResponse(responseCode = "400", description = "Ha ocurrido un problema al eliminar un administrador")

    })
    public String deleteAdminstradorById(@PathVariable int id){
        return AdministradorService.deleteAdministrador(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar adminstrador", description = "Actualiza a los administradores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Admin actualizado con exito"),
            @ApiResponse(responseCode = "400", description = "Ha ocurrido un error al actualizar al administrador")

    })
    public String updateAdministrador(@PathVariable int id,@RequestBody Administrador administrador){
        return  AdministradorService.updateAdminstrador(id,administrador);
    }

}
