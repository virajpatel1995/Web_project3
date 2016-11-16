package edu.uga.cs4300.persistlayer;

import java.sql.*;


public  class MoviePersistImpl{
	
	String query;
	DbAccessImpl acc = new DbAccessImpl();
	Connection connect;
	
//........................................................................................

	public MoviePersistImpl(){
		 query = "";
		 connect = DbAccessImpl.connect();	
		 
	} // end of MoviePersistImpl
	
//........................................................................................

	public void run(String Query){
		
		try {
			DbAccessImpl.execute(connect, Query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end of run
	
//........................................................................................

	public void closeCon(){
		acc.disconnect(connect);
	} // end of closeCon
	
//........................................................................................
	
	
	
}// end of MoviePersistImpl class