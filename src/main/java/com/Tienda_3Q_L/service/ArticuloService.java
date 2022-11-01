package com.Tienda_3Q_L.service;

import com.Tienda_3Q_L.domain.Articulo;
import java.util.List;

/*define cuales son los metodos para ser utilizados, qie tipo de datos, como se llama el
metodo y si recibe parametros o no */
public interface ArticuloService {

    /*Esto literal es como un puente entre el controlador y
    ArticuloServiceImpl*/

    public List<Articulo> getArticulos(boolean activos);

    public Articulo getArticulo(Articulo articulo);

    public void save(Articulo articulo);

    /*Crea o mnodifica*/
    public void delete(Articulo articulo);
    /*Elimina registros*/


}
