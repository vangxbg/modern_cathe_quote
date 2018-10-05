<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Please create your direct labor cost here!!!</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<script type="text/javascript" src="/js/custom.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
</head>
<body>


<form enctype='application/json' method="post">
	Direct Labor Cost:
	<p><input name='dlcNumber' value='dlcNumber'></p>
	Direct Labor Cost Revision:
	<p><input name='dlcRevision' value='dlcRevision'></p>
	<br></br>
	Product Description:
	<p><input name='pDescription' value='pDescription'></p>
	Product Name:
	<p><input name='pName' value='pName'></p>
	Product Number:
	<p><input name='pNumber' value='pNumber'></p>
	Product Revision:
	<p><input name='pRevision' value='pRevision'></p>
	<br></br>
	Manufacturing Procedure Count:
	<p><input name='mpCount' value='2'></p>
	<br></br>
	Manufacturing Procedure 1 Name:
	<p><input name='mpName1' value='mp1Name'></p>
	Manufacturing Procedure 1 Time Required:
	<p><input name='mpTimeRequired1' value='20'></p>
	Employee Type 1 Title:
	<p><input name='etTitle1' value='et1Title'></p>
	Employee Type 1 Pay Rate:
	<p><input name='etPayRate1' value='10'></p>
	<br></br>
	Manufacturing Procedure 2 Name:
	<p><input name='mpName2' value='mp2Name'></p>
	Manufacturing Procedure 2 Time Required:
	<p><input name='mpTimeRequired2' value='50'></p>
	Employee Type 2 Title:
	<p><input name='etTitle2' value='et2Title'></p>
	Employee Type 2 Pay Rate:
	<p><input name='etPayRate2' value='20'></p>
	<input type="submit" value="Submit">
</form>


</body>
</html>