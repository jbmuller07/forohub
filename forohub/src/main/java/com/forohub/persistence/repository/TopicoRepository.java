package com.forohub.persistence.repository;

import com.forohub.persistence.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TopicoRepository extends CrudRepository<Topico, Long> {
    Page<Topico> findByEstadoTrue(Pageable pageable);

}
