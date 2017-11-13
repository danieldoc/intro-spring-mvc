package br.com.devmedia.curso.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank
    @Size(min = 3, max = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    @NotBlank
    @Size(min = 3, max = 50, message = "Campo requerido de {min} à {max} caracteres.")
    private String sobrenome;

    @NotBlank
    @Column(length = 30, nullable = false, unique = true)
    @Size(min = 3, max = 30, message = "Campo requerido de {min} à {max} caracteres.")
    private String login;

    @NotBlank
    @Column(length = 100, nullable = false)
    private String senha;

    @Column(name = "data_nascimento", nullable = false)
    @NotNull(message = "Campo requerido.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dtNascimento;

    @Column(nullable = false, length = 1)
    @Enumerated(EnumType.STRING)
    private TipoSexo sexo;

    public Usuario() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;

        Usuario usuario = (Usuario) o;

        return id.equals(usuario.id);
    }
}