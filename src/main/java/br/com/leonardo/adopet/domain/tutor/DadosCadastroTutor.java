package br.com.leonardo.adopet.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.util.Assert;

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
        public DadosCadastroTutor(
                @NotBlank(message = "Nome é Obrigatório") String nome,
                @NotBlank(message = "Email é Obrigatório") @Email String email,
                @NotBlank String senha,
                @NotBlank String confirmacaoSenha) {

                Assert.isTrue(senha.equals(confirmacaoSenha), "Favor informar a mesma senha criada");

                this.nome = nome;
                this.email = email;
                this.senha = senha;
                this.confirmacaoSenha = confirmacaoSenha;
        }
}
