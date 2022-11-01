package com.Tienda_3Q_L.controller;

import com.Tienda_3Q_L.domain.Articulo;
import com.Tienda_3Q_L.service.ArticuloService;
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
    private ArticuloService articuloService;

    @GetMapping("/")
    /* se deja / solo para que sse ponga local host lo mapee de una vez */
    public String inicio(Model model) {
 
        log.info("Ahora se usa arquitectura MVC");
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        return "index";

    }


}
