package com.cursosincricao.controller;


import com.cursosincricao.model.Aluno;
import com.cursosincricao.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // Listar todos os alunos
    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    // Buscar aluno por ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoService.getAlunoById(id);
        return aluno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar ou atualizar aluno
    @PostMapping
    public ResponseEntity<Aluno> createOrUpdateAluno(@RequestBody Aluno aluno) {
        Aluno savedAluno = alunoService.createOrUpdateAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAluno);
    }

    // Deletar aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }
}
