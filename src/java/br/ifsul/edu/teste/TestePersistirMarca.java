package br.ifsul.edu.teste;

import br.ifsul.edu.modelo.Marca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirMarca {
    public static void main(String[] args) {
        Marca m = new Marca();
        m.setNome("Foo Bar");
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("TATrab2PULocal");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
