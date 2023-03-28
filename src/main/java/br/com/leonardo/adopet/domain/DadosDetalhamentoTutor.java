package br.com.leonardo.adopet.domain;

public record DadosDetalhamentoTutor(Long id, String nome, String telefone, String cidade, String sobre) {

    public DadosDetalhamentoTutor(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getTelefone(), tutor.getCidade(), tutor.getSobre());
    }
}
