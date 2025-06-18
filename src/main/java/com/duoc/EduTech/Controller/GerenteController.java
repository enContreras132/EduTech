package com.duoc.EduTech.Controller;

import com.duoc.EduTech.Model.Curso;
import com.duoc.EduTech.Model.GerenteCursos;
import com.duoc.EduTech.Service.CursoService;
import com.duoc.EduTech.Service.GerenteCursosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gerente")
@Tag(name ="Gerente", description = "Gerentes del sistema")
public class GerenteController {

    @Autowired
    GerenteCursosService gerenteCursosService;

    @GetMapping
    @Operation(summary = "obtener todos los gerentes del sistema", description = "una lista con los datos de los gerentes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "se muestra la lista de gerentes"),
            @ApiResponse(responseCode = "400", description = "No se ha podido listar los gerentes")


    })
    public String getAllGerente(){
        return gerenteCursosService.getAllGerente();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener gerente por id", description = "Muestra al gerente que tiene ese id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gerente mostrado "),
            @ApiResponse(responseCode = "400", description = "Error al mostrar el gerente")

    })
    public String getGerenteById(@PathVariable int id){
        return gerenteCursosService.getGerenteById(id);
    }

    @PostMapping
    @Operation(summary = "Añadir gerente", description = "añade gerentes al sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gerente añadido con exito"),
            @ApiResponse(responseCode = "400", description = "Error al añadir un gerente")

    })
    public String addGerente(@RequestBody GerenteCursos gerente){
        return gerenteCursosService.addGerente(gerente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "eliminar gerente por id", description = "elimina a un gerente por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gerente eliminado"),
            @ApiResponse(responseCode = "400", description = "error al eliminar el gerente")

    })
    public String deleteGerenteById(@PathVariable int id){
        return gerenteCursosService.deleteGerente(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar gerente", description = "Actualiza a los gerentes del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gerente actualizado"),
            @ApiResponse(responseCode = "400", description = "error al actualizar el gerente")

    })
    public String updateGerente(@PathVariable int id,@RequestBody GerenteCursos gerente){
        return  gerenteCursosService.updateGerente(id,gerente);
    }

}
