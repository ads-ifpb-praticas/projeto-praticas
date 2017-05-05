
package br.edu.ifpb.praticas.projeto.services.interfaces;

import br.edu.ifpb.praticas.projeto.entidades.Comentario;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface ComentarioService {
    
    boolean salvar(Comentario comentario, int idPrestador);
    boolean remover(int id);
    boolean editar(Comentario comentario);
    List<Comentario> listar();
    Comentario getComentario(int id);
    List<Comentario> listarComentariosPrestador(int idPrestador);
}
