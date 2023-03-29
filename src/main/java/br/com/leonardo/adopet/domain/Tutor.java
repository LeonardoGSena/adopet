package br.com.leonardo.adopet.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Table(name = "tutores")
@Entity
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cidade;
    @NotBlank
    @Length(max = 100)
    private String sobre;

    @Deprecated
    public Tutor() {
    }

    public Tutor(DadosCadastroTutor request) {
        this.nome = request.nome();
        this.telefone = request.telefone();
        this.cidade = request.cidade();
        this.sobre = request.sobre();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public String getSobre() {
        return sobre;
    }

    public void atualizarInformacoes(DadosAtualizacaoTutor request) {
        if (request.nome() != null) {
            this.nome = request.nome();
        }
        if (request.telefone() != null) {
            this.telefone = request.telefone();
        }
        if (request.cidade() != null) {
            this.cidade = request.cidade();
        }
        if (request.sobre() != null) {
            this.sobre = request.sobre();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tutor tutor = (Tutor) o;

        if (nome != null ? !nome.equals(tutor.nome) : tutor.nome != null) return false;
        return telefone != null ? telefone.equals(tutor.telefone) : tutor.telefone == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cidade='" + cidade + '\'' +
                ", sobre='" + sobre + '\'' +
                '}';
    }
}
