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
            em.getTransaction().begin();
            em.persist(solicitacaoServico);
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
            em.getTransaction().begin();
            em.merge(solicitacaoServico);
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
    public List<SolicitacaoServico> solicitacoesDisponiveis(PrestadorDeServico prestador) {
        //List<SolicitacaoServico> solicitacoes = listar();
//        List<SolicitacaoServico> solicitacoes2 = new ArrayList<>();
//        for (SolicitacaoServico solicitacao : solicitacoes) {
//            List<Orcamento> orcamentos = solicitacao.getOrcamentos();
//            for (Orcamento orcamento : orcamentos) {
//                if(!orcamento.getPrestadorDeServico().equals(prestador)){
//                    solicitacoes2.add(solicitacao);
//                }
//            }
//        }
        //return solicitacoes;
        List<SolicitacaoServico> solicitacoes = null;
        em = ProdutorEntityManager.criaEntityManager();
        try {
            Query query = em.createQuery("SELECT s FROM SolicitacaoServico s JOIN Orcamento o WHERE s.orcamentos.prestadorDeServico = :prestador");
            query.setParameter("prestador", prestador);
            solicitacoes = query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            ProdutorEntityManager.finaliza(em);
        }
        return solicitacoes;
    }

}
