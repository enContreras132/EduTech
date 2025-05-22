package com.duoc.EduTech.Controller;

import com.duoc.EduTech.Model.Curso;
import com.duoc.EduTech.Model.GerenteCursos;
import com.duoc.EduTech.Service.CursoService;
import com.duoc.EduTech.Service.GerenteCursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gerente")
public class GerenteController {

    @Autowired
    GerenteCursosService gerenteCursosService;

    @GetMapping
    public String getAllGerente(){
        return gerenteCursosService.getAllGerente();
    }

    @GetMapping("/{id}")
    public String getGerenteById(@PathVariable int id){
        return gerenteCursosService.getGerenteById(id);
    }

    @PostMapping
    public String addGerente(@RequestBody GerenteCursos gerente){
        return gerenteCursosService.addGerente(gerente);
    }

    @DeleteMapping("/{id}")
    public String deleteGerenteById(@PathVariable int id){
        return gerenteCursosService.deleteGerente(id);
    }

    @PutMapping("/{id}")
    public String updateGerente(@PathVariable int id,@RequestBody GerenteCursos gerente){
        return  gerenteCursosService.updateGerente(id,gerente);
    }

}
