package br.com.leonardo.adopet.domain;

public record DadosListagemTutores(Long id, String nome, String email) {
    public DadosListagemTutores(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getEmail());
    }
}
