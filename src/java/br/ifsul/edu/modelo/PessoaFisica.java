package br.ifsul.edu.modelo;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "pessoafisica")
public class PessoaFisica extends Pessoa implements Serializable {

    /*@Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_pessoafisica",
                       sequenceName = "gen_pessoafisica",
                       allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoafisica",
                    strategy = GenerationType.SEQUENCE)
    private Integer id;
    */
    
    @Length(min = 3, max = 50,
            message = "O RG deve estar entre {min} e {max} caracteres")
    @NotEmpty(message = "O RG deve ser informado!")
    @Column(name = "RG", nullable = false, length = 50)
    private String rg;
    
    @Length(min = 3, max = 50,
            message = "O CPF deve estar entre {min} e {max} caracteres")
    @NotEmpty(message = "O CPF deve ser informado!")
    @Column(name = "cpf", nullable = false, length = 50)
    private String cpf;
    
    public PessoaFisica() {
        super();
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
