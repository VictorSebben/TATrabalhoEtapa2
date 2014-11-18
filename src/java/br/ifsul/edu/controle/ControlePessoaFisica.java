
package br.ifsul.edu.controle;

//import br.ifsul.edu.dao.CidadeDAO;
//import br.ifsul.edu.dao.EstadoDAO;
import br.ifsul.edu.dao.CidadeDAO;
import br.ifsul.edu.dao.PessoaFisicaDAO;
import br.ifsul.edu.dao.TelefoneDAO;
//import br.ifsul.edu.modelo.Cidade;
//import br.ifsul.edu.modelo.Estado;
import br.ifsul.edu.modelo.PessoaFisica;
import br.ifsul.edu.modelo.Telefone;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "controlePessoaFisica")
@ViewScoped
public class ControlePessoaFisica implements Serializable {

    @EJB
    private PessoaFisicaDAO<PessoaFisica> dao;
    private PessoaFisica objeto;
    //private Telefone telefone;

    @EJB
    private CidadeDAO cidadeDao;
    
    @EJB
    private TelefoneDAO telefoneDao;
    
    


    public ControlePessoaFisica() {

    }

    public void adicionarTelefone(){
        Telefone telefone = new Telefone();
        //vi.setQuantidade(getQuantidade());
        //vi.setValorUnitario(getValorUnitario());
        //vi.setValorTotal(getValorUnitario() * getQuantidade());
        //vi.setVenda(getObjeto());
        //vi.setProduto(getProduto());
        //getObjeto().adicionarVendaItem(vi);
        //setQuantidade(null);
        //setValorUnitario(null);
        //setValorTotal(null);
        Util.mensagemInformacao("Telefone adicionado com sucesso");
    }

    public void removerTelefone(Telefone obj){
        getObjeto().removerTelefone(obj);
        Util.mensagemInformacao("Telefone removido com sucesso");
    }
    
    public String listar() {
        return "/pessoafisica/listar?faces-redirect=true";
    }

    public void novo() {
        setObjeto(new PessoaFisica());
    }

    public void salvar() {
        System.out.println("Chamou o salvar");
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
        Util.mensagemInformacao("Sucesso ao recuperar objeto");
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

    public PessoaFisicaDAO<PessoaFisica> getDao() {
        return dao;
    }

    public void setDao(PessoaFisicaDAO<PessoaFisica> dao) {
        this.dao = dao;
    }

    public PessoaFisica getObjeto() {
        return objeto;
    }

    public void setObjeto(PessoaFisica objeto) {
        this.objeto = objeto;
    }

    public TelefoneDAO getTelefoneDao() {
        return telefoneDao;
    }

    public void setTelefoneDao(TelefoneDAO telefoneDao) {
        this.telefoneDao = telefoneDao;
    }

    /*public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }*/

    /**
     * @return the cidadeDao
     */
    public CidadeDAO getCidadeDao() {
        return cidadeDao;
    }

    /**
     * @param cidadeDao the cidadeDao to set
     */
    public void setCidadeDao(CidadeDAO cidadeDao) {
        this.cidadeDao = cidadeDao;
    }


}
