/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_3Q_L.controller;

import com.Tienda_3Q_L.domain.Cliente;
import com.Tienda_3Q_L.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Daniel
 */
@Controller
public class ClienteController {
    
     @Autowired
     private ClienteService clienteService;
     
    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "/cliente/listado";
    }
    
    
    
        @GetMapping("/cliente/nuevo")/*Esto reponde al Index*/
    public String nuevoCliente(Cliente cliente) {
        return "/cliente/modificar";
    }

    @PostMapping /*Reponde a esta ruta*/("/guardarCliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";/*Redirecciona a un recurso, no devuelve una vista, devuelve una accion que hace la magia*/

    }
    
@GetMapping("/modificarCliente/{idCliente}")
public String modificarCliente(Cliente cliente, Model model){
cliente = clienteService.getCliente(cliente);
model.addAttribute("cliente", cliente);
return "redirect:/cliente/listado";
}
@GetMapping("/eliminarCliente/{idCliente}")
public String eliminarCliente(Cliente cliente){
clienteService.delete(cliente);
return "redirect:/cliente/listado";
}
    
}
