package br.ifsul.edu.dao;

import br.ifsul.edu.converters.ConverterOrder;
import br.ifsul.edu.modelo.Venda;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author victor
 */
@Stateful
public class VendaDAO<T> extends GenericDAO<Venda> implements Serializable {
    public VendaDAO() {
        super();
        super.setPersistentClass(Venda.class);
        // inicializar as ordenações desejadas
        super.getListOrder().add(
                    new Order("id", "ID", "="));
        super.getListOrder().add(
                    new Order("dataVenda", "Venda", "like"));
        // definindo a order inicial
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializar o filtro
        super.setFilter("");
        // inicializando o conversor de ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

    @Override
    public Venda getObjectById(Integer id) {
        Venda obj = super.getEm().find(Venda.class, id);
        obj.getVendaItens().size();
        return obj;
    }
}
