package com.forohub.DTO.cursoDTO;

import jakarta.validation.constraints.NotBlank;

public record RegistrarCursoDTO(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria) {
}
