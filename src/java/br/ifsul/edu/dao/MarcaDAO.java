package br.ifsul.edu.dao;

import br.ifsul.edu.converters.ConverterOrder;
import br.ifsul.edu.modelo.Marca;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author victor
 */
@Stateful
public class MarcaDAO<T> extends GenericDAO<Marca> implements Serializable {
    public MarcaDAO(){
        super();
        super.setPersistentClass(Marca.class);
        // inicializar as ordenações desejadas
        super.getListOrder().add(
                    new Order("id", "ID", "="));
        super.getListOrder().add(
                    new Order("marca.nome", "Marca", "like"));
        // definindo a order inicial
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializar o filtro
        super.setFilter("");
        // inicializando o conversor de ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

    @Override
    public Marca getObjectById(Integer id) {
        Marca obj = super.getEm().find(Marca.class, id);
        //obj.getMarcas().size();
        return obj;
    }
}
