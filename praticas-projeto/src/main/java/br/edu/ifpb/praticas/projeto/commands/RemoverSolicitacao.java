
package br.edu.ifpb.praticas.projeto.commands;

import br.edu.ifpb.praticas.projeto.services.impl.SolicitacaoServicoServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.SolicitacaoServicoService;
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
public class RemoverSolicitacao implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        SolicitacaoServicoService service = new SolicitacaoServicoServiceBD();

        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);

        try {
            if (service.remover(id)) {
                request.setAttribute("mensagem", "Solicitacao de Serviço removido com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }else{
                request.setAttribute("mensagem", "Erro ao remover Solicitacao de Serviço!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(RemoverSolicitacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
