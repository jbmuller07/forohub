package com.forohub.DTO.respuestaDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroRespuestaDTO(
        @NotBlank
        String mensaje,
        @NotBlank
        String solucion,
        @NotNull
        long autor,
        @NotNull
        long topico) {
}
