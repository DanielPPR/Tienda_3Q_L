/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_3Q_L.controller;

import com.Tienda_3Q_L.domain.Articulo;
import com.Tienda_3Q_L.service.ArticuloService;
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
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/articulo/listado")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        return "/articulo/listado";
    }

    @GetMapping("/articulo/nuevo")/*Esto reponde al Index*/
    public String nuevoArticulo(Articulo articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/articulo/modificar";
    }

    @PostMapping /*Reponde a esta ruta*/("/guardarArticulo")
    public String guardarArticulo(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";/*Redirecciona a un recurso, no devuelve una vista, devuelve una accion que hace la magia*/

    }

    @GetMapping("/modificarArticulo/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/eliminarArticulo/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }

}
