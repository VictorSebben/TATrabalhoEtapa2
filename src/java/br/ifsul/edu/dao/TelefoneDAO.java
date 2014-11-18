
package br.ifsul.edu.dao;

import br.ifsul.edu.converters.ConverterOrder;
import br.ifsul.edu.modelo.Estado;
import br.ifsul.edu.modelo.Telefone;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class TelefoneDAO<T> extends  GenericDAO<Telefone>implements Serializable {

    public TelefoneDAO(){
        super();
        super.setPersistentClass(Telefone.class);
        // inicializar as ordenações desejadas
        super.getListOrder().add(
                    new Order("id", "ID", "="));
        super.getListOrder().add(
                    new Order("numero", "Numero", "like"));
        // definindo a order inicial
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializar o filtro
        super.setFilter("");
        // inicializando o conversor de ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

    @Override
    public Telefone getObjectById(Integer id) {
        Telefone obj = super.getEm().find(Telefone.class, id);
        //obj.getDisciplinas().size();
        
        return obj;
    }
}
