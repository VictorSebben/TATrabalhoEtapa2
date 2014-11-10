package br.ifsul.edu.teste;

import br.ifsul.edu.modelo.Pessoa;
import br.ifsul.edu.modelo.Telefone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirTelefone {
    public static void main(String[] args) {
        Telefone obj = new Telefone();
        obj.setNumero("(54) 9876-5432");
        
        
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
