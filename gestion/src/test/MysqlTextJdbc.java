package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Connexion à la base de connée en utilisant la méthode JDBC Mysql
public class MysqlTextJdbc {

	public static void main(String[] args) {
		// teste
		Connection connexion = null;
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/commandes?serverTimezone=UTC", "eni", "java");
			
			System.out.println(connexion);

            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion.close();
        } catch (Exception ex) {
            // gérer les erreurs
        	System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
            System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
        }
		System.out.println("Connexion réussie");
	}
	
}
