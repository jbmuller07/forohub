package com.forohub.DTO.topicoDTO;

import com.forohub.DTO.UsuarioDTO.DetalleUsuarioDTO;
import com.forohub.DTO.cursoDTO.DetalleCursoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrarTopicoDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        long autor,
        @NotNull
        long curso
) {
}
