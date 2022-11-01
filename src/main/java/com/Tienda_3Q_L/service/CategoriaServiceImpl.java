package com.Tienda_3Q_L.service;

import com.Tienda_3Q_L.dao.CategoriaDao;
import com.Tienda_3Q_L.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaDao categoriaDao;

    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>)categoriaDao.findAll();

        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
       return lista;
}




    @Override
    public Categoria getCategoria(Categoria categoria) {

        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
        
    }

    @Override
    public void save(Categoria categoria) {
categoriaDao.save(categoria);
    }

    @Override
    public void delete(Categoria categoria) {
categoriaDao.delete(categoria);   
    }

}
