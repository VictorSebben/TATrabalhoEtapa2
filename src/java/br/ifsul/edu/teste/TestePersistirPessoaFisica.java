package br.ifsul.edu.teste;

import br.ifsul.edu.modelo.Cidade;
import br.ifsul.edu.modelo.Estado;
import br.ifsul.edu.modelo.PessoaFisica;
import br.ifsul.edu.modelo.Telefone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPessoaFisica {
    public static void main(String[] args) {
        PessoaFisica obj = new PessoaFisica();
        obj.setNome("Beltrano de Tal");
        obj.setEndereco("Endereço");
        obj.setEmail("beltrano@example.com");
        obj.setBairro("Bairro");
        obj.setCep("01234-567");
        obj.setComplemento("");
        
        obj.setCpf("123123123");
        obj.setRg("123123123");
        
        Telefone tel1 = new Telefone();
        tel1.setNumero("(54) 9876-5432");
        obj.adicionarTelefone(tel1);
        
        Telefone tel2 = new Telefone();
        tel2.setNumero("(54) 2345-6789");
        obj.adicionarTelefone(tel2);
        
        Estado estado = new Estado();
        estado.setNome("Rio Grande do Sul");
        estado.setUf("RS");
        
        Cidade cidade = new Cidade();
        cidade.setNome("Passo Fundo");
        cidade.setEstado(estado);
        
        obj.setCidade(cidade);
        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("TATrab2PULocal");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(estado);
        em.persist(cidade);
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
