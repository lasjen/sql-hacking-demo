package demo.code;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import oracle.jdbc.OracleConnection;

@Component
public class EndToEndMetrics {
	private final Connection connection;
	
	@Autowired
	public EndToEndMetrics(Connection connection) {
		this.connection = connection;
	}
	
	public boolean setEndToEndMetrics(String mod, String act, String client_info) {
		boolean set_ok = true;
		String metrics [] = null;
		
		try {

		    metrics  = new String[OracleConnection.END_TO_END_STATE_INDEX_MAX];
		    metrics[OracleConnection.END_TO_END_ACTION_INDEX] = act;
		    metrics[OracleConnection.END_TO_END_MODULE_INDEX] = mod;
		    metrics[OracleConnection.END_TO_END_CLIENTID_INDEX] = client_info;
		    
		    ((OracleConnection) connection).setEndToEndMetrics(metrics, (short) 0);
			
		} catch (Exception e) {
			set_ok = false;
		}
		return set_ok;
	}
	
	public boolean resetEndToEndMetrics() {
		return setEndToEndMetrics("","",""); 
	}

}
