package br.edu.ifpb.praticas.projeto.commands;

import br.edu.ifpb.praticas.projeto.entidades.Usuario;
import br.edu.ifpb.praticas.projeto.services.impl.AdministradorServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.AdministradorService;
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
public class AutenticarAdministrador implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response){

        HttpSession sessao = request.getSession();

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        AdministradorService service = new AdministradorServiceBD();
        Usuario adm = service.autenticar(email, senha);

        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);

        if (adm == null) {
            sessao.invalidate();
            try {
                request.setAttribute("mensagem", "Email ou senha incorretos!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(AutenticarPrestador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sessao.setAttribute("adm", adm);
            try {
                request.getRequestDispatcher("paginaDoAdministrador.jsp").forward(request, response);
            } catch (IOException | ServletException ex) {
                Logger.getLogger(AutenticarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
