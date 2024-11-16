package com.cursosincricao.controller;

import com.cursosincricao.model.Inscricao;
import com.cursosincricao.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    // Listar todas as inscrições
    @GetMapping
    public List<Inscricao> getAllInscricoes() {
        return inscricaoService.getAllInscricoes();
    }

    // Buscar inscrição por ID
    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> getInscricaoById(@PathVariable Long id) {
        Optional<Inscricao> inscricao = inscricaoService.getInscricaoById(id);
        return inscricao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar ou atualizar inscrição
    @PostMapping
    public ResponseEntity<Inscricao> createOrUpdateInscricao(@RequestBody Inscricao inscricao) {
        Inscricao savedInscricao = inscricaoService.createOrUpdateInscricao(inscricao);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInscricao);
    }

    // Deletar inscrição
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscricao(@PathVariable Long id) {
        inscricaoService.deleteInscricao(id);
        return ResponseEntity.noContent().build();
    }
}
