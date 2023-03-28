package br.com.leonardo.adopet.infra.exception;

import org.springframework.validation.FieldError;

public record DadosErrorValidacao(String campo, String mensagem) {
    public DadosErrorValidacao(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}
