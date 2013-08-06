package demo.code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import oracle.jdbc.OracleConnection;

//import javax.sql.DataSource;
//import java.util.List;

public class DemoService {
	private Connection conn;
	private EndToEndMetrics etem;
	private int fetchSize = 10; 
   
	public DemoService() throws Exception{
		conn = OracleConnectionFactory.getConn();
		etem = new EndToEndMetrics((OracleConnection) conn);
	}
	
	public int cntEmpByDeptNo(String deptno) throws SQLException{
		int cnt = 0;
		
		etem.setEndToEndMetrics("demo", "cntEmp", "lassej");
		
		PreparedStatement stmt = conn.prepareStatement(
		         "/* Count Employees By deptno*/ SELECT count(*) FROM employees where department_id = ?");
		
		stmt.setNull(1,Types.NULL);
		
		ResultSet r=stmt.executeQuery();
		
		r.next();
		cnt = r.getInt(1);
		
		etem.resetEndToEndMetrics();
		
		return cnt;
	}
	
	public int cntEmp() throws SQLException{
		int cnt = 0;
		
		etem.setEndToEndMetrics("demo", "cntEmp", "lassej");
		
		PreparedStatement stmt = conn.prepareStatement(
		         "/* Count Employees */ SELECT count(*) FROM employees");
		
		ResultSet r=stmt.executeQuery();
		
		r.next();
		cnt = r.getInt(1);
		
		etem.resetEndToEndMetrics();
		
		return cnt;
	}
	
	public int cntObjects() throws Exception {
		etem.setEndToEndMetrics("demo", "cntObjects", "lassej");
		
		// Debug
	    ArrayDescriptor oracleCollection = ArrayDescriptor.createDescriptor("NUMBER_LIST_TYPE",conn);
	    PreparedStatement stmt = conn.prepareStatement(
	         "/* Count Objects */" +
	         "SELECT /*+ LEADING( b1 ) USE_NL( b2 ) */" +
	         "      distinct b1.object_id FROM big_table b1, big_table b2 " +
	         "WHERE b1.object_id=b2.object_id " +
	         "  AND b1.object_id IN (SELECT * FROM TABLE(CAST(? As NUMBER_LIST_TYPE)))");


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

	    int obj_id = 0;
	    int count = 0;
	    
	    r.setFetchSize(fetchSize);
	    
	    while(r.next()){
	       count++;
	       obj_id = r.getInt(1);
	       Thread.currentThread().sleep(100);
	       System.out.println(obj_id);
	    }                                                  // browse the result

	    System.out.println("-----------------------------------");
	    System.out.println("Total: " + count);
	    
	    etem.resetEndToEndMetrics();
		
		return count;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
