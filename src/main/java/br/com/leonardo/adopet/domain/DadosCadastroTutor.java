package br.com.leonardo.adopet.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTutor(
        @NotBlank(message = "Nome é Obrigatório")
        String nome,
        @NotBlank(message = "Email é Obrigatório")
        @Email
        String email,
        @NotBlank
        String senha,
        @NotBlank
        String confirmacaoSenha
) {

}
