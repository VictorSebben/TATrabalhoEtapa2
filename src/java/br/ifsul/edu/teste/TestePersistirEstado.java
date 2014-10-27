package br.ifsul.edu.teste;

import br.ifsul.edu.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirEstado {
    public static void main(String[] args) {
        Estado e = new Estado();
        e.setNome("Rio Grande do Sul");
        e.setUf("RS");
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("TATrab2PULocal");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
