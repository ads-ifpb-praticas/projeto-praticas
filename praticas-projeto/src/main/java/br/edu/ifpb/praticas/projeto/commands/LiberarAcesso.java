
package br.edu.ifpb.praticas.projeto.commands;

import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import br.edu.ifpb.praticas.projeto.services.impl.PrestadorDeServicoServiceBD;
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
public class LiberarAcesso implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        
        PrestadorDeServicoService service = new PrestadorDeServicoServiceBD();
        PrestadorDeServico pds = service.getPrestadorDeServico(id);
        
        pds.setAcesso(true);
        
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);
        
        if(service.editar(pds)){
            try {
                request.setAttribute("mensagem", "Acesso liberado para o prestador(a) de serviço " + pds.getNome() + "!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LiberarAcesso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                request.setAttribute("mensagem", "Erro ao liberar acesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LiberarAcesso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
