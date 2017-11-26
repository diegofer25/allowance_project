package Dao;

import Model.Regra;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegraDao {

    public static List<Regra> obterRegrasFilho(int idfilho) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnidadeDePersistencia");
        EntityManager entityManager = factory.createEntityManager();
        List<Regra> regras;
        entityManager.getTransaction().begin();
        regras = entityManager.createNamedQuery("Regra.findByIdfilho", Regra.class).setParameter("idfilho", idfilho).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        if (regras.isEmpty()) {
            return null;
        } else {
            return regras;
        }
    }

    public static void cadastrarRegra(Regra r) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnidadeDePersistencia");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(r);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public static void deletarRegra(int idregra){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnidadeDePersistencia");
        EntityManager entityManager = factory.createEntityManager();
        
        Regra regra = entityManager.createNamedQuery("Regra.findById", Regra.class).setParameter("id", idregra).getSingleResult();
                
        entityManager.getTransaction().begin();
        entityManager.remove(regra);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public static Regra obterRegra(int idregra){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnidadeDePersistencia");
        EntityManager entityManager = factory.createEntityManager();
        
        entityManager.getTransaction().begin();
        Regra r = entityManager.createNamedQuery("Regra.findById", Regra.class).setParameter("id", idregra).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return r;
    }
    
    public static void editarRegra(int idregra, String nomeRegra, int valor, int ocorrencia){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnidadeDePersistencia");
        EntityManager entityManager = factory.createEntityManager();
        
        entityManager.getTransaction().begin();
        Regra r = entityManager.createNamedQuery("Regra.findById", Regra.class).setParameter("id", idregra).getSingleResult();
        r.setNomeregra(nomeRegra);
        r.setValor(valor);
        r.setOcorrencia(ocorrencia);
        entityManager.merge(r);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
