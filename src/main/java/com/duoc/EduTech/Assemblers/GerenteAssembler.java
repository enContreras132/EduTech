package com.duoc.EduTech.Assemblers;

import com.duoc.EduTech.Controller.GerenteController;
import com.duoc.EduTech.Model.GerenteCursos;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class GerenteAssembler implements RepresentationModelAssembler<GerenteCursos,EntityModel<GerenteCursos>> {

    @Override
    public EntityModel<GerenteCursos> toModel(GerenteCursos gerenteCursos) {
        return EntityModel.of(gerenteCursos,
                linkTo(methodOn(GerenteController.class).getGerenteById(gerenteCursos.getId())).withSelfRel(),
                linkTo(methodOn(GerenteController.class).updateGerente(gerenteCursos.getId(), gerenteCursos)).withRel("Put"),
                linkTo(methodOn(GerenteController.class).deleteGerenteById(gerenteCursos.getId())).withRel("DELETE"),
                linkTo(methodOn(GerenteController.class).getAllGerente()).withRel("Get All")
        );
    }
}
