/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.projeto.services.impl;

import br.edu.ifpb.praticas.projeto.entidades.SolicitacaoServico;
import br.edu.ifpb.praticas.projeto.entidades.StatusSolicitacao;
import br.edu.ifpb.praticas.projeto.services.interfaces.SolicitacaoServicoService;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edilva
 */
public class NewMain {

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SolicitacaoServicoService sss = new SolicitacaoServicoServiceBD();
        SolicitacaoServico solicitacaoServico = sss.getSolicitacaoServico(3);
        System.out.println(solicitacaoServico.getStatus());
        solicitacaoServico.setStatus(StatusSolicitacao.CONFIRMADA);
        solicitacaoServico.setId(10);
        sss.salvar(solicitacaoServico);
        List<SolicitacaoServico> l = sss.listar();
        for (SolicitacaoServico solicitacaoServico1 : l) {
            System.out.println(solicitacaoServico1.toString());
        }
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("praticas-projetoPU");
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.merge(solicitacaoServico);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
        //System.out.println(sss.editar(solicitacaoServico));
        //System.out.println(solicitacaoServico.getStatus());
    }
    
}
