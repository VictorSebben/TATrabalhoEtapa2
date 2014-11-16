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
@ManagedBean(name = "controleVendaItens")
@SessionScoped
public class ControleVendaItens implements Serializable {
    @EJB
    private VendaItensDAO<VendaItens> dao;
    @EJB
    private VendaDAO vendaDAO;
    @EJB
    private ProdutoDAO produtoDAO;

    private VendaItens objeto;
    private Venda venda;
    private Produto produto;

    public ControleVendaItens() {}

    public String listar() {
        return "/vendaItens/listar?faces-redirect=true";
    }

    public void novo() {
        setObjeto(new VendaItens());
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

    /**
     * @return the dao
     */
    public VendaItensDAO<VendaItens> getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(VendaItensDAO<VendaItens> dao) {
        this.dao = dao;
    }

    /**
     * @return the vendaDAO
     */
    public VendaDAO getVendaDAO() {
        return vendaDAO;
    }

    /**
     * @param vendaDAO the vendaDAO to set
     */
    public void setVendaDAO(VendaDAO vendaDAO) {
        this.vendaDAO = vendaDAO;
    }

    /**
     * @return the objeto
     */
    public VendaItens getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(VendaItens objeto) {
        this.objeto = objeto;
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


}
