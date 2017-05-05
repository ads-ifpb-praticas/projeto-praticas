package br.edu.ifpb.praticas.projeto.commands;

import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import br.edu.ifpb.praticas.projeto.util.ProcessadorDeFotos;
import br.edu.ifpb.praticas.projeto.entidades.TipoServico;
import br.edu.ifpb.praticas.projeto.entidades.TipoUsuario;
import br.edu.ifpb.praticas.projeto.services.impl.PrestadorDeServicoServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.PrestadorDeServicoService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Edilva
 */
public class CadastrarPrestadorDeServico implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sessao = request.getSession();

        try {
            PrestadorDeServico pds = dadosDoPrestadorDeServico(request);
            PrestadorDeServicoService service = new PrestadorDeServicoServiceBD();

            String url = request.getHeader("referer");
            request.setAttribute("pagina", url);

            if (service.salvar(pds)) {
                pds = service.autenticar(request.getParameter("email"), request.getParameter("senha"));

                Part documentoPart = request.getPart("documento");
                String documento = new ProcessadorDeFotos("img/documento").processarFoto(request, documentoPart, "documento" + pds.getId());
                pds.setDocumento(documento);

                Part fotoPart = request.getPart("foto");
                String foto = new ProcessadorDeFotos("img/foto").processarFoto(request, fotoPart, "foto" + pds.getId());
                pds.setFoto(foto);

                service.editar(pds);
                sessao.setAttribute("pds", pds);
                
                try {
                    request.getRequestDispatcher("paginaDoPrestador.jsp").forward(request, response);
                } catch (ServletException | IOException ex) {
                    Logger.getLogger(CadastrarPrestadorDeServico.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                try {
                    sessao.invalidate();
                    request.setAttribute("mensagem", "Erro ao tentar cadastrar Prestado de Serviço!");
                    request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
                } catch (ServletException | IOException ex) {
                    Logger.getLogger(CadastrarPrestadorDeServico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (IOException | ServletException ex) {
            Logger.getLogger(CadastrarPrestadorDeServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private PrestadorDeServico dadosDoPrestadorDeServico(HttpServletRequest request) throws IOException, ServletException {
        PrestadorDeServico pds = new PrestadorDeServico();

        if (request.getParameter("nome") != null) {
            String nome = request.getParameter("nome");
            pds.setNome(nome);
        }

        if (request.getParameter("email") != null) {
            String email = request.getParameter("email");
            pds.setEmail(email);
        }

        if (request.getParameter("senha") != null) {
            String senha = request.getParameter("senha");
            pds.setSenha(senha);
        }

        if (request.getParameter("cpf") != null) {
            String cpf = request.getParameter("cpf");
            pds.setCpf(cpf);
        }

        if (request.getParameter("tipo_servico") != null) {
            String tipo_servico = request.getParameter("tipo_servico");
            pds.setTipo_servico(TipoServico.valueOf(tipo_servico));
        }

        pds.setTipo_usuario(TipoUsuario.PRESTADOR_DE_SERVICO);
        
        pds.setAcesso(false);

        return pds;
    }
}
