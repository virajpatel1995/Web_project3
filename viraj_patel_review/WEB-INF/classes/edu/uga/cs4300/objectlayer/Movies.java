/**
 * 
 */
package edu.uga.cs4300.objectlayer;

/**
 * @author viraj
 *
 */

public class Movies {
	
	
		
		private int id;
		private String name;
		private int year;
		private int rank;
		
		
		
		/**
		 * default constructor
		 */
		public Movies() {
			this.id = 0;
			this.name = "";
			this.year = 0;
			this.rank = 0;
		}
		
		
		/**
		 * @param id
		 * @param name
		 * @param year
		 * @param rank
		 * @param review
		 */
		public Movies(int id, String name, int year, int rank, String review) {
			this.id = id;
			this.name = name;
			this.year = year;
			this.rank = rank;
		}


		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}


		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}


		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}


		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}


		/**
		 * @return the year
		 */
		public int getYear() {
			return year;
		}


		/**
		 * @param year the year to set
		 */
		public void setYear(int year) {
			this.year = year;
		}


		/**
		 * @return the rank
		 */
		public int getRank() {
			return rank;
		}


		/**
		 * @param rank the rank to set
		 */
		public void setRank(int rank) {
			this.rank = rank;
		}


		/**
		 * @return the review
		 */
		

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "MovieLogicImpl [id=" + id + ", name=" + name + ", year=" + year + ", rank=" + rank + ",]";
		}
		
		
		
		

	}







