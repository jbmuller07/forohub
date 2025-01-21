package com.forohub.service.interfaces;

import com.forohub.DTO.UsuarioDTO.RegistrarUsuarioDTO;
import com.forohub.persistence.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    void save(Usuario usuario);
    void update(Usuario usuario);
    Usuario cambiarRegistroUsuarioDTO(RegistrarUsuarioDTO usuarioDTO);
    Usuario findById(Long id);
    List<Usuario> findAll();
//    Usuario findByCorreoElectronico(String correoElectronico);
}
