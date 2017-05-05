package br.edu.ifpb.praticas.projeto.entidades;

import br.edu.ifpb.praticas.projeto.entidades.Comentario;
import br.edu.ifpb.praticas.projeto.entidades.TipoServico;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-03T20:06:12")
@StaticMetamodel(PrestadorDeServico.class)
public class PrestadorDeServico_ extends Usuario_ {

    public static volatile SingularAttribute<PrestadorDeServico, String> foto;
    public static volatile SingularAttribute<PrestadorDeServico, Boolean> acesso;
    public static volatile SingularAttribute<PrestadorDeServico, String> cpf;
    public static volatile SingularAttribute<PrestadorDeServico, TipoServico> tipo_servico;
    public static volatile SingularAttribute<PrestadorDeServico, String> documento;
    public static volatile SingularAttribute<PrestadorDeServico, Integer> nota;
    public static volatile ListAttribute<PrestadorDeServico, Comentario> comentarios;

}