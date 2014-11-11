package br.ifsul.edu.dao;

import br.ifsul.edu.converters.ConverterOrder;
import br.ifsul.edu.modelo.VendaItens;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author victor
 * @param <T>
 */
@Stateful
public class VendaItensDAO<T> extends GenericDAO<VendaItens> implements Serializable {
    public VendaItensDAO() {
        super();
        super.setPersistentClass(VendaItens.class);
        // inicializar as ordenações desejadas
        super.getListOrder().add(
                    new Order("id", "ID", "="));
        super.getListOrder().add(
                    new Order("venda.dataVenda", "Venda", "like"));
        // definindo a order inicial
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializar o filtro
        super.setFilter("");
        // inicializando o conversor de ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

    @Override
    public VendaItens getObjectById(Integer id) {
        VendaItens obj = super.getEm().find(VendaItens.class, id);
        //obj.getMarcas().size();
        return obj;
    }
}
