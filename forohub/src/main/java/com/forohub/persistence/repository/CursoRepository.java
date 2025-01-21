package com.forohub.persistence.repository;

import com.forohub.persistence.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
    Page<Curso> findByEstadoTrue(Pageable pageable);
}
