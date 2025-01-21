package com.forohub.service.interfaces;

import com.forohub.DTO.respuestaDTO.RegistroRespuestaDTO;
import com.forohub.persistence.model.Respuesta;
import com.forohub.persistence.model.Topico;

import java.util.List;

public interface IRespuestaservice {

    void save(Respuesta respuesta);
    void update(Respuesta respuesta);
    Respuesta findById(Long id);
    List<Respuesta> findAll();
    void deleteById(Long id);
    Respuesta cambiarRegistroRespuestaDTO(RegistroRespuestaDTO registroRespuestaDTO);
    boolean estaPresente(Long id);
    Respuesta cambiarRegistroActualizarRespuestaDTO(Long id, RegistroRespuestaDTO registroRespuestaDTO);
    List<Respuesta> buscarRespuestasPorTopico(Topico topicoId);
}
