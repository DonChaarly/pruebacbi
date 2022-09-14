package com.prueba.demo.models.services;

import com.prueba.demo.models.dao.IUsuariosDao;
import com.prueba.demo.models.entitys.Usuarios;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuariosService implements IUsuariosService{
    private Logger logger = LoggerFactory.getLogger(UsuariosService.class);
    @Autowired
    private IUsuariosDao usuariosDao;
    
    

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> findAll() {
        return usuariosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios findById(Long id) {
        return usuariosDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Usuarios save(Usuarios usuario) {
        return usuariosDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuariosDao.deleteById(id);
    }
    

    @Override
    @Transactional(readOnly = true)
    public Usuarios findByUsername(String username) {
        return usuariosDao.findByUsername(username);
    }
    
}
