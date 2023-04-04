package br.com.leonardo.adopet.domain;

public record DadosDetalhamentoTutor(Long id, String nome, String email) {

    public DadosDetalhamentoTutor(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getEmail());
    }
}
