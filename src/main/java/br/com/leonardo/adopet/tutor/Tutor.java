package br.com.leonardo.adopet.tutor;

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

    public Tutor(@NotBlank String nome, @NotBlank String telefone, @NotBlank String cidade, @NotBlank @Length(max = 100) String sobre) {
        this.nome = nome;
        this.telefone = telefone;
        this.cidade = cidade;
        this.sobre = sobre;
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
}
