package com.Tienda_3Q_L.controller;

import com.Tienda_3Q_L.domain.Cliente;
import com.Tienda_3Q_L.service.ClienteService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    /* se deja / solo para que sse ponga local host lo mapee de una vez */
    public String inicio(Model model) {
        //var mensaje = "Estamos en semana 4 saludos!";
        log.info("Ahora se usa arquitectura MVC");
        //model.addAttribute("mensaje", mensaje); 
        Cliente cliente = new Cliente("Jonathan", "Brenes Blanco", "jbrenes@", "8820-2655");
        //Cliente cliente2 = new Cliente("Alex", "Lopez Oreamuno", "alopez@", "8480-0841");

        // var clientes = Arrays.asList();
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "index";

    }

    @GetMapping("/nuevoCliente")/*Esto reponde al Index*/
    public String nuevoCliente(Cliente cliente) {
        return "ModificarCliente";
    }

    @PostMapping /*Reponde a esta ruta*/("/guardarCliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/";/*Redirecciona a un recurso, no devuelve una vista, devuelve una accion que hace la magia*/

    }
    
@GetMapping("/modificarCliente/{idCliente}")
public String modificarCliente(Cliente cliente, Model model){
cliente = clienteService.getCliente(cliente);
model.addAttribute("cliente", cliente);
return "modificarCliente";
}
@GetMapping("/eliminarCliente/{idCliente}")
public String eliminarCliente(Cliente cliente){
clienteService.delete(cliente);
return "redirect:/";
}
}
