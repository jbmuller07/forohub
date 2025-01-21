package com.forohub.controller;

import com.forohub.DTO.respuestaDTO.DetalleRespuestaDTO;
import com.forohub.DTO.topicoDTO.DetalleTopicoConRespuestaDTO;
import com.forohub.DTO.topicoDTO.RegistrarTopicoDTO;
import com.forohub.DTO.topicoDTO.DetalleTopicoDTO;
import com.forohub.persistence.model.Topico;
import com.forohub.service.interfaces.IRespuestaservice;
import com.forohub.service.interfaces.ITopicoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private ITopicoService topicoService;
    @Autowired
    private IRespuestaservice respuestaservice;

    @PostMapping
    public ResponseEntity<DetalleTopicoDTO> guardarTopico (@RequestBody @Valid RegistrarTopicoDTO registrarTopicoDTO,
                                                           UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoService.cambiarRegistroTopicoDTO(registrarTopicoDTO);
        topicoService.save(topico);
        DetalleTopicoDTO detalleTopicoDTO = new DetalleTopicoDTO(topico);
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(url).body(detalleTopicoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<DetalleTopicoDTO>> listarCursos(@PageableDefault(size = 10, sort = "fechaCreacion",
                                                                direction = Sort.Direction.ASC)
                                                                   Pageable paginacion){
        return ResponseEntity.ok(topicoService.findByEstadoTrue(paginacion).map(DetalleTopicoDTO::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleTopicoDTO> obtenerTopico(@PathVariable Long id){
        return ResponseEntity.ok(new DetalleTopicoDTO(topicoService.findById(id)));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalleTopicoDTO> acturalizarTopico(@PathVariable Long id, @RequestBody @Valid RegistrarTopicoDTO registrarTopicoDTO){
        if(topicoService.estaPresente(id)){
            Topico topicoCambio = topicoService.cambiarRegistroActualizarTopicoDTO(id, registrarTopicoDTO);
            topicoService.update(topicoCambio);
            return ResponseEntity.ok(new DetalleTopicoDTO(topicoCambio));
        }
        throw new EntityNotFoundException();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        topicoService.cambiarEstado(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/respuestas")
    public ResponseEntity<DetalleTopicoConRespuestaDTO> listarTopicosConRespuesta(@PathVariable Long id){
        Topico topico = topicoService.findById(id);
        List<DetalleRespuestaDTO> respuestas = respuestaservice.buscarRespuestasPorTopico(topico).stream().map(DetalleRespuestaDTO::new).toList();
        return ResponseEntity.ok(new DetalleTopicoConRespuestaDTO(topico, respuestas));
    }
}
