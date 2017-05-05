package br.edu.ifpb.praticas.projeto.dao.impl;

import br.edu.ifpb.praticas.projeto.dao.interfaces.AdministradorDao;
import br.edu.ifpb.praticas.projeto.entidades.Usuario;
import br.edu.ifpb.praticas.projeto.util.ProdutorEntityManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Edilva
 */
public class AdministradorDaoBD implements AdministradorDao {

    private EntityManager em;

    public AdministradorDaoBD() {

    }

    @Override
    public boolean salvar(Usuario administrador) {
        em = ProdutorEntityManager.criaEntityManager();
        boolean retorno = false;
        try {
            em.getTransaction().begin();
            em.persist(administrador);
            em.getTransaction().commit();
            retorno = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return retorno;
    }

    @Override
    public boolean remover(int id) {
        em = ProdutorEntityManager.criaEntityManager();
        boolean retorno = false;
        try {
            em.getTransaction().begin();
            Usuario administrador = em.find(Usuario.class, id);
            em.remove(administrador);
            em.getTransaction().commit();
            retorno = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return retorno;
    }

    @Override
    public boolean editar(Usuario administrador) {
        em = ProdutorEntityManager.criaEntityManager();
        boolean retorno = false;
        try {
            em.getTransaction().begin();
            em.merge(administrador);
            em.getTransaction().commit();
            retorno = true;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return retorno;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> administradores = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u");
            administradores = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return administradores;
    }

    @Override
    public Usuario getAdministrador(int id) {
        Usuario administrador = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            administrador = em.find(Usuario.class, id);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return administrador;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        Usuario administrador = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha");
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            administrador = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            return administrador;
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return administrador;
    }

}
