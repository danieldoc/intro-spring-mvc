package br.com.devmedia.curso.dao;

import java.awt.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.devmedia.curso.domain.Usuario;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void salvar(Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        entityManager.persist(usuario);
    }

    @Override
    public void editar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void excluir(Long id) {
        entityManager.remove(entityManager.getReference(Usuario.class, id));
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario getId(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findByLogin(String username) {
        String jpql = "From Usuario WHERE login = :login";
        Usuario usuario = null;
        try {
            usuario = entityManager.createQuery(jpql, Usuario.class).setParameter("login", username).getSingleResult();
        } catch (NoResultException e) {
            usuario = null;
        }
        return usuario;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> getTodos() {
        String jpql = "from Usuario";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        return query.getResultList();
    }
}