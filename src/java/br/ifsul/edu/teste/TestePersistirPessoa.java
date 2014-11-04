package br.ifsul.edu.teste;

import br.ifsul.edu.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPessoa {
    public static void main(String[] args) {
        Pessoa obj = new Pessoa();
        obj.setNome("Fulano de Tal");
        obj.setEndereco("Endereço");
        obj.setEmail("fulano@example.com");
        obj.setBairro("Bairro");
        obj.setCep("01234-567");
        obj.setComplemento("");
        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("TATrab2PULocal");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
