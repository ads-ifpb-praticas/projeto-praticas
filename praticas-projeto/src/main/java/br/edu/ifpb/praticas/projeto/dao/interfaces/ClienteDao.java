
package br.edu.ifpb.praticas.projeto.dao.interfaces;

import br.edu.ifpb.praticas.projeto.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface ClienteDao {
    
    boolean salvar(Cliente cliente);
    boolean remover(int id);
    boolean editar(Cliente cliente);
    List<Cliente> listar();
    Cliente getCliente(int id);
    Cliente autenticar(String email, String senha);
}
