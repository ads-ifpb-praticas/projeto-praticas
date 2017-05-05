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
public class DetalharPrestador implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        PrestadorDeServicoService service = new PrestadorDeServicoServiceBD();
        PrestadorDeServico pds = service.getPrestadorDeServico(id);
        
        request.setAttribute("pds", pds);

        try {
            request.getRequestDispatcher("detalhesDoPrestador.jsp").forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(DetalharPrestador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
