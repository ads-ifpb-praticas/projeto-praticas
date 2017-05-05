package br.edu.ifpb.praticas.projeto.commands;

import br.edu.ifpb.praticas.projeto.entidades.Cliente;
import br.edu.ifpb.praticas.projeto.entidades.Comentario;
import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import br.edu.ifpb.praticas.projeto.services.impl.ClienteServiceBD;
import br.edu.ifpb.praticas.projeto.services.impl.ComentarioServiceBD;
import br.edu.ifpb.praticas.projeto.services.impl.PrestadorDeServicoServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.ClienteService;
import br.edu.ifpb.praticas.projeto.services.interfaces.ComentarioService;
import br.edu.ifpb.praticas.projeto.services.interfaces.PrestadorDeServicoService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edilva
 */
public class EnviarComentario implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        int idCliente = Integer.parseInt(request.getParameter("cliente"));
        int idPrestador = Integer.parseInt(request.getParameter("prestador"));
        String comentario = request.getParameter("comentario");

        ClienteService clienteService = new ClienteServiceBD();
        Cliente cliente = clienteService.getCliente(idCliente);

        ComentarioService comentarioService = new ComentarioServiceBD();

        Comentario c = new Comentario(cliente, comentario);

        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);

        try {
            if (comentarioService.salvar(c, idPrestador)) {
                request.setAttribute("mensagem", "Comentario enviado com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }else{
                request.setAttribute("mensagem", "Erro ao enviar comentário!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(EnviarComentario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
