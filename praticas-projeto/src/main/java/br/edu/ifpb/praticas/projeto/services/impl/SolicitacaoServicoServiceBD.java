
package br.edu.ifpb.praticas.projeto.services.impl;

import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import br.edu.ifpb.praticas.projeto.entidades.SolicitacaoServico;
import br.edu.ifpb.praticas.projeto.factory.FactoryDao;
import br.edu.ifpb.praticas.projeto.services.interfaces.SolicitacaoServicoService;
import java.util.List;

/**
 *
 * @author Edilva
 */
public class SolicitacaoServicoServiceBD implements SolicitacaoServicoService{

    @Override
    public boolean salvar(SolicitacaoServico solicitacaoServico) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaSolicitacaoServico().salvar(solicitacaoServico);
    }

    @Override
    public boolean remover(int id) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaSolicitacaoServico().remover(id);
    }

    @Override
    public boolean editar(SolicitacaoServico solicitacaoServico) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaSolicitacaoServico().editar(solicitacaoServico);
    }

    @Override
    public List<SolicitacaoServico> listar() {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaSolicitacaoServico().listar();
    }

    @Override
    public SolicitacaoServico getSolicitacaoServico(int id) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaSolicitacaoServico().getSolicitacaoServico(id);
    }

    @Override
    public List<SolicitacaoServico> solicitacoesDisponiveis(PrestadorDeServico prestador) {
        return FactoryDao.createFactory(FactoryDao.DAO_BD).criaSolicitacaoServico().solicitacoesDisponiveis(prestador);
    }
    
}
