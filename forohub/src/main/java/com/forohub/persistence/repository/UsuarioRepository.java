package com.forohub.persistence.repository;

import com.forohub.persistence.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    UserDetails findByCorreoElectronico(String correoElectronico);
}
