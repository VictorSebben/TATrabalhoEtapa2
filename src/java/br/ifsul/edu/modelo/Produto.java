package br.ifsul.edu.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_produto",
            sequenceName = "seq_produto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_produto",
            strategy = GenerationType.SEQUENCE)
    private Integer id;


    @Length(min = 3, max = 50,
            message = "O nome deve estar entre {min} e {max} caracteres")
    @NotEmpty(message = "O nome deve ser informado!")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Type(type="org.hibernate.type.StringClobType")
    @Lob
    @Column(name = "descricao", nullable = false)
    @Length(min = 5, message = "A descrição deve ter um mínimo de {min} caracteres.")
    @NotEmpty(message = "A descrição deve ser informada")
    private String descricao;

    @Column(name = "preco", nullable = false,
            columnDefinition = "decimal(10,2)")
    @NotNull(message = "Preço deve ser informado")
    private Double preco;

    @Column(name = "estoque", nullable = false)
    @NotNull(message = "Estoque deve ser informado")
    private Integer estoque;

    public Produto() {}

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

    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * @return the estoque
     */
    public Integer getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
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
