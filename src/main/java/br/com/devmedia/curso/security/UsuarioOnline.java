package br.com.devmedia.curso.security;

import br.com.devmedia.curso.domain.TipoSexo;
import br.com.devmedia.curso.domain.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.Collection;

public class UsuarioOnline extends User {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;

    public UsuarioOnline(Usuario usuario, Collection<? extends GrantedAuthority> authorities){
        super(usuario.getLogin(), usuario.getSenha(), authorities);
        this.usuario = usuario;
    }

    public Long getId() {
        return usuario.getId();
    }

    public String getNome() {
        return usuario.getNome();
    }

    public String getSobrenome() {
        return usuario.getSobrenome();
    }

    public LocalDate getDtNascimento() {
        return usuario.getDtNascimento();
    }

    public TipoSexo getSexo() {
        return usuario.getSexo();
    }
}
