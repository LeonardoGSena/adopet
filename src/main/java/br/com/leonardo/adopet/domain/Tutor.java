package br.com.leonardo.adopet.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Table(name = "tutores")
@Entity
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String senha;


    @Deprecated
    public Tutor() {
    }

    public Tutor(DadosCadastroTutor request) {
        this.nome = request.nome();
        this.email = request.email();
        this.senha = request.senha();
    }

    public void atualizarInformacoes(DadosAtualizacaoTutor request) {
        if (request.nome() != null) {
            this.nome = request.nome();
        }
        if (request.email() != null) {
            this.email = request.email();
        }
        if (request.senha() != null) {
            this.senha = request.senha();
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tutor tutor = (Tutor) o;

        return id != null ? id.equals(tutor.id) : tutor.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
