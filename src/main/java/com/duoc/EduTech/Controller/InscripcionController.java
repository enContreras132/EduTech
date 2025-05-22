package com.duoc.EduTech.Controller;


import com.duoc.EduTech.Model.Inscripcion;
import com.duoc.EduTech.Service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {

    @Autowired
    InscripcionService inscripcionService;

    @GetMapping
    public String getAllInscripcion(){
        return inscripcionService.getAllInscripcion();
    }

    @GetMapping("/{id}")
    public String getInscripcionById(@PathVariable int id){
        return inscripcionService.getInscripcionById(id);
    }

    @PostMapping
    public String addInscripcion(@RequestBody Inscripcion inscripcion){
        return inscripcionService.addInscripcion(inscripcion);
    }

    @DeleteMapping("/{id}")
    public String deleteInscripcionById(@PathVariable int id){
        return inscripcionService.deleteInscripcion(id);
    }

    @PutMapping("/{id}")
    public String updateInscripcion(@PathVariable int id,@RequestBody Inscripcion inscripcion){
        return inscripcionService.updateIncripcion(id,inscripcion);
    }
}
