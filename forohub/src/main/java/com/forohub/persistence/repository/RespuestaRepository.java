package com.forohub.persistence.repository;

import com.forohub.persistence.model.Respuesta;
import com.forohub.persistence.model.Topico;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RespuestaRepository extends CrudRepository<Respuesta, Long> {
    List<Respuesta> findByTopico(Topico topico);
}
