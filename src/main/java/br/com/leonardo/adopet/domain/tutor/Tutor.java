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

        if (nome != null ? !nome.equals(tutor.nome) : tutor.nome != null) return false;
        return email != null ? email.equals(tutor.email) : tutor.email == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
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

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
