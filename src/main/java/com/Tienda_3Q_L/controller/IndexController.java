package com.Tienda_3Q_L.controller;

import com.Tienda_3Q_L.dao.ClienteDao;
import com.Tienda_3Q_L.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private ClienteDao clienteDao;
    @GetMapping("/")
    /* se deja / solo para que sse ponga local host lo mapee de una vez */
    public String inicio(Model model) {
        //var mensaje = "Estamos en semana 4 saludos!";
        log.info("Ahora se usa arquitectura MVC");
        //model.addAttribute("mensaje", mensaje); 
        Cliente cliente = new Cliente("Jonathan", "Brenes Blanco", "jbrenes@", "8820-2655");
        //Cliente cliente2 = new Cliente("Alex", "Lopez Oreamuno", "alopez@", "8480-0841");
        
        // var clientes = Arrays.asList();
       var clientes = clienteDao.findAll();
        model.addAttribute("cliente", cliente);
        model.addAttribute("clientes",clientes); 
       return "index";
    }

}
