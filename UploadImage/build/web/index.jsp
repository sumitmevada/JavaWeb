<%-- 
    Document   : index.jsp
    Created on : 6 Oct, 2017, 4:29:30 PM
    Author     : ubuntu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>How to upload image in folder & path in database using Serlet,JSP</title>
</head>
<body>
<form action="FileUpload" method="post" enctype="multipart/form-data"> 
<center>
<h1>How to upload image in folder & path in database using Serlet,JSP</h1>
<table>
<tr><td>Roll No.:</td><td><input type="text" name="s_rollno" /></td></tr>
<tr><td>First Name:</td><td><input type="text" name="s_first" /></td></tr>    
<tr><td>Last Name:</td><td><input type="text" name="s_last" /></td></tr>
<tr><td>Gender:</td><td><input type="radio" name="gender" value="male" checked> Male<input type="radio" name="gender" value="female">Female</td></tr>   
 <tr><td>Email:</td><td><input type = "text" name="s_email" ></td></tr>   
 <tr><td>Mobile No:</td><td><input type="text" name="s_mobile"></td></tr>  
 <tr><td>File Upload:</td><td><input type="file" name="image"></td></tr>    
<tr><td></td><td><input type="submit" value="Submit"/></td></tr>  
</table>  
</center>
</form> 
</body></html>
