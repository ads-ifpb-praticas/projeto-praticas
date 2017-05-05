
package br.edu.ifpb.praticas.projeto.entidades;

/**
 *
 * @author Edilva
 */
public enum TipoServico {
    
    PINTURA("Pintura"),
    HIDRAULICA("Hidráulica"),
    MECANICA("Mecânica"),
    MARCENARIA("Marcenaria"),
    MONTAGEM("Montagem"),
    ALVENARIA("Alvenaria"),
    ELETRICA("Elétrica"),
    REPAROS("Reparos"),
    LIMPEZA("Limpeza");
    
    private final String descricao;

    TipoServico(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
        
}
