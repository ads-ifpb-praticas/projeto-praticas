
package br.edu.ifpb.praticas.projeto.validacao;

import br.edu.ifpb.praticas.projeto.entidades.SolicitacaoServico;
import java.time.LocalDate;

/**
 *
 * @author Edilva
 */
public class ValidadorSolicitacao {
    
    public boolean validar(SolicitacaoServico solicitacao){
        if(solicitacao.getData_inicial().isBefore(LocalDate.now())){
            return false;
        }
        if(solicitacao.getData_final().isBefore(solicitacao.getData_inicial())){
            return false;
        }
        if(solicitacao.getHora_final().getHour() < solicitacao.getHora_inicial().getHour()){
            return false;
        }
        return true;
    }
}
