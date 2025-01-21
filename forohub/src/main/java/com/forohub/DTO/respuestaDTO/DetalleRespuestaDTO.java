package com.forohub.DTO.respuestaDTO;

import com.forohub.DTO.UsuarioDTO.DetalleUsuarioDTO;
import com.forohub.DTO.topicoDTO.DetalleTopicoDTO;

import java.time.LocalDateTime;

public record DetalleRespuestaDTO(Long id,
                                  String mensaje,
                                  String solucion,
                                  LocalDateTime fechaDeCreacion,
                                  DetalleUsuarioDTO autor,
                                  DetalleTopicoDTO topico) {
    public DetalleRespuestaDTO(Respuesta respuesta) {
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getSolucion(), respuesta.getFechaCreacion(),
                new DetalleUsuarioDTO(respuesta.getAutor()), new DetalleTopicoDTO(respuesta.getTopico()));
    }
}
