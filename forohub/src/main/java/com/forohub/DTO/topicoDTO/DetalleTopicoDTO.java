package com.forohub.DTO.topicoDTO;

import com.forohub.DTO.UsuarioDTO.DetalleUsuarioDTO;
import com.forohub.DTO.cursoDTO.DetalleCursoDTO;
import com.forohub.DTO.respuestaDTO.DetalleRespuestaDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DetalleTopicoDTO(
        @NotNull
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @AssertTrue
        boolean estado,
        @FutureOrPresent
        LocalDateTime fechaCreacion,
        @NotBlank
        @Valid
        DetalleUsuarioDTO autor,
        @NotBlank
        @Valid
        DetalleCursoDTO curso
) {
        public DetalleTopicoDTO(Topico topico) {
                this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                        topico.isEstado(), topico.getFechaCreacion(),
                        new DetalleUsuarioDTO(topico.getAutor()),
                        new DetalleCursoDTO(topico.getCurso()));
        }
}
