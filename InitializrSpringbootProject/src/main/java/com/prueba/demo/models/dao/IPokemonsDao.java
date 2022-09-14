
package com.prueba.demo.models.dao;

import com.prueba.demo.models.entitys.Pokemons;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPokemonsDao extends JpaRepository<Pokemons, Long> {
    
}
