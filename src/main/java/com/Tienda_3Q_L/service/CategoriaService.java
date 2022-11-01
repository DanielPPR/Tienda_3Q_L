
package com.Tienda_3Q_L.service;

import com.Tienda_3Q_L.domain.Categoria;
import java.util.List;

public interface CategoriaService {
       public List<Categoria> getCategorias(boolean activos); 
    
   public Categoria getCategoria(Categoria categoria);
   
   public void save(Categoria categoria); /*Crea o mnodifica*/
   public void delete(Categoria categoria); /*Elimina registros*/
}
