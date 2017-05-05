package br.edu.ifpb.praticas.projeto.entidades;

import br.edu.ifpb.praticas.projeto.entidades.Endereco;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-03T20:06:12")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Usuario_ {

    public static volatile SingularAttribute<Cliente, String> telefone;
    public static volatile SingularAttribute<Cliente, String> foto;
    public static volatile SingularAttribute<Cliente, Endereco> endereco;
    public static volatile SingularAttribute<Cliente, String> cpf;

}