
package unit;

import br.edu.ifpb.praticas.projeto.entidades.Cliente;
import br.edu.ifpb.praticas.projeto.entidades.Endereco;
import br.edu.ifpb.praticas.projeto.entidades.SolicitacaoServico;
import br.edu.ifpb.praticas.projeto.entidades.StatusSolicitacao;
import br.edu.ifpb.praticas.projeto.entidades.TipoServico;
import br.edu.ifpb.praticas.projeto.entidades.TipoUsuario;
import br.edu.ifpb.praticas.projeto.validacao.ValidadorSolicitacao;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Edilva
 */
public class SolicitacaoServicoTeste {
    
    private ValidadorSolicitacao vs = new ValidadorSolicitacao();
    
    @Test
    public void validacao(){
        Endereco endereco = new Endereco("Fulano de Tal", "Centro", "Cajazeiras", "PB");
        Cliente c = new Cliente("223.332.323-44", "(83) 99898-5544", "foto", endereco, "Rafael Almeida", "rafael@gmail.com", "12345", TipoUsuario.CLIENTE);
        SolicitacaoServico solicitacaoServico = new SolicitacaoServico(TipoServico.MECANICA, LocalDate.now(), LocalDate.now().plusDays(2), LocalTime.of(7, 0), LocalTime.of(14, 0), c, StatusSolicitacao.DISPONIVEL);
        Assert.assertTrue(vs.validar(solicitacaoServico));
    }
    
    @Test
    public void dataInicialRetroativa(){
        Endereco endereco = new Endereco("Fulano de Tal", "Centro", "Cajazeiras", "PB");
        Cliente c = new Cliente("223.332.323-44", "(83) 99898-5544", "foto", endereco, "Rafael Almeida", "rafael@gmail.com", "12345", TipoUsuario.CLIENTE);
        SolicitacaoServico solicitacaoServico = new SolicitacaoServico(TipoServico.MECANICA, LocalDate.of(2017, Month.MAY, 8), LocalDate.now().plusDays(2), LocalTime.of(7, 0), LocalTime.of(14, 0), c, StatusSolicitacao.DISPONIVEL);
        Assert.assertFalse(vs.validar(solicitacaoServico));
    }
    
    @Test
    public void dataFinalMenorQueInicial(){
        Endereco endereco = new Endereco("Fulano de Tal", "Centro", "Cajazeiras", "PB");
        Cliente c = new Cliente("223.332.323-44", "(83) 99898-5544", "foto", endereco, "Rafael Almeida", "rafael@gmail.com", "12345", TipoUsuario.CLIENTE);
        SolicitacaoServico solicitacaoServico = new SolicitacaoServico(TipoServico.MECANICA, LocalDate.now().plusDays(2), LocalDate.now(), LocalTime.of(7, 0), LocalTime.of(14, 0), c, StatusSolicitacao.DISPONIVEL);
        Assert.assertFalse(vs.validar(solicitacaoServico));
    }
    
    @Test
    public void horaFinalMenorQueInicial(){
        Endereco endereco = new Endereco("Fulano de Tal", "Centro", "Cajazeiras", "PB");
        Cliente c = new Cliente("223.332.323-44", "(83) 99898-5544", "foto", endereco, "Rafael Almeida", "rafael@gmail.com", "12345", TipoUsuario.CLIENTE);
        SolicitacaoServico solicitacaoServico = new SolicitacaoServico(TipoServico.MECANICA, LocalDate.now(), LocalDate.now().plusDays(2), LocalTime.of(14, 0), LocalTime.of(7, 0), c, StatusSolicitacao.DISPONIVEL);
        Assert.assertFalse(vs.validar(solicitacaoServico));
    }
    
}
