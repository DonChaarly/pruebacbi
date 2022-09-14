package com.prueba.demo.models.services;


import com.prueba.demo.models.dao.IPokemonsDao;

import com.prueba.demo.models.entitys.Pokemons;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PokemonsService implements IPokemonsService{
    
    @Autowired
    private IPokemonsDao pokemonsDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pokemons> findAll() {
        return pokemonsDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pokemons findById(Long id) {
        return pokemonsDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Pokemons save(Pokemons pokemon) {
        return pokemonsDao.save(pokemon);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pokemonsDao.deleteById(id);
    }
    
    

    
    
}
