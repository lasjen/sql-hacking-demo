package demo.code;

import java.sql.*;
import oracle.jdbc.OracleConnection;
import oracle.sql.ArrayDescriptor;
import oracle.sql.ARRAY;

public class MetricDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int obj_id = 0;
	    int count = 0;
	    
	    EndToEndMetrics etem = null; 
	    
	    Connection conn = null;
	    DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","demod","demo");
	    conn.setAutoCommit(false);
	    
	    etem = new EndToEndMetrics((OracleConnection) conn);
	    etem.setEndToEndMetrics("demo", "somestuff", "lassej");
	    	    
	    // Debug
	    ArrayDescriptor oracleCollection = ArrayDescriptor.createDescriptor("NUMBER_LIST_TYPE",conn);
	    PreparedStatement stmt = conn.prepareStatement(
	         "/* SOURCE CONTROL DEMO */" +
	         "SELECT /*+ LEADING( b1 ) USE_NL( b2 ) */" +
	         "      distinct b1.object_id FROM big_table b1, big_table b2 " +
	         "WHERE b1.object_id=b2.object_id " +
	         "  AND b1.object_id IN (SELECT * FROM TABLE(CAST(? As NUMBER_LIST_TYPE)))");

	    /* EXECUTION 1 ********************************************** */
	    //int[] javaArray1 = { 7369,7566,7782,7788 };      // define our java array

	    int[] javaArray1 = new int[200];

	    for (int i=0;i<200;i++){
	       javaArray1[i] = i*10/3;
	    }

	    ARRAY jdbcArray1 = new ARRAY (oracleCollection, conn, javaArray1);
	                                                        // define our oracle array
	    stmt.setObject(1,jdbcArray1);                      // bind array to bind variable 

	    ResultSet r=stmt.executeQuery();                   // execute the query

	    System.out.println("Found values:");
	    System.out.println("-----------------------------------");

	    while(r.next()){
	       count++;
	       obj_id = r.getInt(1);
	       Thread.currentThread().sleep(100);
	       System.out.println(obj_id);
	    }                                                  // browse the result

	    System.out.println("-----------------------------------");
	    System.out.println("Total: " + count);
	    
	    etem.resetEndToEndMetrics();


	}

}
