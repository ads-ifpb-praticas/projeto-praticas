
package br.edu.ifpb.praticas.projeto.services.interfaces;

import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import br.edu.ifpb.praticas.projeto.entidades.SolicitacaoServico;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface SolicitacaoServicoService {
    
    boolean salvar(SolicitacaoServico solicitacaoServico);
    boolean remover(int id);
    boolean editar(SolicitacaoServico solicitacaoServico);
    List<SolicitacaoServico> listar();
    SolicitacaoServico getSolicitacaoServico(int id);
    List<SolicitacaoServico> solicitacoesDisponiveis(PrestadorDeServico prestador);
}
