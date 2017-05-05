
package br.edu.ifpb.praticas.projeto.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "orcamento")
@SequenceGenerator(initialValue = 1, allocationSize = 1,
        name = "orcamento_sequence_generator",
        sequenceName = "orcamento_id_sequence")
public class Orcamento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcamento_sequence_generator")
    private int id;
    @OneToOne
    private PrestadorDeServico prestadorDeServico;
    @ManyToOne
    @JoinColumn(name = "solicitacaoServico_id", referencedColumnName = "id")
    private SolicitacaoServico solicitacaoServico;
    @Column(name = "descricao", length = 200)
    private String descricao;
    private double valor;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 30, nullable = false)
    private StatusOrcamento status;

    public Orcamento(int id, PrestadorDeServico prestadorDeServico, SolicitacaoServico solicitacaoServico, String descricao, double valor, StatusOrcamento status) {
        this.id = id;
        this.prestadorDeServico = prestadorDeServico;
        this.solicitacaoServico = solicitacaoServico;
        this.descricao = descricao;
        this.valor = valor;
        this.status = status;
    }

    public Orcamento(PrestadorDeServico prestadorDeServico, String descricao, double valor, StatusOrcamento status) {
        this.prestadorDeServico = prestadorDeServico;
        this.descricao = descricao;
        this.valor = valor;
        this.status = status;
    }

    public Orcamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PrestadorDeServico getPrestadorDeServico() {
        return prestadorDeServico;
    }

    public void setPrestadorDeServico(PrestadorDeServico prestadorDeServico) {
        this.prestadorDeServico = prestadorDeServico;
    }

    public SolicitacaoServico getSolicitacaoServico() {
        return solicitacaoServico;
    }

    public void setSolicitacaoServico(SolicitacaoServico solicitacaoServico) {
        this.solicitacaoServico = solicitacaoServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public StatusOrcamento getStatus() {
        return status;
    }

    public void setStatus(StatusOrcamento status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.prestadorDeServico);
        hash = 71 * hash + Objects.hashCode(this.solicitacaoServico);
        hash = 71 * hash + Objects.hashCode(this.descricao);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.status);
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
        final Orcamento other = (Orcamento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.prestadorDeServico, other.prestadorDeServico)) {
            return false;
        }
        if (!Objects.equals(this.solicitacaoServico, other.solicitacaoServico)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Orcamento{" + "id=" + id + ", prestadorDeServico=" + prestadorDeServico + ", solicitacaoServico=" + solicitacaoServico + ", descricao=" + descricao + ", valor=" + valor + ", status=" + status + '}';
    }
    
    
    
}
