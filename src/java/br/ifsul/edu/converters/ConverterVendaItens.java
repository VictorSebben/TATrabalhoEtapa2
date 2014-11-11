package br.ifsul.edu.converters;

import br.ifsul.edu.modelo.VendaItens;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author victor
 */
@FacesConverter(value = "converterVendaItens")
public class ConverterVendaItens implements Serializable, Converter {
    @PersistenceContext(unitName = "TATrab2PU")
    private EntityManager em;

    // converte da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null){
            return null;
        }
        return em.find(VendaItens.class, Integer.parseInt(string));
    }
    // converte do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null){
            return null;
        }
        VendaItens obj = (VendaItens) o;
        return obj.getId().toString();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
