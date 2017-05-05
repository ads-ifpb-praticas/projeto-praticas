
package br.edu.ifpb.praticas.projeto.commands;

import br.edu.ifpb.praticas.projeto.entidades.Cliente;
import br.edu.ifpb.praticas.projeto.entidades.SolicitacaoServico;
import br.edu.ifpb.praticas.projeto.entidades.StatusSolicitacao;
import br.edu.ifpb.praticas.projeto.entidades.TipoServico;
import br.edu.ifpb.praticas.projeto.services.impl.SolicitacaoServicoServiceBD;
import br.edu.ifpb.praticas.projeto.services.interfaces.SolicitacaoServicoService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edilva
 */
public class CadastrarSolicitacaoDeServico implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            SolicitacaoServico solicitacao = dadosDaSolicitacao(request);
            SolicitacaoServicoService service = new SolicitacaoServicoServiceBD();
            
            if(service.salvar(solicitacao)){
                request.setAttribute("mensagem", "Solicitação de serviço enviada com sucesso!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }else{
                request.setAttribute("mensagem", "Erro ao enviar solicitação de serviço!");
                request.getRequestDispatcher("paginaDeResposta.jsp").forward(request, response);
            }
        } catch (IOException | ServletException | ParseException ex) {
            Logger.getLogger(CadastrarSolicitacaoDeServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private SolicitacaoServico dadosDaSolicitacao(HttpServletRequest request) throws IOException, ServletException, ParseException {
        SolicitacaoServico solicitacao = new SolicitacaoServico();
        
        if (request.getParameter("tipo_servico") != null) {
            String tipo_servico = request.getParameter("tipo_servico");
            solicitacao.setServico(TipoServico.valueOf(tipo_servico));
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        if (request.getParameter("data_inicial") != null) {
            LocalDate data_inicial = LocalDate.parse(request.getParameter("data_inicial"), formatter);
            solicitacao.setData_inicial(data_inicial);
        }
        
        if (request.getParameter("data_final") != null) {
            LocalDate data_final = LocalDate.parse(request.getParameter("data_final"), formatter);
            solicitacao.setData_final(data_final);
        }

        if (request.getParameter("hora_inicial") != null) {
            LocalTime hora_inicial = LocalTime.parse(request.getParameter("hora_inicial"));
            solicitacao.setHora_inicial(hora_inicial);
        }
        
        if (request.getParameter("hora_final") != null) {
            LocalTime hora_final = LocalTime.parse(request.getParameter("hora_final"));
            solicitacao.setHora_final(hora_final);
        }
        
        Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
        
        solicitacao.setCliente(cliente);
        
        solicitacao.setStatus(StatusSolicitacao.DISPONIVEL);

        return solicitacao;
    }
    
}
