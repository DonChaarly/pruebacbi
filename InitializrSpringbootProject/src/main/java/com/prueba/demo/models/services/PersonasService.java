package com.prueba.demo.models.services;

import com.prueba.demo.models.dao.IPersonasDao;
import com.prueba.demo.models.entitys.Personas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonasService implements IPersonasService{
    
    @Autowired
    private IPersonasDao personasDao;
    
    

    @Override
    @Transactional(readOnly = true)
    public List<Personas> findAll() {
        return personasDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Personas findById(Long id) {
        return personasDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Personas save(Personas persona) {
        return personasDao.save(persona);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        personasDao.deleteById(id);
    }
    
}
