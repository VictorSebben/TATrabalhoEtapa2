package br.ifsul.edu.controle;

import br.ifsul.edu.dao.MarcaDAO;
import br.ifsul.edu.modelo.Marca;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author victor
 */
@ManagedBean(name = "controleMarca")
@SessionScoped
public class ControleMarca implements Serializable {
    @EJB
    private MarcaDAO<Marca> dao;
    private Marca objeto;

    public ControleMarca() {}

    public String listar() {
        return "/marca/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Marca();
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
            Util.mensagemErro("Erro ao remover objeto: " + e.getMessage());
        }
    }

    public MarcaDAO getDao() {
        return dao;
    }

    public void setDao(MarcaDAO dao) {
        this.dao = dao;
    }

    public Marca getObjeto() {
        return objeto;
    }

    public void setObjeto(Marca objeto) {
        this.objeto = objeto;
    }

}
