package br.com.leonardo.adopet.domain;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class NovoTutorRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cidade;
    @NotBlank
    @Length(max = 100)
    private String sobre;

    public NovoTutorRequest(@NotBlank String nome, @NotBlank String telefone, @NotBlank String cidade, @NotBlank @Length(max = 100) String sobre) {
        this.nome = nome;
        this.telefone = telefone;
        this.cidade = cidade;
        this.sobre = sobre;
    }

    public Tutor toModel() {
        return new Tutor(nome, telefone, cidade, sobre);
    }

}
