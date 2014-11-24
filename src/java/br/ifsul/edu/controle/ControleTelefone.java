
package br.ifsul.edu.controle;

import br.ifsul.edu.dao.TelefoneDAO;
import br.ifsul.edu.modelo.Pessoa;
import br.ifsul.edu.modelo.Telefone;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controleTelefone")
@SessionScoped
public class ControleTelefone implements Serializable {

    @EJB
    private TelefoneDAO<Telefone> dao;
    private Telefone objeto;
    private Pessoa pessoa;

    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public ControleTelefone() {

    }

    public String listar() {
        return "/telefone/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Telefone();
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

    public TelefoneDAO getDao() {
        return dao;
    }

    public void setDao(TelefoneDAO dao) {
        this.dao = dao;
    }

    public Telefone getObjeto() {
        return objeto;
    }

    public void setObjeto(Telefone objeto) {
        this.objeto = objeto;
    }

}
