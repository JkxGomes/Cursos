package com.cursosincricao.controller;

import com.cursosincricao.model.Curso;
import com.cursosincricao.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // Listar todos os cursos
    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.getAllCursos();
    }

    // Buscar curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        Optional<Curso> curso = cursoService.getCursoById(id);
        return curso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar ou atualizar curso
    @PostMapping
    public ResponseEntity<Curso> createOrUpdateCurso(@RequestBody Curso curso) {
        Curso savedCurso = cursoService.createOrUpdateCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCurso);
    }

    // Deletar curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
        return ResponseEntity.noContent().build();
    }
}
