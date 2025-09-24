<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div
		style="border: 2px solid black; padding: 10px; width: fit-content; ">
				<a href="Inicio.jsp">Inicio</a> 
		<a href="AgregarSeguro.jsp">Agregar Seguros</a>
		 <a href="ListarSeguro.jsp">ListarSeguros</a> <br>
		<h1>
			<b> Agregar Seguros</b>
			
		
		</h1>
		
		
	<form method="get" action="AgregarSeguro.jsp">
	
			Id Seguro: <br/><br/>
    		Descripción: <input type="text" name="txtNombre" /><br/><br/>
    		Tipo de Seguro: <br/><br/>
    		Costo de Contratación: <input type="text" name="txtCosto" /><br/><br/>
    		Costo Máximo Asegurado: <input type="text" name="txtCostoMaximo" /><br/><br/>
    		
    		<input type="submit" value="Aceptar" name="btnAceptar"/>
		</form>
	</div>
	

</body>
</html>