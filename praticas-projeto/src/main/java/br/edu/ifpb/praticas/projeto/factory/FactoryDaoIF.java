
package br.edu.ifpb.praticas.projeto.factory;

import br.edu.ifpb.praticas.projeto.dao.interfaces.AdministradorDao;
import br.edu.ifpb.praticas.projeto.dao.interfaces.ClienteDao;
import br.edu.ifpb.praticas.projeto.dao.interfaces.ComentarioDao;
import br.edu.ifpb.praticas.projeto.dao.interfaces.OrcamentoDao;
import br.edu.ifpb.praticas.projeto.dao.interfaces.PrestadorDeServicoDao;
import br.edu.ifpb.praticas.projeto.dao.interfaces.SolicitacaoServicoDao;

/**
 *
 * @author Edilva
 */
public interface FactoryDaoIF {
    
    AdministradorDao criaAdministrador();
    
    ClienteDao criaCliente();
    
    PrestadorDeServicoDao criaPrestadorDeServico();
    
    ComentarioDao criaComentario();
    
    SolicitacaoServicoDao criaSolicitacaoServico();
    
    OrcamentoDao criaOrcamento();
}
