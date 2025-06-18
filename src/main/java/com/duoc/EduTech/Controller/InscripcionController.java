package com.duoc.EduTech.Controller;


import com.duoc.EduTech.Model.Inscripcion;
import com.duoc.EduTech.Service.InscripcionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscripcion")
@Tag(name ="Inscripcion", description = "Inscripciones del sistema")

public class InscripcionController {

    @Autowired
    InscripcionService inscripcionService;

    @GetMapping
    @Operation(summary = "obtener inscripciones", description = "una lista con los datos de las inscripciones del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "se muestra la lista de las inscripciones"),
            @ApiResponse(responseCode = "400", description = "No se ha podido listar todas las inscripciones")

    })
    public String getAllInscripcion(){
        return inscripcionService.getAllInscripcion();
    }

    @GetMapping("/{id}")
    @Operation(summary = "obtener inscripcion por id", description = "muestra las inscripciones que tienen ese id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "se muestra la lista de las inscripciones por id"),
            @ApiResponse(responseCode = "400", description = "error al obtener la inscripcion")

    })
    public String getInscripcionById(@PathVariable int id){
        return inscripcionService.getInscripcionById(id);
    }

    @PostMapping
    @Operation(summary = "Añadir inscripcion", description = "Añade inscripciones al sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inscripcion añadida con exito"),
            @ApiResponse(responseCode = "400", description = "Error al añadir la inscripcion")

    })
    public String addInscripcion(@RequestBody Inscripcion inscripcion){
        return inscripcionService.addInscripcion(inscripcion);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "eliminar inscripcion", description = "elimina una inscripcion por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "inscripcion eliminada "),
            @ApiResponse(responseCode = "400", description = "Error al eliminar la inscripcion")

    })
    public String deleteInscripcionById(@PathVariable int id){
        return inscripcionService.deleteInscripcion(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar inscripcion", description = "Actualiza las inscripciones del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inscripcion actualizada"),
            @ApiResponse(responseCode = "400", description = "Error al actualizar la inscripcion")

    })
    public String updateInscripcion(@PathVariable int id,@RequestBody Inscripcion inscripcion){
        return inscripcionService.updateIncripcion(id,inscripcion);
    }
}
