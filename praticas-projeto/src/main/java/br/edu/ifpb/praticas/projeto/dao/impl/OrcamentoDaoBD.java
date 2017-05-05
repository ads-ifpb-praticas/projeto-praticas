
package br.edu.ifpb.praticas.projeto.dao.impl;

import br.edu.ifpb.praticas.projeto.dao.interfaces.OrcamentoDao;
import br.edu.ifpb.praticas.projeto.dao.interfaces.SolicitacaoServicoDao;
import br.edu.ifpb.praticas.projeto.entidades.Orcamento;
import br.edu.ifpb.praticas.projeto.entidades.SolicitacaoServico;
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
public class OrcamentoDaoBD implements OrcamentoDao{
    
    private EntityManager em;

    public OrcamentoDaoBD() {
        
    }
    
    @Override
    public boolean salvar(Orcamento orcamento, int idSolicitacao) {
        SolicitacaoServicoDao dao = new SolicitacaoServicoDaoBD();
        SolicitacaoServico solicitacao = dao.getSolicitacaoServico(idSolicitacao);
        solicitacao.addOrcamento(orcamento);
        em = ProdutorEntityManager.criaEntityManager();
        boolean retorno = false;
        try {
            em.getTransaction().begin();
            em.merge(solicitacao);
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
            Orcamento orcamento = em.find(Orcamento.class, id);
            em.remove(orcamento);
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
    public boolean editar(Orcamento orcamento) {
        em = ProdutorEntityManager.criaEntityManager();
        boolean retorno = false;
        try {
            em.getTransaction().begin();
            em.merge(orcamento);
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
    public List<Orcamento> listar() {
        List<Orcamento> orcamentos = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            Query query = em.createQuery("SELECT o FROM Orcamento o");
            orcamentos = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return orcamentos;
    }

    @Override
    public Orcamento getOrcamento(int id) {
        Orcamento orcamento = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            orcamento = em.find(Orcamento.class, id);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return orcamento;
    }

}
