package com.duoc.EduTech.Assemblers;
import com.duoc.EduTech.Controller.CursoController;
import com.duoc.EduTech.Model.Curso;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CursoModelAssembler implements RepresentationModelAssembler<Curso,EntityModel<Curso>> {

    @Override
    public EntityModel<Curso> toModel(Curso curso){
        return EntityModel.of(curso,
                linkTo(methodOn(CursoController.class).getCursoById(curso.getId())).withSelfRel(),
                linkTo(methodOn(CursoController.class).updateCurso(curso.getId(),curso)).withRel("Put"),
                linkTo(methodOn(CursoController.class).deleteCursoById(curso.getId())).withRel("DELETE"),
                linkTo(methodOn(CursoController.class).getAllCursos()).withRel("Get")
        );
    }

}
