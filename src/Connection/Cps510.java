package Connection;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;
 
public class Cps510 {
 
    public static void main(String[] args) {
 
        Connection conn1 = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
 
																						
             String dbURL1 = "jdbc:oracle:thin:u2prajap/09101476@oracle.scs.ryerson.ca:1521:orcl";
			
			conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                System.out.println("Connected with connection #1");
                
           
            }
 
 		
			
		
			
			String query = "select NAME, NUM from TESTJDBC";
							
			try (Statement stmt = conn1.createStatement()) {

			ResultSet rs = stmt.executeQuery(query);

			
			
			while (rs.next()) {
				String name = rs.getString("NAME");
				int num = rs.getInt("NUM");
				System.out.println(name + ", " + num);
			}
			} catch (SQLException e) {
				System.out.println(e.getErrorCode());
			}


 
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
     
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
			

    }
}