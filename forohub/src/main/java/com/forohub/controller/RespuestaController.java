package com.forohub.controller;

import com.forohub.DTO.respuestaDTO.DetalleRespuestaDTO;
import com.forohub.DTO.respuestaDTO.RegistroRespuestaDTO;
import com.forohub.persistence.model.Respuesta;
import com.forohub.service.interfaces.IRespuestaservice;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private IRespuestaservice respuestaService;

    @PostMapping
    public ResponseEntity<DetalleRespuestaDTO> guardarRespuesta(@RequestBody @Valid RegistroRespuestaDTO registroRespuestaDTO,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        Respuesta respuesta = respuestaService.cambiarRegistroRespuestaDTO(registroRespuestaDTO);
        respuestaService.save(respuesta);
        URI url = uriComponentsBuilder.path("/respuestas/{id}").build(respuesta.getId());
        return ResponseEntity.created(url).body(new DetalleRespuestaDTO(respuesta));
    }

    @GetMapping
    public ResponseEntity<List<DetalleRespuestaDTO>> listarRespuestas() {
        return ResponseEntity.ok(respuestaService.findAll().stream().map(DetalleRespuestaDTO::new).toList());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalleRespuestaDTO> modificarRespuesta(@PathVariable Long id, @RequestBody @Valid RegistroRespuestaDTO registroRespuestaDTO){
        if(respuestaService.estaPresente(id)){
            Respuesta respuesta = respuestaService.cambiarRegistroActualizarRespuestaDTO(id, registroRespuestaDTO);
            respuestaService.update(respuesta);
            return ResponseEntity.ok(new DetalleRespuestaDTO(respuesta));
        }
        throw new EntityNotFoundException();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id) {
        respuestaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
