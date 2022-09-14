
package com.prueba.demo.models.dao;

import com.prueba.demo.models.entitys.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsuariosDao extends JpaRepository<Usuarios, Long> {
    
    public Usuarios findByUsername(String username);
    
}
