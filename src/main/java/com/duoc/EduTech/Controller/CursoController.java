package com.duoc.EduTech.Controller;


import com.duoc.EduTech.Model.Curso;
import com.duoc.EduTech.Service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
@Tag(name ="Cursos", description = "Cursos del sistema")

public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping
    @Operation(summary = "obtener todos los cursos del sistema", description = "una lista con los datos de los cursos exitentes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "se muestra la lista de cursos")
    })
    public String getAllCursos(){
        return cursoService.getAllCursos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "obtener curso por id", description = "obtiene el curso que tiene ese id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "se muestra la lista de los cursos que tienen ese id")
    })
    public String getCursoById(@PathVariable int id){
        return cursoService.getCursoById(id);
    }

    @PostMapping
    @Operation(summary = "Añadir un curso", description = "Añade cursos al sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "curso añadido con exito")
    })
    public String addCurso(@RequestBody Curso curso){
        return cursoService.addCurso(curso);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cursos", description = "Elimina cursos del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "curso eliminado con exito")
    })
    public String deleteCursoById(@PathVariable int id){
        return cursoService.deleteCurso(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar curso", description = "Actualiza los cursos del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso actualizado con exito")
    })
    public String updateCurso(@PathVariable int id,@RequestBody Curso curso){
        return  cursoService.updateCurso(id,curso);
    }

}