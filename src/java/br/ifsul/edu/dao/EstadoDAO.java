
package br.ifsul.edu.dao;

import br.ifsul.edu.converters.ConverterOrder;
import br.ifsul.edu.modelo.Estado;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class EstadoDAO<T> extends  GenericDAO<Estado>implements Serializable {

    public EstadoDAO(){
        super();
        super.setPersistentClass(Estado.class);
        // inicializar as ordenações desejadas
        super.getListOrder().add(
                    new Order("id", "ID", "="));
        super.getListOrder().add(
                    new Order("nome", "Estado", "like"));
        // definindo a order inicial
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializar o filtro
        super.setFilter("");
        // inicializando o conversor de ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

    @Override
    public Estado getObjectById(Integer id) {
        Estado obj = super.getEm().find(Estado.class, id);
        //obj.getDisciplinas().size();
        return obj;
    }
}
