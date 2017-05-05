
package br.edu.ifpb.praticas.projeto.factory;

import br.edu.ifpb.praticas.projeto.dao.interfaces.AdministradorDao;
import br.edu.ifpb.praticas.projeto.dao.impl.AdministradorDaoBD;
import br.edu.ifpb.praticas.projeto.dao.interfaces.ClienteDao;
import br.edu.ifpb.praticas.projeto.dao.impl.ClienteDaoBD;
import br.edu.ifpb.praticas.projeto.dao.interfaces.ComentarioDao;
import br.edu.ifpb.praticas.projeto.dao.impl.ComentarioDaoBD;
import br.edu.ifpb.praticas.projeto.dao.interfaces.OrcamentoDao;
import br.edu.ifpb.praticas.projeto.dao.impl.OrcamentoDaoBD;
import br.edu.ifpb.praticas.projeto.dao.interfaces.PrestadorDeServicoDao;
import br.edu.ifpb.praticas.projeto.dao.impl.PrestadorDeServicoDaoBD;
import br.edu.ifpb.praticas.projeto.dao.interfaces.SolicitacaoServicoDao;
import br.edu.ifpb.praticas.projeto.dao.impl.SolicitacaoServicoDaoBD;

/**
 *
 * @author Edilva
 */
public class FactoryDaoBD implements FactoryDaoIF{

    @Override
    public AdministradorDao criaAdministrador() {
        return new AdministradorDaoBD();
    }

    @Override
    public ClienteDao criaCliente() {
        return new ClienteDaoBD();
    }

    @Override
    public PrestadorDeServicoDao criaPrestadorDeServico() {
        return new PrestadorDeServicoDaoBD();
    }

    @Override
    public ComentarioDao criaComentario() {
        return new ComentarioDaoBD();
    }

    @Override
    public SolicitacaoServicoDao criaSolicitacaoServico() {
        return new SolicitacaoServicoDaoBD();
    }

    @Override
    public OrcamentoDao criaOrcamento() {
        return new OrcamentoDaoBD();
    }
    
}
