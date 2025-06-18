package com.duoc.EduTech.Controller;


import com.duoc.EduTech.Model.Instructor;
import com.duoc.EduTech.Service.CursoService;
import com.duoc.EduTech.Service.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructor")
@Tag(name ="Instructor", description = "Instructores del sistema")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @GetMapping
    @Operation(summary = "obtener todos los instructores del sistema", description = "una lista con los datos de los instructores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "se muestra la lista de instructores")
    })
    public String getAllInstructor(){
        return instructorService.getAllInstructor();
    }

    @GetMapping("/{id}")
    @Operation(summary = "obtener instructor por id", description = "una lista con los datos del instructor que tiene ese id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Instructor por id")
    })
    public String getInstructorById(@PathVariable int id){
        return instructorService.getInstructorById(id);
    }

    @PostMapping
    @Operation(summary = "añadir instructor ", description = "Añade instructor al sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Instructor añadido")
    })
    public String addInstructor(@RequestBody Instructor instructor){
        return instructorService.addInstructor(instructor);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "eliminar usuarios del sistema", description = "Elimina usuarios del sistema ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario elimiando")
    })
    public String deleteInstructorById(@PathVariable int id){
        return instructorService.deleteInstructor(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza usuarios del sistema", description = "Actualiza a los usuarios del sistema por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "usuario actualizado")
    })
    public String updateInstructor(@PathVariable int id,@RequestBody Instructor instructor){
        return  instructorService.updateInstructor(id,instructor);
    }

}
