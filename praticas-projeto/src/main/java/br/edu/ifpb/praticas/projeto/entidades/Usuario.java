
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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Edilva
 */
@Entity
@Table(name = "administrador")
@SequenceGenerator(initialValue = 1, allocationSize = 1,
        name = "usuario_sequence_generator",
        sequenceName = "usuario_id_sequence")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence_generator")
    private int id;
    @Column(name = "nome", length = 80, nullable = false)
    private String nome;
    @Column(name = "email", length = 80, nullable = false, unique = true)
    private String email;
    @Column(name = "senha", length = 15, nullable = false)
    private String senha;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", length = 40, nullable = false)
    private TipoUsuario tipo_usuario;

    public Usuario(int id, String nome, String email, String senha, TipoUsuario tipo_suario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo_usuario = tipo_suario;
    }

    public Usuario(String nome, String email, String senha, TipoUsuario tipo_usuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo_usuario = tipo_usuario;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(TipoUsuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.senha);
        hash = 59 * hash + Objects.hashCode(this.tipo_usuario);
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (this.tipo_usuario != other.tipo_usuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", tipo_usuario=" + tipo_usuario + '}';
    }
    
}
