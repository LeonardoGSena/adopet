package br.com.leonardo.adopet.tutor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTutor(
        @NotNull
        Long id,
        String nome,
        String telefone,
        String cidade,
        String sobre
) {

}
