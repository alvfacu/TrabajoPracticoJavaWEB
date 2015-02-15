<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SYSELEC</title>
</head>

<style>

p.msj {
    font: bold 19px Georgia, serif;
    color: orange;
}

input.btn {
	font: 13px arial;
	font-weight: bold;
}
</style>

<script type="text/javascript">
function enConstruccion()
{
	alert("Proximamente más opciones!");
}
function irAPaginaListado()
{
	location.href = "paginaListado.html";
};
function irAPaginaAlta()
{
	location.href = "paginaAlta.html";
};
</script>

<body>
<h1> Bienvenido al Sistema de Gestion de Electrodomesticos </h1>
<br>
<br>
<fieldset style="width:200px">
<legend style="font-weight: bold; font-size: 15px">Opciones</legend>
<table>
<tr>
<td align="center"><input type="button" value="Agregar nuevo electrodomestico" onclick="irAPaginaAlta()" class="btn" style="color: green;"> </td>
</tr>
<tr> <tr>
<tr>
<td align="center"><input type="button" value="Listado" onclick="irAPaginaListado()" class="btn" style="color: red;"> </td>
</tr>
<tr> <tr>
<tr>
<td align="center"><input type="button" value="Otras opciones" onclick="enConstruccion()" class="btn" style="color: blue;"> </td>
</tr>
</table>
</fieldset>

<br>
<br>
<br>
<p class="msj"> <%=request.getAttribute("mensaje") == null?" " : request.getAttribute("mensaje") %> </p>
<br>
<br>
<br>

<table>
<tr><td align="center" style="font-weight: bold;">VERSIÓN ALFA 1.0 - Desarrollado por: Facundo Alvarez</td></tr>
</table>

</body>
</html>