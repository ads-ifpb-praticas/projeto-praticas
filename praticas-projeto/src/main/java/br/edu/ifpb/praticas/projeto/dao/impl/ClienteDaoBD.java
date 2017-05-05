package br.edu.ifpb.praticas.projeto.dao.impl;

import br.edu.ifpb.praticas.projeto.dao.interfaces.ClienteDao;
import br.edu.ifpb.praticas.projeto.entidades.Cliente;
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
public class ClienteDaoBD implements ClienteDao {

    private EntityManager em;

    public ClienteDaoBD() {
     
    }

    @Override
    public boolean salvar(Cliente cliente) {
        em = ProdutorEntityManager.criaEntityManager();
        boolean retorno = false;
        try {
            em.getTransaction().begin();
            em.persist(cliente);
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
            Cliente cliente = em.find(Cliente.class, id);
            em.remove(cliente);
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
    public boolean editar(Cliente cliente) {
        em = ProdutorEntityManager.criaEntityManager();
        boolean retorno = false;
        try {
            em.getTransaction().begin();
            em.merge(cliente);
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
    public List<Cliente> listar() {
        List<Cliente> clientes = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Cliente c");
            clientes = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return clientes;
    }

    @Override
    public Cliente getCliente(int id) {
        em = ProdutorEntityManager.criaEntityManager();
        Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, id);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return cliente;
    }

    @Override
    public Cliente autenticar(String email, String senha) {
        Cliente cliente = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.email = :email AND c.senha = :senha");
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            cliente = (Cliente) query.getSingleResult();
        } catch (Exception e) {
            return cliente;
        } finally {
           ProdutorEntityManager.finaliza(em);
        }
        return cliente;
    }

}
