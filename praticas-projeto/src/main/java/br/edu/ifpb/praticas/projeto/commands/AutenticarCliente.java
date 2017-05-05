
package br.edu.ifpb.praticas.projeto.commands;

import br.edu.ifpb.praticas.projeto.entidades.Cliente;
import br.edu.ifpb.praticas.projeto.entidades.TipoServico;
import br.edu.ifpb.praticas.projeto.entidades.Usuario;
import br.edu.ifpb.praticas.projeto.services.impl.AdministradorServiceBD;
import br.edu.ifpb.praticas.projeto.services.impl.ClienteServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.AdministradorService;
import br.edu.ifpb.praticas.projeto.services.interfaces.ClienteService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edilva
 */
public class AutenticarCliente implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession sessao = request.getSession();

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        ClienteService service = new ClienteServiceBD();
        Cliente cliente = service.autenticar(email, senha);
        
        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);
                
        if(cliente == null){
            sessao.invalidate();
            try {
                request.setAttribute("mensagem", "Email ou senha incorretos!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(AutenticarPrestador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            sessao.setAttribute("cliente", cliente);
            sessao.setAttribute("servicos", TipoServico.values());
            try {
                request.getRequestDispatcher("paginaDoCliente.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(AutenticarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
