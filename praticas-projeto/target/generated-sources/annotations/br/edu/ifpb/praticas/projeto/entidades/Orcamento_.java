package br.edu.ifpb.praticas.projeto.entidades;

import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import br.edu.ifpb.praticas.projeto.entidades.SolicitacaoServico;
import br.edu.ifpb.praticas.projeto.entidades.StatusOrcamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-03T20:06:12")
@StaticMetamodel(Orcamento.class)
public class Orcamento_ { 

    public static volatile SingularAttribute<Orcamento, PrestadorDeServico> prestadorDeServico;
    public static volatile SingularAttribute<Orcamento, Double> valor;
    public static volatile SingularAttribute<Orcamento, Integer> id;
    public static volatile SingularAttribute<Orcamento, SolicitacaoServico> solicitacaoServico;
    public static volatile SingularAttribute<Orcamento, String> descricao;
    public static volatile SingularAttribute<Orcamento, StatusOrcamento> status;

}