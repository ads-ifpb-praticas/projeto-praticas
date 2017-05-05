
package br.edu.ifpb.praticas.projeto.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edilva
 */
public class ProdutorEntityManager {
    
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("praticas-projetoPU");
    
    public static EntityManager criaEntityManager(){
        return factory.createEntityManager();
    }
    
    public static void finaliza(EntityManager entityManager){
        entityManager.close();
    }
        
}
