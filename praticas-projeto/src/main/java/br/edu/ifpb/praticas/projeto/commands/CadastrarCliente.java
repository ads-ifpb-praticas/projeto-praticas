package br.edu.ifpb.praticas.projeto.commands;

import br.edu.ifpb.praticas.projeto.entidades.Cliente;
import br.edu.ifpb.praticas.projeto.entidades.Endereco;
import br.edu.ifpb.praticas.projeto.entidades.TipoServico;
import br.edu.ifpb.praticas.projeto.util.ProcessadorDeFotos;
import br.edu.ifpb.praticas.projeto.entidades.TipoUsuario;
import br.edu.ifpb.praticas.projeto.services.impl.ClienteServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.ClienteService;
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
public class CadastrarCliente implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sessao = request.getSession();

        try {
            Cliente cliente = dadosDoCliente(request);
            ClienteService service = new ClienteServiceBD();

            String url = request.getHeader("referer");
            request.setAttribute("pagina", url);

            if (service.salvar(cliente)) {

                cliente = service.autenticar(request.getParameter("email"), request.getParameter("senha"));

                Part fotoPart = request.getPart("foto");
                String foto = new ProcessadorDeFotos("img/foto").processarFoto(request, fotoPart, "foto" + cliente.getId());
                cliente.setFoto(foto);

                service.editar(cliente);
                sessao.setAttribute("cliente", cliente);
                sessao.setAttribute("servicos", TipoServico.values());

                try {
                    request.getRequestDispatcher("paginaDoCliente.jsp").forward(request, response);
                } catch (ServletException | IOException ex) {
                    Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                try {
                    sessao.invalidate();
                    request.setAttribute("mensagem", "Erro ao tentar cadastrar Cliente!");
                    request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
                } catch (ServletException | IOException ex) {
                    Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (IOException | ServletException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Cliente dadosDoCliente(HttpServletRequest request) throws IOException, ServletException {
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();

        if (request.getParameter("nome") != null) {
            String nome = request.getParameter("nome");
            cliente.setNome(nome);
        }

        if (request.getParameter("email") != null) {
            String email = request.getParameter("email");
            cliente.setEmail(email);
        }

        if (request.getParameter("senha") != null) {
            String senha = request.getParameter("senha");
            cliente.setSenha(senha);
        }

        if (request.getParameter("cpf") != null) {
            String cpf = request.getParameter("cpf");
            cliente.setCpf(cpf);
        }

        if (request.getParameter("telefone") != null) {
            String telefone = request.getParameter("telefone");
            cliente.setTelefone(telefone);
        }

        if (request.getParameter("estado") != null) {
            String estado = request.getParameter("estado");
            endereco.setEstado(estado);
        }

        if (request.getParameter("cidade") != null) {
            String cidade = request.getParameter("cidade");
            endereco.setCidade(cidade);
        }

        if (request.getParameter("bairro") != null) {
            String bairro = request.getParameter("bairro");
            endereco.setBairro(bairro);
        }

        if (request.getParameter("rua") != null) {
            String rua = request.getParameter("rua");
            endereco.setRua(rua);
        }

        cliente.setTipo_usuario(TipoUsuario.CLIENTE);

        cliente.setEndereco(endereco);

        return cliente;
    }

}
