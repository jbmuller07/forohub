package com.forohub.service.implementation;

import com.forohub.DTO.topicoDTO.RegistrarTopicoDTO;
import com.forohub.persistence.model.Curso;
import com.forohub.persistence.model.Topico;
import com.forohub.persistence.model.Usuario;
import com.forohub.persistence.repository.TopicoRepository;
import com.forohub.service.interfaces.ICursoService;
import com.forohub.service.interfaces.ITopicoService;
import com.forohub.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService implements ITopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private ICursoService cursoService;

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public void save(Topico topico) {
        topicoRepository.save(topico);
    }

    @Override
    public List<Topico> findAll() {
        return (List<Topico>) topicoRepository.findAll();
    }

    @Override
    public Page<Topico> findByEstadoTrue(Pageable pageable) {
        return topicoRepository.findByEstadoTrue(pageable);
    }

    @Override
    public Topico findById(Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if(topicoOptional.isPresent()){
            return topicoOptional.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Topico no encontrado");
    }


    @Override
    public void cambiarEstado(Long id) {
        Topico topico = findById(id);
        topico.setEstado(false);
    }

    @Override
    public void update(Topico topico) {
        topicoRepository.save(topico);
    }

    @Override
    public Topico cambiarRegistroTopicoDTO(RegistrarTopicoDTO registrarTopicoDTO) {
        Usuario usuario = usuarioService.findById(registrarTopicoDTO.autor());
        Curso curso = cursoService.findById(registrarTopicoDTO.curso());
        return new Topico(null, registrarTopicoDTO.titulo(), registrarTopicoDTO.mensaje(),
                LocalDateTime.now(), true, usuario, curso);
    }

    @Override
    public Topico cambiarRegistroActualizarTopicoDTO(Long id, RegistrarTopicoDTO registrarTopicoDTO) {
        Topico topico = findById(id);
        topico.setTitulo(registrarTopicoDTO.titulo());
        topico.setMensaje(registrarTopicoDTO.mensaje());
        topico.setAutor(usuarioService.findById(registrarTopicoDTO.autor()));
        topico.setCurso(cursoService.findById(registrarTopicoDTO.curso()));
        return topico;
    }

    @Override
    public boolean estaPresente(Long id) {
        return topicoRepository.existsById(id);
    }
}
