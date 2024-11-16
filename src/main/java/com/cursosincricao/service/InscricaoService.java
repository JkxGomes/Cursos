package com.cursosincricao.service;

import com.cursosincricao.model.Inscricao;
import com.cursosincricao.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    public List<Inscricao> getAllInscricoes() {
        return inscricaoRepository.findAll();
    }

    public Optional<Inscricao> getInscricaoById(Long id) {
        return inscricaoRepository.findById(id);
    }

    public Inscricao createOrUpdateInscricao(Inscricao inscricao) {
        return inscricaoRepository.save(inscricao);
    }

    public void deleteInscricao(Long id) {
        inscricaoRepository.deleteById(id);
    }
}
