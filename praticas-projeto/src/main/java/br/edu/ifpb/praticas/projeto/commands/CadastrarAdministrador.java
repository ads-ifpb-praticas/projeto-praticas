package br.edu.ifpb.praticas.projeto.commands;

import br.edu.ifpb.praticas.projeto.entidades.TipoUsuario;
import br.edu.ifpb.praticas.projeto.entidades.Usuario;
import br.edu.ifpb.praticas.projeto.services.impl.AdministradorServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.AdministradorService;
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
public class CadastrarAdministrador implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            Usuario adm = dadosDoAdministrador(request);
            AdministradorService service = new AdministradorServiceBD();

            String url = request.getHeader("referer");
            request.setAttribute("pagina", url);

            if (service.salvar(adm)) {
                request.setAttribute("mensagem", "Administrador cadastrado com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } else {
                request.setAttribute("mensagem", "Erro ao tentar cadastrar Administrador!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }

        } catch (IOException | ServletException ex) {
            Logger.getLogger(CadastrarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Usuario dadosDoAdministrador(HttpServletRequest request) throws IOException, ServletException {
        Usuario administrador = new Usuario();

        if (request.getParameter("nome") != null) {
            String nome = request.getParameter("nome");
            administrador.setNome(nome);
        }

        if (request.getParameter("email") != null) {
            String email = request.getParameter("email");
            administrador.setEmail(email);
        }

        if (request.getParameter("senha") != null) {
            String senha = request.getParameter("senha");
            administrador.setSenha(senha);
        }

        administrador.setTipo_usuario(TipoUsuario.ADMINISTRADOR);

        return administrador;
    }

}
