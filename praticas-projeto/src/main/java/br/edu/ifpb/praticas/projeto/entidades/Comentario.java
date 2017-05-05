
package br.edu.ifpb.praticas.projeto.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Edilva
 */
@Entity
@Table(name = "comentario")
@SequenceGenerator(initialValue = 1, allocationSize = 1,
        name = "comentario_sequence_generator",
        sequenceName = "comentario_id_sequence")
public class Comentario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentario_sequence_generator")
    private long id;
    @OneToOne
    private Cliente cliente;
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "prestador_de_servico", referencedColumnName = "id", nullable = false)
    private PrestadorDeServico prestador_de_servico;

    public Comentario(long id, Cliente cliente, String comentario) {
        this.id = id;
        this.cliente = cliente;
        this.comentario = comentario;
    }

    public Comentario(Cliente cliente, String comentario) {
        this.cliente = cliente;
        this.comentario = comentario;
    }

    public Comentario() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public PrestadorDeServico getPrestador_de_servico() {
        return prestador_de_servico;
    }

    public void setPrestador_de_servico(PrestadorDeServico prestador_de_servico) {
        this.prestador_de_servico = prestador_de_servico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.cliente);
        hash = 29 * hash + Objects.hashCode(this.comentario);
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
        final Comentario other = (Comentario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.comentario, other.comentario)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", cliente=" + cliente + ", comentario=" + comentario + ", prestador_de_servico=" + prestador_de_servico + '}';
    }
 
}
