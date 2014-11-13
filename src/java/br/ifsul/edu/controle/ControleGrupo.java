package br.ifsul.edu.controle;

import br.ifsul.edu.dao.GrupoDAO;
import br.ifsul.edu.modelo.Grupo;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controleGrupo")
@SessionScoped
public class ControleGrupo implements Serializable {
    @EJB
    private GrupoDAO<Grupo> dao;
    private Grupo objeto;

    public ControleGrupo() {}

    public String listar() {
        return "/grupo/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Grupo();
    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Sucesso ao persitir Grupo");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir Grupo: " + e.getMessage());
        }
    }

    public void editar(Integer id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar Grupo: " + e.getMessage());
        }
    }

    public void remover(Integer id){
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Grupo removido com sucesso");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: " + e.getMessage());
        }
    }

    public GrupoDAO getDao() {
        return dao;
    }

    public void setDao(GrupoDAO dao) {
        this.dao = dao;
    }

    public Grupo getObjeto() {
        return objeto;
    }

    public void setObjeto(Grupo objeto) {
        this.objeto = objeto;
    }

}
