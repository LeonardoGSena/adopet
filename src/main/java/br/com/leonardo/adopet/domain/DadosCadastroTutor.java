package br.com.leonardo.adopet.domain;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record DadosCadastroTutor(
        @NotBlank(message = "Nome é Obrigatório")
        String nome,
        @NotBlank(message = "Telefone é Obrigatório")
        String telefone,
        @NotBlank(message = "Cidade é Obrigatório")
        String cidade,
        @NotBlank(message = "Sobre é Obrigatório")
        @Length(max = 100)
        String sobre
) {

}
