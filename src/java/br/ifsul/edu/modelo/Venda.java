package br.ifsul.edu.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author victor
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_venda",
            sequenceName = "seq_venda_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_venda",
            strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_venda", nullable = false)
    @NotNull(message = "A data da venda deve ser informada")
    private Calendar dataVenda;

    @Column(name = "valor", nullable = false,
            columnDefinition = "decimal(10,2)")
    @NotNull(message = "Valor deve ser informado")
    private Double valor;

    @Column(name = "status", nullable = false,
            columnDefinition = "char")
    @NotNull(message = "Status deve ser informado")
    private Character status;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VendaItens> vendaItens = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false)
    @NotNull(message = "A pessoa deve ser informada!")
    private PessoaFisica pessoaFisica;

    public Venda() {}

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
     * @return the dataVenda
     */
    public Calendar getDataVenda() {
        return dataVenda;
    }

    /**
     * @param dataVenda the dataVenda to set
     */
    public void setDataVenda(Calendar dataVenda) {
        this.dataVenda = dataVenda;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void adicionarVendaItem(VendaItens obj){
        obj.setVenda(this);
        this.getVendaItens().add(obj);
    }

    public void removerVendaItem(VendaItens obj){
        if (this.getVendaItens().contains(obj)){
            this.getVendaItens().remove(obj);
        }
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", dataVenda=" + dataVenda + ", valorUnitario=" + valor + '}';
    }

    /**
     * @return the status
     */
    public Character getStatus() {
        return status;
    }

    public String getStatusString() {
        return status == 'A' ? "Em aberto" : "Finalizada";
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Character status) {
        this.status = status;
    }

    /**
     * @return the vendaItens
     */
    public List<VendaItens> getVendaItens() {
        return vendaItens;
    }

    /**
     * @param vendaItens the vendaItens to set
     */
    public void setVendaItens(List<VendaItens> vendaItens) {
        this.vendaItens = vendaItens;
    }

    /**
     * @return the pessoaFisica
     */
    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    /**
     * @param pessoaFisica the pessoaFisica to set
     */
    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

}
