<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Glaucus</title>
</head>
<body>
  <fieldset>
    <legend>Glaucus Logistics</legend>
    <table class="resltTable">
      <tr>
        <th>Counter Value</th>
      </tr>
        <tr>
          <td>${counter}</td>
        </tr>
    </table>
  </fieldset>

</body>
</html>