
package br.edu.ifpb.praticas.projeto.services.impl;

import br.edu.ifpb.praticas.projeto.entidades.Orcamento;
import br.edu.ifpb.praticas.projeto.factory.FactoryDao;
import br.edu.ifpb.praticas.projeto.services.interfaces.OrcamentoService;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class OrcamentoServiceBD implements OrcamentoService{

    @Override
    public boolean salvar(Orcamento orcamento, int idSolicitacao) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaOrcamento().salvar(orcamento, idSolicitacao);
    }

    @Override
    public boolean remover(int id) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaOrcamento().remover(id);
    }

    @Override
    public boolean editar(Orcamento orcamento) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaOrcamento().editar(orcamento);
    }

    @Override
    public List<Orcamento> listar() {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaOrcamento().listar();
    }

    @Override
    public Orcamento getOrcamento(int id) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaOrcamento().getOrcamento(id);
    }

//    @Override
//    public boolean salvar(Orcamento orcamento) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaOrcamento().salvar(orcamento);
//    }
//
//    @Override
//    public boolean remover(int id) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaOrcamento().remover(id);
//    }
//
//    @Override
//    public boolean editar(Orcamento orcamento) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaOrcamento().editar(orcamento);
//    }
//
//    @Override
//    public Orcamento getOrcamento(int id) {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaOrcamento().getOrcamento(id);
//    }
//
//    @Override
//    public List<Orcamento> listar() {
//        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaOrcamento().listar();
//    }
    
}
