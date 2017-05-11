
package br.edu.ifpb.praticas.projeto.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author Edilva
 */
@Entity
@Table(name = "cliente")
public class Cliente extends Usuario implements Serializable{
    
    @Column(name = "cpf", length = 15, nullable = false, unique = true)
    private String cpf;
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;
    @Column(name = "foto")
    @Lob
    private String foto;
    @Embedded
    private Endereco endereco;

    public Cliente(String cpf, String telefone, String foto, Endereco endereco, String nome, String email, String senha, TipoUsuario tipoUsuario) {
        super(nome, email, senha, tipoUsuario);
        this.cpf = cpf;
        this.telefone = telefone;
        this.foto = foto;
        this.endereco = endereco;
    }

    public Cliente(String cpf, String telefone, String foto, Endereco endereco, int id, String nome, String email, String senha, TipoUsuario tipoUsuario) {
        super(id, nome, email, senha, tipoUsuario);
        this.cpf = cpf;
        this.telefone = telefone;
        this.foto = foto;
        this.endereco = endereco;
    }

    public Cliente() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.cpf);
        hash = 17 * hash + Objects.hashCode(this.telefone);
        hash = 17 * hash + Objects.hashCode(this.foto);
        hash = 17 * hash + Objects.hashCode(this.endereco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + super.toString() + "cpf=" + cpf + ", telefone=" + telefone + ", foto=" + foto + ", endereco=" + endereco + '}';
    }

    
    
}
