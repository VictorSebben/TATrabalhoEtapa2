package br.ifsul.edu.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "grupo")
public class Grupo implements Serializable {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_grupo", sequenceName = "gen_grupo",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_grupo", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Length(min = 5, max = 50,
            message = "O nome deve estar entre {min} e {max} caracteres")
    @NotEmpty(message = "O nome deve ser informado!")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    public Grupo() {}

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
