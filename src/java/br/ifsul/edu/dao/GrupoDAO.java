package br.ifsul.edu.dao;

import br.ifsul.edu.converters.ConverterOrder;
import br.ifsul.edu.modelo.Grupo;
import br.ifsul.edu.modelo.Marca;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class GrupoDAO<T> extends GenericDAO<Grupo> implements Serializable {
    public GrupoDAO(){
        super();
        super.setPersistentClass(Grupo.class);
        // inicializar as ordenações desejadas
        super.getListOrder().add(
                    new Order("id", "ID", "="));
        super.getListOrder().add(
                    new Order("nome", "Grupo", "like"));
        // definindo a order inicial
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializar o filtro
        super.setFilter("");
        // inicializando o conversor de ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

    @Override
    public Grupo getObjectById(Integer id) {
        Grupo obj = super.getEm().find(Grupo.class, id);
        //obj.getMarcas().size();
        return obj;
    }
}
