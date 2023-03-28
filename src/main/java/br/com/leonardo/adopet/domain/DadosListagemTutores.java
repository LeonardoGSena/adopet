package br.com.leonardo.adopet.domain;

public record DadosListagemTutores(Long id, String nome, String telefone, String cidade, String sobre) {
    public DadosListagemTutores(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getTelefone(), tutor.getCidade(), tutor.getSobre());
    }
}
