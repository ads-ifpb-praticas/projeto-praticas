package br.edu.ifpb.praticas.projeto.entidades;

import br.edu.ifpb.praticas.projeto.entidades.Cliente;
import br.edu.ifpb.praticas.projeto.entidades.PrestadorDeServico;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-03T20:06:12")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, PrestadorDeServico> prestador_de_servico;
    public static volatile SingularAttribute<Comentario, Cliente> cliente;
    public static volatile SingularAttribute<Comentario, Long> id;
    public static volatile SingularAttribute<Comentario, String> comentario;

}