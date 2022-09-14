
package com.prueba.demo.models.services;

import com.prueba.demo.models.entitys.Roles;
import java.util.List;


public interface IRolesService {
    
    public List<Roles> findAll();
    public Roles findById(Long id);
    public Roles save(Roles rol);
    public void delete(Long id);
    
}
