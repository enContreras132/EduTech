package com.duoc.EduTech.Assemblers;


import com.duoc.EduTech.Controller.InstructorController;

import com.duoc.EduTech.Model.Instructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class InstructorAssembler implements RepresentationModelAssembler<Instructor,EntityModel<Instructor>> {

    @Override
    public EntityModel<Instructor> toModel(Instructor instructor) {
        return EntityModel.of(instructor,
                linkTo(methodOn(InstructorController.class).getInstructorById(instructor.getId())).withSelfRel(),
                linkTo(methodOn(InstructorController.class).updateInstructor(instructor.getId(), instructor)).withRel("Put"),
                linkTo(methodOn(InstructorController.class).deleteInstructorById(instructor.getId())).withRel("DELETE"),
                linkTo(methodOn(InstructorController.class).getAllInstructor()).withRel("Get All")
        );
    }
}
