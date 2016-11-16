<html>
<head>
<title>Movie Review</title>
</head>
<body style="background-color: #c2f0f0;">
	<h2 style="color:red;">Movie Reviews </h2>
</body>

    <#if rows??>
      <table border="5">
	   <#list colNames>
          <tr>
            <#items as col>
              <th >${col}</th>
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
		Movie Name: <br>
		<input name = "movieName" type="text"><br>
		Write a Review: <br>
		<textarea name="reviewText" cols="50" rows="3"></textarea> <br>
		<input type ="submit" name="addReview" value="Add Review">
	</form>
<br>
<br>
	<form action="readServlet" method = "get">
		Movie Reviews to delete: <input name = "deleteName" type="text"><br>
		<input type ="submit" name="deleteReview">
	</form>
	
	
</body>
</html>

