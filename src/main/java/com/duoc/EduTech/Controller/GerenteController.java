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
            @ApiResponse(responseCode = "200", description = "se muestra la lista de gerentes")
    })
    public String getAllGerente(){
        return gerenteCursosService.getAllGerente();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener gerente por id", description = "Muestra al gerente que tiene ese id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gerente mostrado ")
    })
    public String getGerenteById(@PathVariable int id){
        return gerenteCursosService.getGerenteById(id);
    }

    @PostMapping
    @Operation(summary = "Añadir gerente", description = "añade gerentes al sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gerente añadido con exito")
    })
    public String addGerente(@RequestBody GerenteCursos gerente){
        return gerenteCursosService.addGerente(gerente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "eliminar gerente por id", description = "elimina a un gerente por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gerente eliminado")
    })
    public String deleteGerenteById(@PathVariable int id){
        return gerenteCursosService.deleteGerente(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar gerente", description = "Actualiza a los gerentes del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gerente actualizado")
    })
    public String updateGerente(@PathVariable int id,@RequestBody GerenteCursos gerente){
        return  gerenteCursosService.updateGerente(id,gerente);
    }

}
