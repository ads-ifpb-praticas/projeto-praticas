package br.edu.ifpb.praticas.projeto.entidades;

import br.edu.ifpb.praticas.projeto.entidades.Cliente;
import br.edu.ifpb.praticas.projeto.entidades.Orcamento;
import br.edu.ifpb.praticas.projeto.entidades.StatusSolicitacao;
import br.edu.ifpb.praticas.projeto.entidades.TipoServico;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-11T04:19:41")
@StaticMetamodel(SolicitacaoServico.class)
public class SolicitacaoServico_ { 

    public static volatile SingularAttribute<SolicitacaoServico, Cliente> cliente;
    public static volatile SingularAttribute<SolicitacaoServico, LocalTime> hora_final;
    public static volatile ListAttribute<SolicitacaoServico, Orcamento> orcamentos;
    public static volatile SingularAttribute<SolicitacaoServico, LocalDate> data_inicial;
    public static volatile SingularAttribute<SolicitacaoServico, Integer> id;
    public static volatile SingularAttribute<SolicitacaoServico, TipoServico> servico;
    public static volatile SingularAttribute<SolicitacaoServico, LocalTime> hora_inicial;
    public static volatile SingularAttribute<SolicitacaoServico, LocalDate> data_final;
    public static volatile SingularAttribute<SolicitacaoServico, StatusSolicitacao> status;

}