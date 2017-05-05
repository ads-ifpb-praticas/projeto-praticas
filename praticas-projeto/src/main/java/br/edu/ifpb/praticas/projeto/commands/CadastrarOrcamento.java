package br.edu.ifpb.praticas.projeto.commands;

import br.edu.ifpb.praticas.projeto.entidades.Orcamento;
import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import br.edu.ifpb.praticas.projeto.entidades.StatusOrcamento;
import br.edu.ifpb.praticas.projeto.services.impl.OrcamentoServiceBD;
import br.edu.ifpb.praticas.projeto.services.impl.PrestadorDeServicoServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.OrcamentoService;
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
public class CadastrarOrcamento implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        int idPrestador = Integer.parseInt(request.getParameter("idPrestador"));
        int idSolicitacao = Integer.parseInt(request.getParameter("idSolicitacao"));
        double valor = Double.parseDouble(request.getParameter("valor"));
        String descricao = request.getParameter("descricao");

        PrestadorDeServicoService prestadorDeServicoService = new PrestadorDeServicoServiceBD();
        PrestadorDeServico pds = prestadorDeServicoService.getPrestadorDeServico(idPrestador);

        Orcamento orcamento = new Orcamento(pds, descricao, valor, StatusOrcamento.ABERTO);

        OrcamentoService orcamentoService = new OrcamentoServiceBD();

        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);

        try {
            if (orcamentoService.salvar(orcamento, idSolicitacao)) {
                request.setAttribute("mensagem", "Orçamento enviado com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } else {
                request.setAttribute("mensagem", "Erro ao enviar orçamento!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CadastrarOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
