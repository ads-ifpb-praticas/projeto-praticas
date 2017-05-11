package br.edu.ifpb.praticas.projeto.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Edilva
 */
@Entity
@Table(name = "prestador_de_servico")
public class PrestadorDeServico extends Usuario implements Serializable {

    @Column(name = "cpf", length = 15, nullable = false, unique = true)
    private String cpf;
    @Column(name = "foto")
    @Lob
    private String foto;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_servico", length = 15, nullable = false)
    private TipoServico tipo_servico;
    @Column(name = "documento")
    @Lob
    private String documento;
    @Column(name = "nota")
    private int nota;
    @OneToMany(mappedBy = "prestador_de_servico")
    private List<Comentario> comentarios = new ArrayList<>();
    private boolean acesso;

    public PrestadorDeServico(String cpf, String foto, TipoServico tipoServico, String documento, int nota, String nome, String email, String senha, TipoUsuario tipoUsuario, boolean acesso) {
        super(nome, email, senha, tipoUsuario);
        this.cpf = cpf;
        this.tipo_servico = tipoServico;
        this.acesso = acesso;
    }

    public PrestadorDeServico(String cpf, String foto, TipoServico tipoServico, String documento, int nota, int id, String nome, String email, String senha, TipoUsuario tipoUsuario, List<Comentario> comentarios, boolean acesso) {
        super(id, nome, email, senha, tipoUsuario);
        this.cpf = cpf;
        this.foto = foto;
        this.tipo_servico = tipoServico;
        this.documento = documento;
        this.nota = nota;
        this.comentarios = comentarios;
        this.acesso = acesso;
    }

    public PrestadorDeServico() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public TipoServico getTipo_servico() {
        return tipo_servico;
    }

    public void setTipo_servico(TipoServico tipo_servico) {
        this.tipo_servico = tipo_servico;
    }

    public boolean isAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }

    public void addComentario(Comentario comentario) {
        comentario.setPrestador_de_servico(this);
        this.comentarios.add(comentario);
    }

    public void removeComentario(Comentario comentario) {
        this.comentarios.remove(comentario);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.cpf);
        hash = 89 * hash + Objects.hashCode(this.foto);
        hash = 89 * hash + Objects.hashCode(this.tipo_servico);
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
        final PrestadorDeServico other = (PrestadorDeServico) obj;
        if (this.nota != other.nota) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (this.tipo_servico != other.tipo_servico) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PrestadorDeServico{" + super.toString() + "cpf=" + cpf + ", foto=" + foto + ", tipo_servico=" + tipo_servico + ", documento=" + documento + ", nota=" + nota + ", comentarios=" + comentarios + ", acesso=" + acesso + '}';
    }

}
