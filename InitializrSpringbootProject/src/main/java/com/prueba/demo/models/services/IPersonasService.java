
package com.prueba.demo.models.services;

import com.prueba.demo.models.entitys.Personas;
import java.util.List;


public interface IPersonasService {
    
    public List<Personas> findAll();
    public Personas findById(Long id);
    public Personas save(Personas persona);
    public void delete(Long id);
    
}
