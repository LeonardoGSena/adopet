package br.com.leonardo.adopet.controller;

import br.com.leonardo.adopet.domain.*;
import br.com.leonardo.adopet.infra.exception.ResourceNotFoundException;
import br.com.leonardo.adopet.repository.TutorRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tutores")
public class TutorController {


    private final TutorRepository tutorRepository;

    public TutorController(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTutor(@RequestBody @Valid DadosCadastroTutor request, UriComponentsBuilder uriComponentsBuilder) {
        Tutor tutor = new Tutor(request);
        if (!request.senha().equals(request.confirmacaoSenha())) {
            return ResponseEntity.badRequest().body("A confirmação da senha não está igual a senha criada");
        }
        tutorRepository.save(tutor);
        URI uri = uriComponentsBuilder.path("/tutores/{id}").buildAndExpand(tutor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTutor(tutor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTutor(@RequestBody @Valid DadosAtualizacaoTutor request) {
        Tutor tutor = tutorRepository.getReferenceById(request.id());
        if (!request.senha().equals(request.confirmacaoSenha())) {
            return ResponseEntity.badRequest().body("A confirmação da senha não está igual a senha criada");
        }
        tutor.atualizarInformacoes(request);
        return ResponseEntity.ok(new DadosDetalhamentoTutor(tutor));
    }

    @GetMapping
    public ResponseEntity<Page<Object>> listarTutores(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<Object> tutores = tutorRepository.findAll(paginacao).map(DadosListagemTutores::new);
        return ResponseEntity.ok(tutores);
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<Void> excluirTutor(@PathVariable Long id) {
        Optional<Tutor> tutor = tutorRepository.findById(id);
        tutorRepository.delete(tutor.orElseThrow(() -> new ResourceNotFoundException("Id not found " + id)));
        return ResponseEntity.noContent().build();
    }
}
