
package br.edu.ifpb.praticas.projeto.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Edilva
 */
@Embeddable
public class Endereco implements Serializable{
    
    @Column(name = "rua", length = 80, nullable = false)
    private String rua;
    @Column(name = "bairro", length = 80, nullable = false)
    private String bairro;
    @Column(name = "cidade", length = 80, nullable = false)
    private String cidade;
    @Column(name = "estado", length = 80, nullable = false)
    private String estado;

    public Endereco(String rua, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" + "rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + '}';
    }
    
    
}
