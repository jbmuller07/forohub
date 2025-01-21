package com.forohub.service.interfaces;

import com.forohub.DTO.topicoDTO.RegistrarTopicoDTO;
import com.forohub.persistence.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITopicoService {

    void save(Topico topico);
    List<Topico> findAll();
    Page<Topico> findByEstadoTrue(Pageable pageable);
    Topico findById(Long id);
    void cambiarEstado(Long id);
    void update(Topico topico);
    Topico cambiarRegistroTopicoDTO(RegistrarTopicoDTO registrarTopicoDTO);
    Topico cambiarRegistroActualizarTopicoDTO(Long id, RegistrarTopicoDTO registrarTopicoDTO);
    boolean estaPresente(Long id);
}
