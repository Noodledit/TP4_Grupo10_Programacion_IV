<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="dao.Conexion" %>
<%@ page import="dao.TipoSeguroDAO" %>
<%@ page import="dominio.TipoSeguro" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Seguro</title>
</head>
<body>

<div style="border: 2px solid black; padding: 10px; width: fit-content;">
    <a href="Inicio.jsp">Inicio</a>
    <a href="AgregarSeguro.jsp">Agregar Seguros</a>
    <a href="ListarSeguro.jsp">Listar Seguros</a> <br>

    <h1><b>Agregar Seguros</b></h1>
<% 
    Connection conn = Conexion.getConnection(); 
    PreparedStatement psId = conn.prepareStatement(
        "SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_NAME = 'seguros' AND TABLE_SCHEMA = 'SegurosGroup'"
    );
    ResultSet Id = psId.executeQuery();
    int nuevoId = 0;
    
    if(Id.next()){
        nuevoId = Id.getInt(1);
    }
    
    // Obtener los tipos de seguro desde la base de datos
    TipoSeguroDAO tipoSeguroDAO = new TipoSeguroDAO();
    List<TipoSeguro> tiposSeguro = tipoSeguroDAO.getAll();
%>    
    
    Id Seguro: <%= nuevoId %><br><br/>
    
    <form method="post" action="AgregarSeguroServlet">
        Descripción:
        <input type="text" name="txtNombre" /><br/><br/>

        Tipo de Seguro:
        <select name="txtTipo">
            <option value="">-- Seleccione un tipo --</option>
            <% for (TipoSeguro tipo : tiposSeguro) { %>
                <option value="<%= tipo.getIdTipo() %>"><%= tipo.getDescripcion() %></option>
            <% } %>
        </select><br/><br/>
        

        Costo de Contratación:
        <input type="text" name="txtCosto" /><br/><br/>

        Costo Máximo Asegurado:
        <input type="text" name="txtCostoMaximo" /><br/><br/>

        <input type="submit" value="Aceptar" name="btnAceptar"/>
    </form>
</div>


<%
    // Cerrar recursos
    if (Id != null) Id.close();
    if (psId != null) psId.close();
    if (conn != null) conn.close();
%>
</body>
</html>