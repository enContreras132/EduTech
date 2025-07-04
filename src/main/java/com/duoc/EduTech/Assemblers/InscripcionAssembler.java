package com.duoc.EduTech.Assemblers;


import com.duoc.EduTech.Controller.InscripcionController;
import com.duoc.EduTech.Model.Inscripcion;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class InscripcionAssembler implements RepresentationModelAssembler<Inscripcion,EntityModel<Inscripcion>> {

    @Override
    public EntityModel<Inscripcion> toModel(Inscripcion inscripcion) {
        return EntityModel.of(inscripcion,
                linkTo(methodOn(InscripcionController.class).getInscripcionById(inscripcion.getId_inscripcion())).withSelfRel(),
                linkTo(methodOn(InscripcionController.class).updateInscripcion(inscripcion.getId_inscripcion(), inscripcion)).withRel("Put"),
                linkTo(methodOn(InscripcionController.class).deleteInscripcionById(inscripcion.getId_inscripcion())).withRel("DELETE"),
                linkTo(methodOn(InscripcionController.class).getAllInscripcion()).withRel("Get All")
        );
    }
}

