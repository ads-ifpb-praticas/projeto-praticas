
package br.edu.ifpb.praticas.projeto.commands;

import br.edu.ifpb.praticas.projeto.services.impl.OrcamentoServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.OrcamentoService;
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
public class RemoverOrcamento implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        OrcamentoService service = new OrcamentoServiceBD();

        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);

        try {
            if (service.remover(id)) {
                request.setAttribute("mensagem", "Orcamento removido com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }else{
                request.setAttribute("mensagem", "Erro ao remover Orcamento!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(RemoverOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
