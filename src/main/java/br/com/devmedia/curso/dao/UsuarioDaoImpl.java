package br.com.devmedia.curso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
        entityManager.persist(usuario);
    }

    @Override
    public void editar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void excluir(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public Usuario getId(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> getTodos() {
        String jpql = "from Usuario";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        return query.getResultList();
        //return entityManager.createQuery(jpql).getResultList();
    }
}