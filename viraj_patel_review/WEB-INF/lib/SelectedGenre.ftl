<html>
<head><title>Results</title>
</head>
<body>
	<h1>Reviews of </h1>
</body>

    <#if rows??>
      <table border="2">
	   <#list colNames>
          <tr>
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
		Movie to review: <input name = "movieName" type="text"><br>
		Review: <textarea name="reviewText" cols="50" rows="10"></textarea>
		<input type ="submit" name="addReview">
	</form>

	<form action="readServlet" method = "get">
		Movie Reviews to delete: <input name = "deleteName" type="text"><br>
		<input type ="submit" name="deleteReview">
	</form>
	
	
</body>
</html>

