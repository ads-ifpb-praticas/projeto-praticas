
package br.edu.ifpb.praticas.projeto.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Edilva
 */
@Entity
@Table(name = "solicitacao_servico")
@SequenceGenerator(initialValue = 1, allocationSize = 1,
        name = "solicitacao_servico_sequence_generator",
        sequenceName = "solicitacao_servico_id_sequence")
public class SolicitacaoServico implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "solicitacao_servico_sequence_generator")
    private int id;
    @Column(name = "servico", length = 40, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoServico servico;
    @Convert(converter = ConvertLocalDate.class)
    private LocalDate data_inicial;
    @Convert(converter = ConvertLocalDate.class)
    private LocalDate data_final;
    @Convert(converter = ConvertLocalTime.class)
    private LocalTime hora_inicial;
    @Convert(converter = ConvertLocalTime.class)
    private LocalTime hora_final;
    @OneToOne
    private Cliente cliente;
    @Column(name = "status", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusSolicitacao status;
    @OneToMany(mappedBy = "solicitacaoServico", cascade = CascadeType.ALL)
    private List<Orcamento> orcamentos = new ArrayList<>();
            
    public SolicitacaoServico(int id, TipoServico servico, LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, LocalTime horaFinal, Cliente cliente, StatusSolicitacao status) {
        this.id = id;
        this.servico = servico;
        this.data_inicial = dataInicial;
        this.data_final = dataFinal;
        this.hora_inicial = horaInicial;
        this.hora_final = horaFinal;
        this.cliente = cliente;
        this.status = status;
    }

    public SolicitacaoServico(TipoServico servico, LocalDate dataInicial, LocalDate dataFinal, LocalTime horaInicial, LocalTime horaFinal, Cliente cliente, StatusSolicitacao status, List<Orcamento> orcamentos) {
        this.servico = servico;
        this.data_inicial = dataInicial;
        this.data_final = dataFinal;
        this.hora_inicial = horaInicial;
        this.hora_final = horaFinal;
        this.cliente = cliente;
        this.status = status;
        this.orcamentos = orcamentos;
    }

    public SolicitacaoServico() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoServico getServico() {
        return servico;
    }

    public void setServico(TipoServico servico) {
        this.servico = servico;
    }

    public LocalDate getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(LocalDate data_inicial) {
        this.data_inicial = data_inicial;
    }

    public LocalDate getData_final() {
        return data_final;
    }

    public void setData_final(LocalDate data_final) {
        this.data_final = data_final;
    }

    public LocalTime getHora_inicial() {
        return hora_inicial;
    }

    public void setHora_inicial(LocalTime hora_inicial) {
        this.hora_inicial = hora_inicial;
    }

    public LocalTime getHora_final() {
        return hora_final;
    }

    public void setHora_final(LocalTime hora_final) {
        this.hora_final = hora_final;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusSolicitacao getStatus() {
        return status;
    }

    public void setStatus(StatusSolicitacao status) {
        this.status = status;
    }

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }
    
    public void addOrcamento(Orcamento orcamento){
        orcamento.setSolicitacaoServico(this);
        this.orcamentos.add(orcamento);
    }
    
    public void removeOrcamento(Orcamento orcamento){
        this.orcamentos.remove(orcamento);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.servico);
        hash = 71 * hash + Objects.hashCode(this.data_inicial);
        hash = 71 * hash + Objects.hashCode(this.data_final);
        hash = 71 * hash + Objects.hashCode(this.hora_inicial);
        hash = 71 * hash + Objects.hashCode(this.hora_final);
        hash = 71 * hash + Objects.hashCode(this.cliente);
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
        final SolicitacaoServico other = (SolicitacaoServico) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.servico != other.servico) {
            return false;
        }
        if (!Objects.equals(this.data_inicial, other.data_inicial)) {
            return false;
        }
        if (!Objects.equals(this.data_final, other.data_final)) {
            return false;
        }
        if (!Objects.equals(this.hora_inicial, other.hora_inicial)) {
            return false;
        }
        if (!Objects.equals(this.hora_final, other.hora_final)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SolicitacaoServico{" + "id=" + id + ", servico=" + servico + ", data_inicial=" + data_inicial + ", data_final=" + data_final + ", hora_inicial=" + hora_inicial + ", hora_final=" + hora_final + ", cliente=" + cliente + ", status=" + status + ", orcamentos=" + orcamentos + '}';
    }

}
