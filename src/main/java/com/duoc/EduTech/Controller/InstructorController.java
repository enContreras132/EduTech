package com.duoc.EduTech.Controller;


import com.duoc.EduTech.Model.Instructor;
import com.duoc.EduTech.Service.CursoService;
import com.duoc.EduTech.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @GetMapping
    public String getAllInstructor(){
        return instructorService.getAllInstructor();
    }

    @GetMapping("/{id}")
    public String getInstructorById(@PathVariable int id){
        return instructorService.getInstructorById(id);
    }

    @PostMapping
    public String addInstructor(@RequestBody Instructor instructor){
        return instructorService.addInstructor(instructor);
    }

    @DeleteMapping("/{id}")
    public String deleteInstructorById(@PathVariable int id){
        return instructorService.deleteInstructor(id);
    }

    @PutMapping("/{id}")
    public String updateInstructor(@PathVariable int id,@RequestBody Instructor instructor){
        return  instructorService.updateInstructor(id,instructor);
    }

}
