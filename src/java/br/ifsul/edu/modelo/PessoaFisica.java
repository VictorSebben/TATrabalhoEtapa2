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
    public PessoaFisica() {
        super();
    }

}
