package com.prueba.demo.controllers;

import com.prueba.demo.models.entitys.Personas;
import com.prueba.demo.models.entitys.Pokemons;
import com.prueba.demo.models.entitys.Roles;
import com.prueba.demo.models.entitys.Usuarios;
import com.prueba.demo.models.services.IPersonasService;
import com.prueba.demo.models.services.IPokemonsService;
import com.prueba.demo.models.services.IRolesService;
import com.prueba.demo.models.services.IUsuariosService;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuariosController {
    
    @Autowired
    private IPersonasService personasService;
    @Autowired
    private IUsuariosService usuariosService;
    @Autowired
    private IRolesService rolesService;
    @Autowired
    private IPokemonsService pokemonsService;
    
    ///////////////////////////     PERSONAS        //////////////////////////////////////////////////
    
    @GetMapping("/personas/list")
    public ResponseEntity<?> listarPersonas(){
        Map<String, Object> response = new HashMap<>();
        List<Personas> personas = null;
        
        try {
            personas = personasService.findAll();
        } catch (Exception e) {
            response.put("message", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(personas == null){
            response.put("message", "No se encontraron registros en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<List<Personas>>(personas, HttpStatus.OK);
    }
    
    @GetMapping("/persona/{id}")
    public ResponseEntity<?> findPersonaById(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Personas persona = null;
        
        try {
            persona = personasService.findById(id);
        } catch (Exception e) {
            response.put("message", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(persona == null){
            response.put("message", "No se encontraron registros en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Personas>(persona, HttpStatus.OK);
    }
    
    @PostMapping("/persona/create")
    public ResponseEntity<?> createPersona(@RequestBody Personas persona){
        Map<String, Object> response = new HashMap<>();
        Personas personaNueva = null;
        
        
        try {
            persona = personasService.save(persona);
        } catch (Exception e) {
            response.put("message", "Error al realizar la insercion en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            
        
        return new ResponseEntity<Personas>(persona, HttpStatus.OK);
    }
    
    @PutMapping("/persona/{id}")
    public ResponseEntity<?> updatePersona(@RequestBody Personas persona, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Personas personaActual = null;
        Personas personaUpdate = null;
        
        try {
            personaActual = personasService.findById(id);
            
            personaActual.setNombres(persona.getNombres());
            personaActual.setAppellidos(persona.getAppellidos());
            personaActual.setTelefono(persona.getTelefono());
            personaActual.setUsuario(persona.getUsuario());
            
            personaUpdate = personasService.save(personaActual);
            
        } catch (Exception e) {
            response.put("message", "Error al realizar la incercion en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(personaUpdate == null){
            response.put("message", "No se encontraron registros en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Personas>(personaUpdate, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/persona/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        
        
        try {
            if(id != 1){
                personasService.delete(id);
            }
        } catch (Exception e) {
            response.put("message", "Error al realizar la eliminacion en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            
        response.put("message", "Se elimino la persona con id: " + id);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    
    ///////////////////////////     USUARIOS        //////////////////////////////////////////////////
    
    @GetMapping("/usuarios/list")
    public ResponseEntity<?> listarUsuarios(){
        Map<String, Object> response = new HashMap<>();
        List<Usuarios> usuarios = null;
        
        try {
            usuarios = usuariosService.findAll();
        } catch (Exception e) {
            response.put("message", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(usuarios == null){
            response.put("message", "No se encontraron registros en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<List<Usuarios>>(usuarios, HttpStatus.OK);
    }
    
    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> findUsuarioById(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Usuarios usuario = null;
        
        try {
            usuario = usuariosService.findById(id);
        } catch (Exception e) {
            response.put("message", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(usuario == null){
            response.put("message", "No se encontraron registros en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Usuarios>(usuario, HttpStatus.OK);
    }
    
    @GetMapping("/usuario/{username}")
    public ResponseEntity<?> findUsuarioByUsername(@PathVariable String username){
        Map<String, Object> response = new HashMap<>();
        Usuarios usuario = null;
        
        try {
            usuario = usuariosService.findByUsername(username);
        } catch (Exception e) {
            response.put("message", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(usuario == null){
            response.put("message", "No se encontraron registros en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Usuarios>(usuario, HttpStatus.OK);
    }
    
    @PostMapping("/usuario/create")
    public ResponseEntity<?> createUsuario(@RequestBody Usuarios usuario){
        Map<String, Object> response = new HashMap<>();
        Usuarios usuarioNueva = null;
        
        try {
            usuario = usuariosService.save(usuario);
        } catch (Exception e) {
            response.put("message", "Error al realizar la insercion en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            
        
        return new ResponseEntity<Usuarios>(usuario, HttpStatus.OK);
    }
    
    @PutMapping("/usuario/{id}/")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuarios usuario, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Usuarios usuarioActual = null;
        Usuarios usuarioUpdate = null;
        
        try {
            usuarioActual = usuariosService.findById(id);
            
            usuarioActual.setUsername(usuario.getUsername());
            usuarioActual.setPassword(usuario.getPassword());
            usuarioActual.setRol(usuario.getRol());
            usuarioActual.setEnabled(usuario.getEnabled());

            
            usuarioUpdate = usuariosService.save(usuarioActual);
            
        } catch (Exception e) {
            response.put("message", "Error al realizar la incercion en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(usuarioUpdate == null){
            response.put("message", "No se encontraron registros en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Usuarios>(usuarioUpdate, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        
        
        try {
            if(id != 1){
               usuariosService.delete(id); 
            }
        } catch (Exception e) {
            response.put("message", "Error al realizar la eliminacion en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            
        response.put("message", "Se elimino la usuario con id: " + id);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    
    
    ///////////////////////////     Roles        //////////////////////////////////////////////////
    
    @GetMapping("/roles/list")
    public ResponseEntity<?> listarRoles(){
        Map<String, Object> response = new HashMap<>();
        List<Roles> roles = null;
        
        try {
            roles = rolesService.findAll();
        } catch (Exception e) {
            response.put("message", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(roles == null){
            response.put("message", "No se encontraron registros en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<List<Roles>>(roles, HttpStatus.OK);
    }
    
    @GetMapping("/rol/{id}")
    public ResponseEntity<?> findRolById(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Roles rol = null;
        
        try {
            rol = rolesService.findById(id);
        } catch (Exception e) {
            response.put("message", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(rol == null){
            response.put("message", "No se encontraron registros en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Roles>(rol, HttpStatus.OK);
    }
    
    @PostMapping("/rol/create")
    public ResponseEntity<?> createRol(@RequestBody Roles rol){
        Map<String, Object> response = new HashMap<>();
        Roles rolNueva = null;
        
        
        try {
            rol = rolesService.save(rol);
        } catch (Exception e) {
            response.put("message", "Error al realizar la insercion en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            
        
        return new ResponseEntity<Roles>(rol, HttpStatus.OK);
    }
    
    @PutMapping("/rol/{id}")
    public ResponseEntity<?> updateRol(@RequestBody Roles rol, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Roles rolActual = null;
        Roles rolUpdate = null;
        
        try {
            rolActual = rolesService.findById(id);
            
            rolActual.setNombre(rol.getNombre());
            rolActual.setBuscaOaxaca(rol.getBuscaOaxaca());
            rolActual.setDiaSemana(rol.getDiaSemana());
            rolActual.setEditarPokemon(rol.getEditarPokemon());
            rolActual.setEliminarPokemon(rol.getEliminarPokemon());
            rolActual.setSolicitarPokemon(rol.getSolicitarPokemon());
            rolActual.setVerPokemon(rol.getVerPokemon());
            
            
            rolUpdate = rolesService.save(rolActual);
            
        } catch (Exception e) {
            response.put("message", "Error al realizar la incercion en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(rolUpdate == null){
            response.put("message", "No se encontraron registros en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Roles>(rolUpdate, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/rol/{id}")
    public ResponseEntity<?> deleteRol(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        
        
        try {
            if(id != 1){
                rolesService.delete(id);
            }
        } catch (Exception e) {
            response.put("message", "Error al realizar la eliminacion en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            
        response.put("message", "Se elimino la rol con id: " + id);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    
    ///////////////////////////     POKEMONS        //////////////////////////////////////////////////
    
    @GetMapping("/pokemons/list")
    public ResponseEntity<?> listarPokemons(){
        Map<String, Object> response = new HashMap<>();
        List<Pokemons> pokemons = null;
        
        try {
            pokemons = pokemonsService.findAll();
        } catch (Exception e) {
            response.put("message", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(pokemons == null){
            response.put("message", "No se encontraron registros en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<List<Pokemons>>(pokemons, HttpStatus.OK);
    }
    
    @GetMapping("/pokemon/{id}")
    public ResponseEntity<?> findPokemonById(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Pokemons pokemon = null;
        
        try {
            pokemon = pokemonsService.findById(id);
        } catch (Exception e) {
            response.put("message", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(pokemon == null){
            response.put("message", "No se encontraron registros en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Pokemons>(pokemon, HttpStatus.OK);
    }
    
    @PostMapping("/pokemon/create")
    public ResponseEntity<?> createPokemon(@RequestBody Pokemons pokemon){
        Map<String, Object> response = new HashMap<>();
        Pokemons pokemonNueva = null;
        
        
        try {
            pokemon = pokemonsService.save(pokemon);
        } catch (Exception e) {
            response.put("message", "Error al realizar la insercion en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            
        
        return new ResponseEntity<Pokemons>(pokemon, HttpStatus.OK);
    }
    
    @PutMapping("/pokemon/{id}")
    public ResponseEntity<?> updatePokemon(@RequestBody Pokemons pokemon, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Pokemons pokemonActual = null;
        Pokemons pokemonUpdate = null;
        
        try {
            pokemonActual = pokemonsService.findById(id);
            
            pokemonActual.setNombre(pokemon.getNombre());
            
            
            pokemonUpdate = pokemonsService.save(pokemonActual);
            
        } catch (Exception e) {
            response.put("message", "Error al realizar la incercion en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(pokemonUpdate == null){
            response.put("message", "No se encontraron registros en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Pokemons>(pokemonUpdate, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<?> deletePokemon(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        
        
        try {
            pokemonsService.delete(id);
        } catch (Exception e) {
            response.put("message", "Error al realizar la eliminacion en la base de datos");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            
        response.put("message", "Se elimino la pokemon con id: " + id);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    
    
}
