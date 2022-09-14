
package com.prueba.demo.models.dao;

import com.prueba.demo.models.entitys.Roles;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRolesDao extends JpaRepository<Roles, Long> {
    
}
