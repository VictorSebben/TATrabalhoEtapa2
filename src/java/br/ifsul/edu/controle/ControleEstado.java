
package br.ifsul.edu.controle;

import br.ifsul.edu.dao.EstadoDAO;
import br.ifsul.edu.modelo.Estado;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controleEstado")
@SessionScoped
public class ControleEstado implements Serializable {

    @EJB
    private EstadoDAO<Estado> dao;
    private Estado objeto;

    public ControleEstado() {

    }

    public String listar() {
        return "/estado/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Estado();
    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Sucesso ao persitir objeto");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir: " + e.getMessage());
        }
    }

    public void editar(Integer id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + e.getMessage());
        }
    }

    public void remover(Integer id){
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso");
        } catch (Exception e) {
            if (e.getMessage().contains("aborted")) {
                Util.mensagemErro("O estado é referenciado por uma ou mais cidades.");
            }
            else {
                Util.mensagemErro("Erro ao remover objeto: " + e.getMessage());
            }
        }
    }

    public EstadoDAO getDao() {
        return dao;
    }

    public void setDao(EstadoDAO dao) {
        this.dao = dao;
    }

    public Estado getObjeto() {
        return objeto;
    }

    public void setObjeto(Estado objeto) {
        this.objeto = objeto;
    }

}
