package edu.uga.cs4300.boundary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import edu.uga.cs4300.logiclayer.*;

/**
 * Servlet implementation class fetchInfo

 */

@WebServlet("/readServlet")
public class readServlet extends HttpServlet {
	
	
	MovieLogicImpl goServlet = new MovieLogicImpl();
	
private static final long serialVersionUID = 1L;
	
	Configuration cfg = null;
	
	private String templateDir = "/WEB-INF/templates";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init() {
    	// Create your Configuration instance, and specify if up to what FreeMarker
    	// version (here 2.3.25) do you want to apply the fixes that are not 100%
    	// backward-compatible. See the Configuration JavaDoc for details.
    	cfg = new Configuration(Configuration.VERSION_2_3_25);
    	
    	// Specify the source where the template files come from.
		cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);
		
		// Sets how errors will appear.
		// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		
		// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
		cfg.setLogTemplateExceptions(false);
    }
   
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String tbl = "All";
		String DbQ = "";
		
		Map<String, Object> root = new HashMap<>();  //freemarker
		

//........................................................................................
		
		
		if(request.getParameter("genreButton") != null){
			tbl =request.getParameter("genre"); 
			goServlet.getTable(root, tbl, DbQ);
			update(response, root, "movies");
			
			} // main index page genre
		
//........................................................................................
		
		if(request.getParameter("addReview") != null)
		{
			DbQ = "review";
			String movieN= request.getParameter("movieName");
			String reviewForMovie = request.getParameter("reviewText");
			try{
			goServlet.movieToReview(movieN, reviewForMovie); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			goServlet.viewReviews(root, movieN);
			update(response, root, "reviews");
		}  // end of addReview
		
//........................................................................................

		
		if(request.getParameter("viewReview") != null)
		{
			DbQ = "review";
			
			String movieReview = request.getParameter("movieReview");
			goServlet.viewReviews(root, movieReview);
			update(response, root, "reviews");
		} // end of viewReview
		
//........................................................................................

				
		if (request.getParameter("deleteMovie") != null){
			try{
				String delMovie = request.getParameter("delMovie");
				goServlet.movieToDelete(delMovie);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			goServlet.getTable(root, tbl, DbQ);
			update(response, root, "movies");

		 } // end of deleteMovie
		
//........................................................................................

		
		if (request.getParameter("deleteReview") != null){
			String nameReview = request.getParameter("deleteName");
			try{
				goServlet.reviewToDelete(nameReview);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			goServlet.viewReviews(root, nameReview);
			update(response, root, "reviews");
		 } // end of deleteReview
		
//........................................................................................
		
		
		if (request.getParameter("addMovie") != null){
			String name = request.getParameter("addName");
			
			int RANK, YEAR;
			 RANK = Integer.parseInt(request.getParameter("addRank"));
			 YEAR = Integer.parseInt(request.getParameter("addYear"));
			 
			try {
				goServlet.movieToDatabase(RANK, name, YEAR, tbl);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			goServlet.getTable(root, tbl, DbQ);
			update(response, root, "movies");
		} // end of addMovie
		
//........................................................................................

	
} // end of doGet 

//............................................................................................................
//............................................................................................................


	// this will open freemarker file according to the selection 
	
	private void update(HttpServletResponse response, Map<String, Object> root, String type) {

		response.setContentType("text/html");

		try {

			PrintWriter out = response.getWriter();
			Template temp = null;
			
			if(type.equals("movies")){
			temp = cfg.getTemplate("all.ftl");
			}
			if(type.equals("reviews")){
			temp = cfg.getTemplate("SelectedGenre.ftl");
			}

			temp.process(root, out);

		} catch (TemplateException | IOException e) {
			e.printStackTrace();
		}
	} // end of update

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	    
	}
}
