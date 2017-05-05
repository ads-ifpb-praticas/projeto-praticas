package br.edu.ifpb.praticas.projeto.dao.impl;

import br.edu.ifpb.praticas.projeto.dao.interfaces.PrestadorDeServicoDao;
import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import br.edu.ifpb.praticas.projeto.util.ProdutorEntityManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Edilva
 */
public class PrestadorDeServicoDaoBD implements PrestadorDeServicoDao {

    private EntityManager em;

    public PrestadorDeServicoDaoBD() {
    }

    @Override
    public boolean salvar(PrestadorDeServico prestadorDeServico) {
        em = ProdutorEntityManager.criaEntityManager();
        boolean retorno = false;
        try {
            em.getTransaction().begin();
            em.persist(prestadorDeServico);
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
            PrestadorDeServico prestadorDeServico = em.find(PrestadorDeServico.class, id);
            em.remove(prestadorDeServico);
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
    public boolean editar(PrestadorDeServico prestadorDeServico) {
        em = ProdutorEntityManager.criaEntityManager();
        boolean retorno = false;
        try {
            em.getTransaction().begin();
            em.merge(prestadorDeServico);
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
    public List<PrestadorDeServico> listar() {
        List<PrestadorDeServico> prestadores = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM PrestadorDeServico p");
            prestadores = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return prestadores;
    }

    @Override
    public PrestadorDeServico getPrestadorDeServico(int id) {
        PrestadorDeServico prestadorDeServico = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            prestadorDeServico = em.find(PrestadorDeServico.class, id);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
           ProdutorEntityManager.finaliza(em);
        }
        return prestadorDeServico;
    }

    @Override
    public PrestadorDeServico autenticar(String email, String senha) {
        PrestadorDeServico prestadorDeServico = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM PrestadorDeServico p WHERE p.email = :email AND p.senha = :senha");
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            prestadorDeServico = (PrestadorDeServico) query.getSingleResult();
        } catch (Exception e) {
            return prestadorDeServico;
        } finally {
           ProdutorEntityManager.finaliza(em);
        }
        return prestadorDeServico;
    }

}
