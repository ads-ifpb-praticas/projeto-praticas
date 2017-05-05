
package br.edu.ifpb.praticas.projeto.services.interfaces;

import br.edu.ifpb.praticas.projeto.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface AdministradorService {
    
    boolean salvar(Usuario administrador);
    boolean remover(int id);
    boolean editar(Usuario administrador);
    List<Usuario> listar();
    Usuario getAdministrador(int id);
    Usuario autenticar(String email, String senha);
}
