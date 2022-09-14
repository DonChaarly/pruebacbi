
package com.prueba.demo.models.dao;

import com.prueba.demo.models.entitys.Personas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPersonasDao extends JpaRepository<Personas, Long> {
    
}
