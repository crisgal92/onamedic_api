package com.onamedic.onamedic.Controller;

import com.onamedic.onamedic.entity.Cliente;
import com.onamedic.onamedic.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Expone los end point y ayuda con los api rest json
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/clientes")

public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //Agrega informacion
    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
           /*Forma de poner en el postman con json para hacer las pruebas de la funcion
        {
            no es necesario poner el id y que lo tenemos como llave primaria
            "nombre":"nombre cliente",
                "correo":"correo cliente",
                "descripcion": "mensaje "
       }*/
    }
    //Muestra toda la informacion de la base de datos
    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }
    //Muestra la informacion de la base de datos por el id del cliente
    @GetMapping("/{id}")
    public Cliente findById(@PathVariable int id) {
        return clienteService.findById(id);
    }
    //Elimina cliente por id
    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable int id) {
        clienteService.deleteByID(id);
    }
    //Actualiza al cliente po rID
    @PutMapping("/{id}")
    public Cliente update(@RequestBody Cliente cliente) {
        Cliente clienteDb = clienteService.findById(cliente.getId());
        clienteDb.setNombre(cliente.getNombre());
        clienteDb.setCorreo(cliente.getCorreo());
        clienteDb.setDescripcion(cliente.getDescripcion());
        return clienteService.update( clienteDb );


    /*Forma de poner en el postman con json para hacer las pruebas de la funcion
        {
            "id":"idcliente"
            "nombre":"nombre cliente",
                "correo":"correo cliente",
                "descripcion": "mensaje "
       }*/
    }
}
