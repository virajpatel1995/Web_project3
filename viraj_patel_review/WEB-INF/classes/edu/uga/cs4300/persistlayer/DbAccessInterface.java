
package edu.uga.cs4300.persistlayer;

import java.sql.Connection;
import java.sql.ResultSet;


/**
 * @author viraj
 *
 */

// defining the prototype that implemented in DbAccessImpl.java

public interface DbAccessInterface {
	
	
	public static Connection connect() {
		return null;
	}
//........................................................................................

	public static ResultSet retrieve (Connection con, String query) {
		return null;
	}
//........................................................................................

	public void disconnect(Connection con);
                            
//........................................................................................

	

} // end of DbAccessInterface
