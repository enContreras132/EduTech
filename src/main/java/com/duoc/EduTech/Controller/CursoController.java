package com.duoc.EduTech.Controller;


import com.duoc.EduTech.Model.Curso;
import com.duoc.EduTech.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping
    public String getAllUsers(){
        return cursoService.getAllUsers();
    }

    @GetMapping("/{id}")
    public String getCursoById(@PathVariable int id){
        return cursoService.getCursoById(id);
    }

//    @PostMapping
//    public String addCurso(@RequestBody Curso curso){
//        return cursoService.addCurso(Curso);
//    }

    @DeleteMapping("/{id}")
    public String deleteCursoById(@PathVariable int id){
        return cursoService.deleteCurso(id);
    }

    @PutMapping("/{id}")
    public String updateCurso(@PathVariable int id,@RequestBody Curso curso){
        return  cursoService.updateCurso(id,curso);
    }

}