package br.edu.ifpb.praticas.projeto.dao.impl;

import br.edu.ifpb.praticas.projeto.dao.interfaces.SolicitacaoServicoDao;
import br.edu.ifpb.praticas.projeto.entidades.Orcamento;
import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import br.edu.ifpb.praticas.projeto.entidades.SolicitacaoServico;
import br.edu.ifpb.praticas.projeto.util.ProdutorEntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Edilva
 */
public class SolicitacaoServicoDaoBD implements SolicitacaoServicoDao {

    private EntityManager em;

    public SolicitacaoServicoDaoBD() {

    }

    @Override
    public boolean salvar(SolicitacaoServico solicitacaoServico) {
        em = ProdutorEntityManager.criaEntityManager();
        boolean retorno = false;
        try {
            System.out.println("passsou1");
            em.getTransaction().begin();
            System.out.println("passsou2");
            em.persist(solicitacaoServico);
            System.out.println("passsou3");
            em.getTransaction().commit();
            System.out.println("passsou4");
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
            SolicitacaoServico solicitacaoServico = em.find(SolicitacaoServico.class, id);
            em.remove(solicitacaoServico);
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
    public boolean editar(SolicitacaoServico solicitacaoServico) {
        em = ProdutorEntityManager.criaEntityManager();
        boolean retorno = false;
        try {
            System.out.println("passsou1");
            em.getTransaction().begin();
            System.out.println("passsou2");
            em.merge(solicitacaoServico);
            System.out.println("passsou3");
            em.getTransaction().commit();
            System.out.println("passsou4");
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
    public List<SolicitacaoServico> listar() {
        List<SolicitacaoServico> solicitacoes = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            Query query = em.createQuery("SELECT s FROM SolicitacaoServico s");
            solicitacoes = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return solicitacoes;
    }

    @Override
    public SolicitacaoServico getSolicitacaoServico(int id) {
        SolicitacaoServico solicitacaoServico = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            solicitacaoServico = em.find(SolicitacaoServico.class, id);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return solicitacaoServico;
    }

    
    @Override
     public List<SolicitacaoServico> solicitacoesOrcamento(PrestadorDeServico prestador) {
        List<SolicitacaoServico> solicitacoes = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            Query query = em.createQuery("SELECT s FROM SolicitacaoServico s JOIN s.orcamentos o WHERE o.prestadorDeServico.id = :prestador");
            query.setParameter("prestador", prestador.getId());
            solicitacoes = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return solicitacoes;
    }

    @Override
    public List<SolicitacaoServico> solicitacoesDisponiveis(PrestadorDeServico prestador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}