package br.com.leonardo.adopet.domain;

import jakarta.validation.constraints.NotNull;
import org.springframework.util.Assert;

public record DadosAtualizacaoTutor(
        @NotNull
        Long id,
        String nome,
        String email,
        String senha,
        String confirmacaoSenha
) {
        public DadosAtualizacaoTutor(
                @NotNull Long id,
                String nome,
                String email,
                String senha,
                String confirmacaoSenha) {

                if (senha != null) {
                        Assert.isTrue(senha.equals(confirmacaoSenha), "Favor informar a mesma senha criada");
                }

                this.id = id;
                this.nome = nome;
                this.email = email;
                this.senha = senha;
                this.confirmacaoSenha = confirmacaoSenha;
        }
}
