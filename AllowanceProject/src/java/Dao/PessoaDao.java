package Dao;
import Model.Pessoa;
import Model.Regra;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaDao {

    public static void cadastrarPessoa(Pessoa p) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnidadeDePersistencia");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static Pessoa obterPessoa(String email) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnidadeDePersistencia");
        EntityManager entityManager = factory.createEntityManager();
        List<Pessoa> pessoas;
        entityManager.getTransaction().begin();
        pessoas = entityManager.createNamedQuery("Pessoa.findByEmail", Pessoa.class).setParameter("email", email).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        if (pessoas.isEmpty()){
            return null;
        }else{
            return pessoas.get(0);
        }        
    }
    
    public static List<Pessoa> obterFilhos(String email){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnidadeDePersistencia");
        EntityManager entityManager = factory.createEntityManager();
        List<Pessoa> filhos;
        
        entityManager.getTransaction().begin();
        filhos = entityManager.createNamedQuery("Pessoa.findByFilhode", Pessoa.class).setParameter("filhode", obterPessoa(email).getId()).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        if (filhos.isEmpty()){
            return null;
        }else{
            return filhos;
        } 
    }
    public static Pessoa obterFilho(int filhoid){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnidadeDePersistencia");
        EntityManager entityManager = factory.createEntityManager();
        
        entityManager.getTransaction().begin();
        Pessoa filho = entityManager.createNamedQuery("Pessoa.findById", Pessoa.class).setParameter("id", filhoid).getSingleResult();
        entityManager.getTransaction().commit();
        return filho;
    }
    public static void excluirFilho(int idfilho){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnidadeDePersistencia");
        EntityManager entityManager = factory.createEntityManager();
        List<Regra> regras = entityManager.createNamedQuery("Regra.findByIdfilho", Regra.class).setParameter("idfilho", idfilho).getResultList();
        Pessoa filho = entityManager.createNamedQuery("Pessoa.findById", Pessoa.class).setParameter("id", idfilho).getSingleResult();
        entityManager.getTransaction().begin();
        for(Regra regra: regras){
            entityManager.remove(regra);
        }
        entityManager.remove(filho);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
