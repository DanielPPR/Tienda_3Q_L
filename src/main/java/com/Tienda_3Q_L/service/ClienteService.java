
package com.Tienda_3Q_L.service;

import com.Tienda_3Q_L.domain.Cliente;
import java.util.List;




/*define cuales son los metodos para ser utilizados, qie tipo de datos, como se llama el
metodo y si recibe parametros o no */

public interface ClienteService { /*Esto literal es como un puente entre el controlador y
    ClienteServiceImpl*/
    
   public List<Cliente> getClientes(); 
    
   public Cliente getCliente(Cliente cliente);
   
   public void save(Cliente cliente); /*Crea o mnodifica*/
   public void delete(Cliente cliente); /*Elimina registros*/
   
   
}
