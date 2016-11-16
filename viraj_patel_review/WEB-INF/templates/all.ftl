<html>
<head><title>Results</title>
</head>
<body style="background-color: #c2f0f0;">
	<h2 style="color:red;">All Movies from the Database</h2>
</body>


    <#if rows??>
      <table border="5">
	   <#list colNames>
          <tr style="background-color:yellow;">
            <#items as col>
              <th>${col}</th>
            </#items>
          </tr>
        </#list>

	        <#list rows>
	          <#items as row>
	            <#list row.getData()>
	              <tr>
	                <#items as r>
	                  <td>${r}</td>
	                </#items>
	             </tr>
	          </#list>
	       </#items>
	    </#list>
	  </table
	</#if>

<#if err??>
<p style="color:red;">${err}</p>
</#if>



<body>

<form action="readServlet" method = "get">
	Enter Movie Name to delete: <input name = "delMovie" type="text">
<input type ="submit" name="deleteMovie" value="Delete Typed Movie">
	</form> 
	
<form action="readServlet" method = "get">
		Enter Movie Name to review: <input name = "movieReview" type="text">
<input type ="submit" name="viewReview" value="Review Typed Movie">
	</form>
	
<form action="readServlet" method = "get">
	Movie Name:<input name="addName" type="text"><br>
	Year: <input name="addYear" type="text"><br>
	Rank: <input name="addRank" type="text"><br>
	Genre: <input name="genreNew" type="text"><br>
<input type="submit" name="addMovie" value="Add to the Database">
</form>
  	
	
</body>
</html>

