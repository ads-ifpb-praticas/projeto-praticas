
package br.edu.ifpb.praticas.projeto.dao.interfaces;

import br.edu.ifpb.praticas.projeto.entidades.Orcamento;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface OrcamentoDao {
    
    boolean salvar(Orcamento orcamento, int idSolicitacao);
    boolean remover(int id);
    boolean editar(Orcamento orcamento);
    List<Orcamento> listar();
    Orcamento getOrcamento(int id);
}
