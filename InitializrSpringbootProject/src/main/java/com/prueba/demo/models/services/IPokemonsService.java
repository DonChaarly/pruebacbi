
package com.prueba.demo.models.services;

import com.prueba.demo.models.entitys.Pokemons;
import java.util.List;


public interface IPokemonsService {
    
    public List<Pokemons> findAll();
    public Pokemons findById(Long id);
    public Pokemons save(Pokemons pokemon);
    public void delete(Long id);
    
}
