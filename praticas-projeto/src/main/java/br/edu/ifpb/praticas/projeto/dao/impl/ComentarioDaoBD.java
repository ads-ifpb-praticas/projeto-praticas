
package br.edu.ifpb.praticas.projeto.dao.impl;

import br.edu.ifpb.praticas.projeto.dao.interfaces.ComentarioDao;
import br.edu.ifpb.praticas.projeto.dao.interfaces.PrestadorDeServicoDao;
import br.edu.ifpb.praticas.projeto.entidades.Comentario;
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
public class ComentarioDaoBD implements ComentarioDao{
    
    private EntityManager em;

    public ComentarioDaoBD() {
        
    }
    
    @Override
    public boolean salvar(Comentario comentario, int idPrestador) {
        PrestadorDeServicoDao dao = new PrestadorDeServicoDaoBD();
        PrestadorDeServico pds = dao.getPrestadorDeServico(idPrestador);
        pds.addComentario(comentario);
        em = ProdutorEntityManager.criaEntityManager();
        boolean retorno = false;
        try {
            em.getTransaction().begin();
            em.merge(pds);
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
            Comentario comentario = em.find(Comentario.class, id);
            em.remove(comentario);
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
    public boolean editar(Comentario comentario) {
        em = ProdutorEntityManager.criaEntityManager();
        boolean retorno = false;
        try {
            em.getTransaction().begin();
            em.merge(comentario);
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
    public List<Comentario> listar() {
        List<Comentario> comentarios = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Comentario c");
            comentarios = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return comentarios;
    }

    @Override
    public Comentario getComentario(int id) {
        Comentario comentario = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            comentario = em.find(Comentario.class, id);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
           ProdutorEntityManager.finaliza(em);
        }
        return comentario;
    }

    @Override
    public List<Comentario> listarComentariosPrestador(int idPrestador) {
        List<Comentario> comentarios = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Comentario c WHERE c.prestador_de_servico = :prestador_de_servico");
            query.setParameter("prestador_de_servico", idPrestador);
            comentarios = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return comentarios;
    }
 
}
