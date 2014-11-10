
package br.ifsul.edu.controle;

import br.ifsul.edu.dao.CidadeDAO;
import br.ifsul.edu.dao.EstadoDAO;
import br.ifsul.edu.modelo.Cidade;
import br.ifsul.edu.modelo.Estado;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controleCidade")
@SessionScoped
public class ControleCidade implements Serializable {

    @EJB
    private CidadeDAO<Cidade> dao;
    private Cidade objeto;
    private Estado estado;

    @EJB
    private EstadoDAO estadoDao;


    public ControleCidade() {

    }

    public String listar() {
        return "/cidade/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Cidade();
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

//    public void adicionarDisciplinaOferecida(){
//        DisciplinaOferecida d = new DisciplinaOferecida();
//        d.setCargaHoraria(cargaHoraria);
//        d.setDisciplina(disciplina);
//        objeto.adicionarDisciplina(d);
//        disciplina = null;
//        cargaHoraria = null;
//        Util.mensagemInformacao("Disciplina adicionada com sucesso");
//    }

    public CidadeDAO<Cidade> getDao() {
        return dao;
    }

    public void setDao(CidadeDAO<Cidade> dao) {
        this.dao = dao;
    }

    public Cidade getObjeto() {
        return objeto;
    }

    public void setObjeto(Cidade objeto) {
        this.objeto = objeto;
    }

    public EstadoDAO getEstadoDao() {
        return estadoDao;
    }

    public void setEstadoDao(EstadoDAO estadoDao) {
        this.estadoDao = estadoDao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


}
