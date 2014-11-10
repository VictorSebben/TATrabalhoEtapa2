package br.ifsul.edu.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author vinicius
 */
@Entity
@Table(name = "telefone")
public class Telefone implements Serializable {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_telefone",
                       sequenceName = "gen_telefone",
                       allocationSize = 1)
    @GeneratedValue(generator = "seq_telefone",
                    strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Length(min = 3, max = 50,
            message = "O número deve estar entre {min} e {max} caracteres")
    @NotEmpty(message = "O número deve ser informado!")
    @Column(name = "numero", nullable = false, length = 50)
    private String numero;
    
    @Length(min = 3, max = 50,
            message = "A descrição deve estar entre {min} e {max} caracteres")
    @Column(name = "descricao", nullable = true, length = 50)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)    
    private Pessoa pessoa;
    
    
    public Telefone() {
    }

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
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.getId());
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
        final Telefone other = (Telefone) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
}
