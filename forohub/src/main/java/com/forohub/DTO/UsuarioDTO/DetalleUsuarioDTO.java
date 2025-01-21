package com.forohub.DTO.UsuarioDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetalleUsuarioDTO(

        @NotNull
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String correoElectronico) {
    public DetalleUsuarioDTO(Usuario usuario){
        this(usuario.getId(),usuario.getNombre(),usuario.getCorreoElectronico());
    }
}
