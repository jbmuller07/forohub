package com.forohub.DTO.cursoDTO;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetalleCursoDTO(
        @NotNull
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        String categoria,
        @AssertTrue
        Boolean estado) {
    public DetalleCursoDTO (Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria(), curso.isEstado());
    }
}
