/**
 * 
 */
package edu.uga.cs4300.objectlayer;

/**
 * @author viraj
 *
 */
public class Review {

	
	private int id;
	private int movie_id;
	private String review;
	/**
	 * @param id
	 * @param movie_id
	 * @param review
	 */
	public Review(int id, int movie_id, String review) {
		super();
		this.id = id;
		this.movie_id = movie_id;
		this.review = review;
		
		
	}
	
	
	
	public int getId() {
		return id;
		
		
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getMovie_id() {
		return movie_id;
	}
	
	
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	
	public String getReview() {
		return review;
	}
	
	
	public void setReview(String review) {
		this.review = review;
	}



	@Override
	public String toString() {
		return "Review [id=" + id + ", movie_id=" + movie_id + ", review=" + review + "]";
	}
	
	
	
}
