package com.forohub.controller;

import com.forohub.DTO.cursoDTO.DetalleCursoDTO;
import com.forohub.DTO.cursoDTO.RegistrarCursoDTO;
import com.forohub.persistence.model.Curso;
import com.forohub.service.interfaces.ICursoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);

    @Autowired
    private ICursoService cursoService;

    @PostMapping
    public ResponseEntity<DetalleCursoDTO> guardarCurso(@RequestBody @Valid RegistrarCursoDTO registrarCursoDTO,
                                                            UriComponentsBuilder uriComponentsBuilder) {

        Curso curso = cursoService.cambiarRegistroDTO(registrarCursoDTO);
        cursoService.save(curso);
        DetalleCursoDTO detalleCursoDTO = new DetalleCursoDTO(curso.getId(), curso.getNombre(), curso.getCategoria(), curso.isEstado());
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(detalleCursoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleCursoDTO> buscarCurso(@PathVariable Long id) {
        Curso curso = cursoService.findById(id);
        DetalleCursoDTO detalleCursoDTO = new DetalleCursoDTO(curso);
        return ResponseEntity.ok(detalleCursoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<DetalleCursoDTO>> listarCursos(@PageableDefault(size = 5) Pageable paginacion){
        return ResponseEntity.ok(cursoService.findByEstadoTrue(paginacion).map(DetalleCursoDTO::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarDatosCurso(@RequestBody @Valid DetalleCursoDTO detalleCursoDTO){
        Curso curso = cursoService.cambiarDetalleDTO(detalleCursoDTO);
        cursoService.update(curso);
        return ResponseEntity.ok(new DetalleCursoDTO(curso));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCurso(@PathVariable Long id){
        cursoService.cambiarEstado(id);
        return ResponseEntity.noContent().build();
    }
}
