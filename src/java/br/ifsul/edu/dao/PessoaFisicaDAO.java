
package br.ifsul.edu.dao;

import br.ifsul.edu.converters.ConverterOrder;
//import br.ifsul.edu.modelo.Cidade;
import br.ifsul.edu.modelo.PessoaFisica;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class PessoaFisicaDAO<T> extends  GenericDAO<PessoaFisica>implements Serializable {

    public PessoaFisicaDAO(){
        super();
        super.setPersistentClass(PessoaFisica.class);
        // inicializar as ordenações desejadas
        super.getListOrder().add(
                    new Order("id", "ID", "="));
        super.getListOrder().add(
                    new Order("nome", "Nome", "like"));
        // definindo a order inicial
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        // inicializar o filtro
        super.setFilter("");
        // inicializando o conversor de ordem
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));
    }

    @Override
    public PessoaFisica getObjectById(Integer id) {
        PessoaFisica obj = super.getEm().find(PessoaFisica.class, id);
        obj.getTelefones().size();
        return obj;
    }
}
