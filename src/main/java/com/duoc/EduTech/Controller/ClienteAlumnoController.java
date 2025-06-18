package com.duoc.EduTech.Controller;

import com.duoc.EduTech.Model.ClienteAlumno;
import com.duoc.EduTech.Service.ClienteAlumnoService;
import com.duoc.EduTech.Service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@Tag(name ="Cliente Alumno", description = "Usuario del sistema")
public class ClienteAlumnoController {

    @Autowired
    ClienteAlumnoService clienteAlumnoService;

    @GetMapping
    @Operation(summary = "obtener todos los usuarios del sistema", description = "una lista con los datos de los usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "se muestra la lista de usuarios")
    })
    public String getAllClientes(){
        return clienteAlumnoService.getAllClientes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "obtener los usuarios del sistema con ese id", description = "una lista con los datos de los usuarios con dicgho id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "se muestra al usuario con el id especificado")
    })
    public String getClienteById(@PathVariable int id){
        return clienteAlumnoService.getClienteById(id);
    }

    @PostMapping
    @Operation(summary = "añade usuarios al sistema", description = "añade usuarios al sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario añadido con exito")
    })
    public String addCliente(@RequestBody ClienteAlumno clienteAlumno){
        return clienteAlumnoService.addCliente(clienteAlumno);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "elimina  usuarios del sistema por id", description = "elimina a los usuarios del sistema que posee ese id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "usuario eliminado con exito")
    })
    public String deleteClienteById(@PathVariable int id){
        return clienteAlumnoService.deleteCliente(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza a usuarios del sistema", description = "Actualiza usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "usuario actualizado con exito")
    })
    public String updateCliente(@PathVariable int id,@RequestBody ClienteAlumno clienteAlumno){
        return  clienteAlumnoService.updateCliente(id,clienteAlumno);
    }

}