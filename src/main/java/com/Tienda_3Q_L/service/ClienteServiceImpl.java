package com.Tienda_3Q_L.service;

import com.Tienda_3Q_L.dao.ClienteDao;
import com.Tienda_3Q_L.dao.CreditoDao;
import com.Tienda_3Q_L.domain.Cliente;
import com.Tienda_3Q_L.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Esto es como un contrato, si o si se tiene que definir los metodos
 */

/*------------------------------------*/
@Service
/*Esto tiene que estar si o si para que la clase tenga la logica de la interfaz*/
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;
    /*Esto se copio del controlador*/

    @Autowired
    private CreditoDao creditoDao;

    @Override
    @Transactional(readOnly = true)
    /*Se importa la que es de Spring*/
    public List<Cliente> getClientes() {
        /* var clientes = (List<Cliente>)clienteDao.findAll();
        return clientes;*/ /*Esta es otra forma de hacerlo */

        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    /*Se importa la que es de Spring*/
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {

        Credito credito = cliente.getCredito(); //id = 2, limite 1 000 000 
        credito = creditoDao.save(credito);
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

}
