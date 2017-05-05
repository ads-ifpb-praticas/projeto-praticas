
package br.edu.ifpb.praticas.projeto.commands;

import br.edu.ifpb.praticas.projeto.entidades.SolicitacaoServico;
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
public class DetalharSolicitacao implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        SolicitacaoServicoService service = new SolicitacaoServicoServiceBD();
        SolicitacaoServico solicitacao = service.getSolicitacaoServico(id);
        
        request.setAttribute("solicitacao", solicitacao);

        try {
            request.getRequestDispatcher("detalhesDaSolicitacao.jsp").forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(DetalharSolicitacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
