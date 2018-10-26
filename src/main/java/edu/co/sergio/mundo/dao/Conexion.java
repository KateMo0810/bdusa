package edu.co.sergio.mundo.dao;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Conexion {
	
	private static Connection CONEXION=null;
    	public static Connection getConnection() throws URISyntaxException{
        String HOST = "ec2-107-20-224-137.compute-1.amazonaws.com:5432"; 
        String DATABASE = "dd64r88209cnf";
        String USER = "vuxurfgwyrfpqw";
        String PASS = "62cd589458fb5b3f149e828722d4456deeb490d26cb27cfae50352b1c1774ced";

//      URI dbUri = new URI(System.getenv("DATABASE_URL"));
//      String username = dbUri.getUserInfo().split(":")[0];
//      String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" +
                HOST + "/" + DATABASE +
                "?user=" + USER  + "&password=" + 
                PASS + "&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    
		   if(CONEXION == null){
			  	try {
					CONEXION = DriverManager.getConnection(dbUrl);
                        	} catch (SQLException e) {
					System.out.println("Connection Failed! Check output console");
					e.printStackTrace();
				}

				
		   }
		   return CONEXION;
	}
	
	public static void closeConnection(){
		 try {
			 if(CONEXION!=null){
				 CONEXION.close();
				 CONEXION=null;
			 }
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	}
	

}
