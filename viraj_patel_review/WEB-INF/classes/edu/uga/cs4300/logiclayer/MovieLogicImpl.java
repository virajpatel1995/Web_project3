/**
 * 
 */
package edu.uga.cs4300.logiclayer;

import edu.uga.cs4300.persistlayer.MoviePersistImpl;
import edu.uga.cs4300.persistlayer.DbAccessImpl;
import java.sql.*;
import java.util.Map;
import java.util.ArrayList;

/**
 * @author viraj
 *
 */

public class MovieLogicImpl  {
	
	Connection conne;
	DbAccessImpl access = new DbAccessImpl();
	MoviePersistImpl persistClass = new MoviePersistImpl();
	
	public MovieLogicImpl(){
		conne = DbAccessImpl.connect();
		
	} // end of MovieLogicImpl
	
//........................................................................................

	
//this function runs the query to add the movie into the imdb database 
public void movieToDatabase(int Rank, String movieName, int movieYear, String genreCatg) throws SQLException
	{
		String query = "insert into imdb.movies(name, year, rank) values('" + movieName + "','" + movieYear + "','" + Rank + "')";

		persistClass.run(query);
		query = "insert into imdb.movies_genres(movie_id, genre) values(("+ "SELECT id FROM movies WHERE name= '" + movieName + "'), '" + genreCatg + "')";
		persistClass.run(query);
		
	} // end of movieToDatabase 
	
//........................................................................................

public void movieToDelete(String Movie) throws SQLException
	{
		
		
		String query = "DELETE FROM imdb.reviews WHERE movie_id = (SELECT id FROM movies WHERE name= '" + Movie + "')";
		persistClass.run(query);
		String query2 = "DELETE FROM imdb.movies WHERE name= '" + Movie + "'";
		persistClass.run(query2);
		
	} //end of movieToDelete
	
//........................................................................................

public void movieToReview(String Movie, String review) throws SQLException
	{		
		String query = "Insert into reviews(movie_id, review) values(("+ "SELECT id FROM movies WHERE name= '" + Movie + "'),'"+ review + "')";

		persistClass.run(query);

	} // end of movieToReview
	
//........................................................................................

	
public void reviewToDelete(String Movie) throws SQLException
	{		
		String query = "DELETE FROM imdb.reviews WHERE movie_id = (SELECT id FROM movies WHERE name= '" + Movie + "')";
		persistClass.run(query);

	} //end of reviewToDelete
//........................................................................................

		
public class Row {

		private ArrayList<String> data;
		
		public Row(){
			data = new ArrayList<String>();
		}
		
		public void add(String s){ data.add(s); }
		
		public ArrayList<String> getData(){ return data; 
		
		}
	} // end of row

//........................................................................................

	
public void getTable(Map<String, Object> root, String genre, String type) {

		
			String query = " ";

			if(genre.equals("All")){
				query = "SELECT * from imdb.movies";
			}else{
				query = "SELECT * from imdb.movies WHERE id IN (SELECT movie_id FROM movies_genres WHERE genre = '" + genre + "')";
			}

			ResultSet result = DbAccessImpl.retrieve(conne, query);

			try {

				ResultSetMetaData resultMeta = result.getMetaData();

				int numColumns = resultMeta.getColumnCount();

//columns........................................................................
				ArrayList<String> colNames = new ArrayList<>();

				for (int i = 1; i <= numColumns; i++) {

					colNames.add(resultMeta.getColumnName(i));

				}

				root.put("colNames", colNames);

//rows............................................................................
				
				ArrayList<Row> rows = new ArrayList<>();

				while (result.next()) {

					Row r = new Row();

					for (int i = 1; i <= numColumns; i++) {

						String input = result.getString(i);

						if (input == null)
							input = "null";

						r.add(input);
					}

					rows.add(r);

				}

				root.put("rows", rows);

			} catch (SQLException e) {
				System.err.println(e);
			}
		}	// end of getTable

//........................................................................................


public void viewReviews(Map<String, Object> root, String movie) {

	
		String query = " ";
		query = "SELECT * from imdb.reviews WHERE movie_id IN (SELECT id FROM movies WHERE name = '" + movie + "')";


		ResultSet result = DbAccessImpl.retrieve(conne, query);

		try {

			ResultSetMetaData resultMeta = result.getMetaData();

			int numColumns = resultMeta.getColumnCount();

			// getting columns name

			ArrayList<String> colNames = new ArrayList<>();

			for (int i = 1; i <= numColumns; i++) {

				colNames.add(resultMeta.getColumnName(i));

			} // end of for loop

			root.put("colNames", colNames);

			// getting rows

			ArrayList<Row> rows = new ArrayList<>();

			while (result.next()) {

				Row r = new Row();

				for (int i = 1; i <= numColumns; i++) {

					String input = result.getString(i);

					if (input == null)
						input = "null";

					r.add(input);
				}//end of for loop

				rows.add(r);

			}//end of while loop

			root.put("rows", rows);

		} catch (SQLException e) {
			System.err.println(e);
		}
	}

//........................................................................................
	


}
	
	