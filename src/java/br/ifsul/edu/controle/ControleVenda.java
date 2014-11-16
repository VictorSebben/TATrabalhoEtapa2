package br.ifsul.edu.controle;

import br.ifsul.edu.dao.ProdutoDAO;
import br.ifsul.edu.dao.VendaDAO;
import br.ifsul.edu.dao.VendaItensDAO;
import br.ifsul.edu.modelo.Produto;
import br.ifsul.edu.modelo.Venda;
import br.ifsul.edu.modelo.VendaItens;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author victor
 */
@ManagedBean(name = "controleVenda")
@SessionScoped
public class ControleVenda implements Serializable {
    @EJB
    private VendaDAO<Venda> dao;
    private Venda objeto;

    private VendaItens vendaItens;
    private Produto produto;
    @EJB
    private VendaItensDAO vendaItensDAO;
    @EJB
    private ProdutoDAO produtoDAO;

    private Double quantidade;
    private Double valorUnitario;
    private Double valorTotal;

    public ControleVenda() {}

    public String listar() {
        return "/venda/listar?faces-redirect=true";
    }

    public void novo() {
        setObjeto(new Venda());
    }

    public void salvar() {
        try {
            if (getObjeto().getId() == null) {
                getDao().persist(getObjeto());
            } else {
                getDao().merge(getObjeto());
            }
            Util.mensagemInformacao("Sucesso ao persitir objeto");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir: " + e.getMessage());
        }
    }

    public void editar(Integer id) {
        try {
            setObjeto(getDao().getObjectById(id));
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + e.getMessage());
        }
    }

    public void remover(Integer id){
        try {
            setObjeto(getDao().getObjectById(id));
            getDao().remove(getObjeto());
            Util.mensagemInformacao("Objeto removido com sucesso");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: " + e.getMessage());
        }
    }

    public void adicionarVendaItem(){
        VendaItens vi = new VendaItens();
        vi.setQuantidade(getQuantidade());
        vi.setValorUnitario(getValorUnitario());
        vi.setValorTotal(getValorUnitario() * getQuantidade());
        vi.setVenda(getObjeto());
        vi.setProduto(getProduto());
        getObjeto().adicionarVendaItem(vi);
        setQuantidade(null);
        setValorUnitario(null);
        setValorTotal(null);
        Util.mensagemInformacao("Item de venda adicionado com sucesso");
    }

    public void removerVendaItem(VendaItens obj){
        getObjeto().removerVendaItem(obj);
        Util.mensagemInformacao("Item de venda removido com sucesso");
    }

    /**
     * @return the dao
     */
    public VendaDAO<Venda> getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(VendaDAO<Venda> dao) {
        this.dao = dao;
    }

    /**
     * @return the objeto
     */
    public Venda getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Venda objeto) {
        this.objeto = objeto;
    }

    /**
     * @return the vendaItens
     */
    public VendaItens getVendaItens() {
        return vendaItens;
    }

    /**
     * @param vendaItens the vendaItens to set
     */
    public void setVendaItens(VendaItens vendaItens) {
        this.vendaItens = vendaItens;
    }

    /**
     * @return the vendaItensDAO
     */
    public VendaItensDAO getVendaItensDAO() {
        return vendaItensDAO;
    }

    /**
     * @param vendaItensDAO the vendaItensDAO to set
     */
    public void setVendaItensDAO(VendaItensDAO vendaItensDAO) {
        this.vendaItensDAO = vendaItensDAO;
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
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the produtoDAO
     */
    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    /**
     * @param produtoDAO the produtoDAO to set
     */
    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

}
