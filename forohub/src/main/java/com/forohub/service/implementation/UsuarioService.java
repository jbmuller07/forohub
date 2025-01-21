package com.forohub.service.implementation;

import com.forohub.DTO.UsuarioDTO.RegistrarUsuarioDTO;
import com.forohub.persistence.model.Usuario;
import com.forohub.persistence.repository.UsuarioRepository;
import com.forohub.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder() ;

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);

    }

    @Override
    public void update(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario cambiarRegistroUsuarioDTO(RegistrarUsuarioDTO usuarioDTO) {
        String contraseniaEncriptada = bCryptPasswordEncoder.encode(usuarioDTO.contrasenia());
        return new Usuario(null, usuarioDTO.nombre(),
                usuarioDTO.correoElectronico(),
                contraseniaEncriptada);
    }

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> opcionalUsuario = usuarioRepository.findById(id);
        if (opcionalUsuario.isPresent()) {
            return opcionalUsuario.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
    }

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

//    @Override
//    public Usuario findByCorreoElectronico(String correoElectronico) {
//        Optional<Usuario> opcionalUsuario = usuarioRepository.findByCorreoElectronico(correoElectronico);
//        if (opcionalUsuario.isPresent()) {
//            return opcionalUsuario.get();
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado");
//    }
}
