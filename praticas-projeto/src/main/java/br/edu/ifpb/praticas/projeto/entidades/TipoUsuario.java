
package br.edu.ifpb.praticas.projeto.entidades;

/**
 *
 * @author Edilva
 */
public enum TipoUsuario {
    
    ADMINISTRADOR("Administrador"),
    PRESTADOR_DE_SERVICO("Prestador de serviço"),
    CLIENTE("Cliente");
    
    private final String descricao;

    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
}
