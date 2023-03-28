package br.com.leonardo.adopet.tutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/tutores")
public class TutorController {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private TutorRepository tutorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity adicionaTutor(@RequestBody @Valid novoTutorRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Tutor novoTutor = request.toModel();
        manager.persist(novoTutor);
        URI uri = uriComponentsBuilder.path("/tutores/{id}").buildAndExpand(novoTutor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTutor(novoTutor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTutor(@RequestBody @Valid DadosAtualizacaoTutor request) {
        Tutor tutor = tutorRepository.getReferenceById(request.id());
        tutor.atualizarInformacoes(request);
        return ResponseEntity.ok(new DadosDetalhamentoTutor(tutor));
    }
}
