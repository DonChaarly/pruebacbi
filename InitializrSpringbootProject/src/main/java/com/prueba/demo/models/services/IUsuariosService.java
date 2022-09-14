
package com.prueba.demo.models.services;

import com.prueba.demo.models.entitys.Usuarios;
import java.util.List;


public interface IUsuariosService {
    
    public List<Usuarios> findAll();
    public Usuarios findById(Long id);
    public Usuarios save(Usuarios usuario);
    public void delete(Long id);
    public Usuarios findByUsername(String username);
}
