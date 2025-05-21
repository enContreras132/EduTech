package com.duoc.EduTech.Controller;

import com.duoc.EduTech.Model.ClienteAlumno;
import com.duoc.EduTech.Service.ClienteAlumnoService;
import com.duoc.EduTech.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteAlumnoController {

    @Autowired
    ClienteAlumnoService clienteAlumnoService;

    @GetMapping
    public String getAllClientes(){
        return clienteAlumnoService.getAllClientes();
    }

    @GetMapping("/{id}")
    public String getClienteById(@PathVariable int id){
        return clienteAlumnoService.getClienteById(id);
    }

    @PostMapping
    public String addCliente(@RequestBody ClienteAlumno clienteAlumno){
        return clienteAlumnoService.addCliente(clienteAlumno);
    }

    @DeleteMapping("/{id}")
    public String deleteClienteById(@PathVariable int id){
        return clienteAlumnoService.deleteCliente(id);
    }

    @PutMapping("/{id}")
    public String updateCliente(@PathVariable int id,@RequestBody ClienteAlumno clienteAlumno){
        return  clienteAlumnoService.updateCliente(id,clienteAlumno);
    }

}