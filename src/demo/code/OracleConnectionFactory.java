package demo.code;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionFactory {
	
   public static Connection getConn() throws Exception{
	   	Connection conn = null;
	    DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	    conn = DriverManager.getConnection("jdbc:oracle:thin:@212.18.136.64:1521:ORCL","hr","hr");
	    conn.setAutoCommit(false);
	    
		return conn;
   }

}
