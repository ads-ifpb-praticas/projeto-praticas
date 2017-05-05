
package br.edu.ifpb.praticas.projeto.dao.interfaces;

import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface PrestadorDeServicoDao {
    
    boolean salvar(PrestadorDeServico prestadorDeServico);
    boolean remover(int id);
    boolean editar(PrestadorDeServico prestadorDeServico);
    List<PrestadorDeServico> listar();
    PrestadorDeServico getPrestadorDeServico(int id);
    PrestadorDeServico autenticar(String email, String senha);
}
