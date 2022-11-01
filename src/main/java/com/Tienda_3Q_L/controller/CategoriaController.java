/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_3Q_L.controller;

import com.Tienda_3Q_L.domain.Categoria;
import com.Tienda_3Q_L.service.CategoriaService;
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
public class CategoriaController {
    
     @Autowired
     private CategoriaService categoriaService;
     
    @GetMapping("/categoria/listado")
    public String inicio(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/categoria/listado";
    }
    
    
    
        @GetMapping("/categoria/nuevo")/*Esto reponde al Index*/
    public String nuevoCategoria(Categoria categoria) {
        return "/categoria/modificar";
    }

    @PostMapping /*Reponde a esta ruta*/("/guardarCategoria")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";/*Redirecciona a un recurso, no devuelve una vista, devuelve una accion que hace la magia*/

    }
    
@GetMapping("/modificarCategoria/{idCategoria}")
public String modificarCategoria(Categoria categoria, Model model){
categoria = categoriaService.getCategoria(categoria);
model.addAttribute("categoria", categoria);
return "redirect:/categoria/listado";
}
@GetMapping("/eliminarCategoria/{idCategoria}")
public String eliminarCategoria(Categoria categoria){
categoriaService.delete(categoria);
return "redirect:/categoria/listado";
}
    
}
