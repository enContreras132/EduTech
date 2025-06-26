package com.duoc.EduTech.Assemblers;


import com.duoc.EduTech.Controller.ClienteAlumnoController;
import com.duoc.EduTech.Model.ClienteAlumno;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ClienteAssembler implements RepresentationModelAssembler<ClienteAlumno,EntityModel<ClienteAlumno>> {

    @Override
    public EntityModel<ClienteAlumno> toModel(ClienteAlumno clienteAlumno) {
        return EntityModel.of(clienteAlumno,
                linkTo(methodOn(ClienteAlumnoController.class).getClienteById(clienteAlumno.getId_alumno())).withSelfRel(),
                linkTo(methodOn(ClienteAlumnoController.class).updateCliente(clienteAlumno.getId_alumno(), clienteAlumno)).withRel("Put"),
                linkTo(methodOn(ClienteAlumnoController.class).deleteClienteById(clienteAlumno.getId_alumno())).withRel("DELETE"),
                linkTo(methodOn(ClienteAlumnoController.class).getAllClientes()).withRel("Get All")
        );
    }
}
