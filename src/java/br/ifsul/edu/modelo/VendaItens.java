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
import javax.validation.constraints.NotNull;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "venda_itens")
public class VendaItens implements Serializable {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_venda_itens",
            sequenceName = "seq_venda_itens_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_venda_itens",
            strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "quantidade", nullable = false,
            columnDefinition = "decimal(10,2)")
    @NotNull(message = "Quantidade deve ser informada")
    private Double quantidade;

    @Column(name = "valor_unitario", nullable = false,
            columnDefinition = "decimal(10,2)")
    @NotNull(message = "Valor unitário deve ser informado")
    private Double valorUnitario;

    @Column(name = "valor_total", nullable = false,
            columnDefinition = "decimal(10,2)")
    @NotNull(message = "Valor total deve ser informado")
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "venda", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Venda deve ser informada")
    private Venda venda;

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
     * @return the quantidade
     */
    public Double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorUnitario
     */
    public Double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the venda
     */
    public Venda getVenda() {
        return venda;
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final VendaItens other = (VendaItens) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VendaItens{" + "id=" + id + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario + ", valorTotal=" + valorTotal + ", venda=" + venda + '}';
    }

}
