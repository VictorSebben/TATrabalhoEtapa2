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
 * @author vinicius
 */
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
    
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_pessoa",
                       sequenceName = "gen_pessoa",
                       allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa",
                    strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Length(min = 3, max = 50,
            message = "O nome deve estar entre {min} e {max} caracteres")
    @NotEmpty(message = "O nome deve ser informado!")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @Length(min = 3, max = 50,
            message = "O endereço deve estar entre {min} e {max} caracteres")
    @NotEmpty(message = "O endereço deve ser informado!")
    @Column(name = "endereco", nullable = false, length = 50)
    private String endereco;
    
    @Length(min = 3, max = 50,
            message = "O email deve estar entre {min} e {max} caracteres")
    @NotEmpty(message = "O email deve ser informado!")
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    
    @Length(min = 3, max = 50,
            message = "O bairro deve estar entre {min} e {max} caracteres")
    @NotEmpty(message = "O bairro deve ser informado!")
    @Column(name = "bairro", nullable = false, length = 50)
    private String bairro;
    
    @Length(min = 3, max = 50,
            message = "O CEP deve estar entre {min} e {max} caracteres")
    @NotEmpty(message = "O CEP deve ser informado!")
    @Column(name = "cep", nullable = false, length = 50)
    private String cep;
    
    @Column(name = "complemento", nullable = true, length = 50)
    private String complemento;

    public Pessoa() {
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

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }    
}
