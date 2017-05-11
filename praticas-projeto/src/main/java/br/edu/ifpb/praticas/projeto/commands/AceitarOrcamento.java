package br.edu.ifpb.praticas.projeto.commands;

import br.edu.ifpb.praticas.projeto.entidades.Orcamento;
import br.edu.ifpb.praticas.projeto.entidades.SolicitacaoServico;
import br.edu.ifpb.praticas.projeto.entidades.StatusOrcamento;
import br.edu.ifpb.praticas.projeto.entidades.StatusSolicitacao;
import br.edu.ifpb.praticas.projeto.services.impl.OrcamentoServiceBD;
import br.edu.ifpb.praticas.projeto.services.impl.SolicitacaoServicoServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.OrcamentoService;
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
public class AceitarOrcamento implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        OrcamentoService service = new OrcamentoServiceBD();
        Orcamento orcamento = service.getOrcamento(id);

        orcamento.setStatus(StatusOrcamento.FECHADO);

        String url = request.getHeader("referer");
        request.setAttribute("pagina", url);

        if (service.editar(orcamento)) {
            SolicitacaoServicoService sss = new SolicitacaoServicoServiceBD();
            SolicitacaoServico solicitacaoServico = sss.getSolicitacaoServico(orcamento.getSolicitacaoServico().getId());
            solicitacaoServico.setStatus(StatusSolicitacao.CONFIRMADA);
            sss.editar(solicitacaoServico);
            try {
                request.setAttribute("mensagem", "Orçamento aceito com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(AceitarOrcamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                request.setAttribute("mensagem", "Erro ao aceitar orçamento!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(AceitarOrcamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
