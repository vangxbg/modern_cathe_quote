<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>test page</title>

</head>
<body>
<h1>Test Page</h1>
 Welcome ${name}
<header>One</header>
<form action="/directLaborCosts" method="get">
  number:<br>
  <input type="text" name="number"><br>
  revision:<br>
  <input type="text" name="revision"><br>
  productDescription:<br>
  <input type="text" name="productDescription"><br>
  productName:<br>
  <input type="text" name="productName"><br>
  productNumber:<br>
  <input type="text" name="productNumber"><br>
  productRevision:<br>
  <input type="text" name="productRevision"><br>
  mPRCount:<br>
  <input type="text" name="mPRCount"><br>
  manufacturingProcedureRecordName0:<br>
  <input type="text" name="manufacturingProcedureRecordName0"><br>
  manufacturingProcedureRecordTimeRequired0:<br>
  <input type="text" name="manufacturingProcedureRecordTimeRequired0"><br>
  manufacturingProcedureRecordName1:<br>
  <input type="text" name="manufacturingProcedureRecordName1"><br>
  manufacturingProcedureRecordTimeRequired1:<br>
  <input type="text" name="manufacturingProcedureRecordTimeRequired1"><br>
  employeeTypeRecordTitle0:<br>
  <input type="text" name="employeeTypeRecordTitle0"><br>
  employeeTypeRecordPayRate0:<br>
  <input type="text" name="employeeTypeRecordPayRate0"><br>
  employeeTypeRecordTitle1:<br>
  <input type="text" name="employeeTypeRecordTitle1"><br>
  employeeTypeRecordPayRate1:<br>
  <input type="text" name="employeeTypeRecordPayRate1"><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>