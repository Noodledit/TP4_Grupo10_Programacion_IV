<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Seguros</title>
</head>
<body>

<div style="border: 2px solid black; padding: 10px; width: fit-content;">
    <a href="Inicio.jsp">Inicio</a>
    <a href="AgregarSeguro.jsp">Agregar Seguros</a>
    <a href="ListarSeguro.jsp">Listar Seguros</a> <br>

    <h1><b>Listar Seguros</b></h1>
<p style="margin: 8px 0; padding: 6px 10px; border: 1px solid #ccc; display: inline-block;">
    Filtro actual: <b>Todos los tipos</b>
</p>

    <form method="get" action="ListarSeguro.jsp">
        Búsqueda por tipo de seguros:
        <select name="idTipo">
            <option value="">-- Todos --</option>
            <option value="1">Seguro de casas</option>
            <option value="2">Seguro de vida</option>
            <option value="3">Seguro de motos</option>
        </select>
        <input type="submit" value="Filtrar" />
    </form>
    <br/>

    <table border="1" cellpadding="6" cellspacing="0">
        <thead>
            <tr>
                <th>ID Seguro</th>
                <th>Descripción Seguro</th>
                <th>Descripción Tipo Seguro</th>
                <th>Costo Contratación</th>
                <th>Costo Máximo Asegurado</th>
            </tr>
        </thead>
       <tbody>
    <tr>
        <td>1</td>
        <td>Es un seguro de salud para intervenciones quirúrgicas de alta complejidad.</td>
        <td>Seguro de casas</td>
        <td>600.0</td>
        <td>15000.0</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Asegura toda la gama de motocicletas de uso particular.</td>
        <td>Seguro de motos</td>
        <td>1200.0</td>
        <td>28000.0</td>
    </tr>
</tbody>

    </table>
</div>

</body>
</html>
