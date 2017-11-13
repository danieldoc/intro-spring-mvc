package br.com.devmedia.curso.dao;

import java.util.List;

import br.com.devmedia.curso.domain.Usuario;

public interface UsuarioDao {

    void salvar(Usuario usuario);

    void editar(Usuario usuario);

    void excluir(Long id);

    Usuario getId(Long id);

    Usuario findByLogin(String username);

    List<Usuario> getTodos();
}