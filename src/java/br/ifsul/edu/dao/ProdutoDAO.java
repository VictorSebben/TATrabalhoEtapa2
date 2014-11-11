package br.ifsul.edu.dao;

import br.ifsul.edu.converters.ConverterOrder;
import br.ifsul.edu.modelo.Produto;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class ProdutoDAO<T> extends GenericDAO<Produto> implements Serializable {
    public ProdutoDAO() {
        super();
        super.setPersistentClass(Produto.class);
        // inicializar as ordenações desejadas
        super.getListOrder().add(
                    new Order("id", "ID", "="));
        super.getListOrder().add(
                    new Order("nome", "Produto", "like"));
        // definindo a order inicial
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializar o filtro
        super.setFilter("");
        // inicializando o conversor de ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

    @Override
    public Produto getObjectById(Integer id) {
        Produto obj = super.getEm().find(Produto.class, id);
        //obj.getVendaItens().size();
        return obj;
    }
}
