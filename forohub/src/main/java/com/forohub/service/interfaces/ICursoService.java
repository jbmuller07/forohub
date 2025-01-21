package com.forohub.service.interfaces;

import com.forohub.DTO.cursoDTO.DetalleCursoDTO;
import com.forohub.DTO.cursoDTO.RegistrarCursoDTO;
import com.forohub.persistence.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICursoService {

    void save(Curso curso);
    Curso findById(Long id);
    List<Curso> findAll();
    Page<Curso> findByEstadoTrue(Pageable pageable);
    void cambiarEstado(Long id);
    void update(Curso curso);
    Curso cambiarRegistroDTO(RegistrarCursoDTO cursoDTO);

    Curso cambiarDetalleDTO(DetalleCursoDTO detalleCursoDTO);
}
