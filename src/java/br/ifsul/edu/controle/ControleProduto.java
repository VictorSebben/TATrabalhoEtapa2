package br.ifsul.edu.controle;

import br.ifsul.edu.dao.ProdutoDAO;
import br.ifsul.edu.modelo.Produto;
import br.ifsul.edu.modelo.Venda;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controleProduto")
@SessionScoped
public class ControleProduto implements Serializable {
    @EJB
    private ProdutoDAO<Venda> dao;
    private Produto objeto;

    public ControleProduto() {}

    public String listar() {
        return "/produto/listar?faces-redirect=true";
    }

    public void novo() {
        setObjeto(new Produto());
    }

    public void salvar() {
        try {
            if (getObjeto().getId() == null) {
                getDao().persist(getObjeto());
            } else {
                getDao().merge(getObjeto());
            }
            Util.mensagemInformacao("Sucesso ao persitir Produto");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir produto: " + e.getMessage());
        }
    }

    public void editar(Integer id) {
        try {
            setObjeto(getDao().getObjectById(id));
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar produto: " + e.getMessage());
        }
    }

    public void remover(Integer id){
        try {
            setObjeto(getDao().getObjectById(id));
            getDao().remove(getObjeto());
            Util.mensagemInformacao("Produto removido com sucesso");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover Produto: " + e.getMessage());
        }
    }

    /**
     * @return the dao
     */
    public ProdutoDAO<Venda> getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(ProdutoDAO<Venda> dao) {
        this.dao = dao;
    }

    /**
     * @return the objeto
     */
    public Produto getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Produto objeto) {
        this.objeto = objeto;
    }



}
