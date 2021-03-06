/**
 * 
 */
package test;

import jakarta.persistence.Basic; 
import jakarta.persistence.Entity; 
import jakarta.persistence.EntityManager; 
import jakarta.persistence.EntityManagerFactory; 
import jakarta.persistence.Id; 
import jakarta.persistence.Persistence; 
 
/**
 * @author speen
 *
 */
@Entity 
public class TestJPA { 
    @Id 
    private long clePrimaire; 
     
    @Basic 
    private String message; 
     
    public static void main(String[] args) { 
          EntityManagerFactory fabrique = 
Persistence.createEntityManagerFactory("eni-acces"); 
     
          EntityManager em = fabrique.createEntityManager(); 
          System.out.println(em.getProperties()); 
    } 
}