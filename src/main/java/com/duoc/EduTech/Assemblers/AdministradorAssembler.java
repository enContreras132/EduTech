package com.duoc.EduTech.Assemblers;

import com.duoc.EduTech.Controller.AdministradorController;
import com.duoc.EduTech.Model.Administrador;
import com.duoc.EduTech.Model.Curso;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class AdministradorAssembler implements RepresentationModelAssembler<Administrador,EntityModel<Administrador>> {

    @Override
    public EntityModel<Administrador> toModel(Administrador admin) {
        return EntityModel.of(admin,
                linkTo(methodOn(AdministradorController.class).getAdministradorById(admin.getId_admin())).withSelfRel(),
                linkTo(methodOn(AdministradorController.class).updateAdministrador(admin.getId_admin(), admin)).withRel("Put"),
                linkTo(methodOn(AdministradorController.class).deleteAdminstradorById(admin.getId_admin())).withRel("DELETE"),
                linkTo(methodOn(AdministradorController.class).getAllAdministrador()).withRel("Get All")
        );
    }
}