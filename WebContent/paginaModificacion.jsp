<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidades.Electrodomestico" %>
<%@ page import="Entidades.Lavarropas" %>
<%@ page import="Entidades.Television" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar nuevo electrodomestico</title>
</head>
<script type="text/javascript">
function volverPaginaPpal()
{
	location.href = "index.jsp";
}

</script>

<body>
<h1>Modificacion de Electrodomestico</h1>

<% Electrodomestico elec = (Electrodomestico)request.getAttribute("electro");%>

<form action="modificar" method="post" name="alta" >

<p style="color:blue;font-weight: bold"> Ingrese los datos requeridos para agregar nuevo electrodomestico:</p> 

<fieldset style="width:320px">
<legend style="font-weight: bold">Datos del electrodomestico</legend>
<div>
<table>
<tr>
<td><input type="hidden" name="idElec" value="<%=elec.getId()%>"></td>
<td> Tipo: </td>
<td> <input name="tipo" id="tipo" value="<%=elec.getTipo()%>" disabled align="left"> </td>
</tr>
<tr> 
<td align="center"> Precio base: </td>
<td><input type="text" name="base" id="base" value="<%=elec.getPrecio()%>" > </td>
</tr>
<tr>
<td align="center"> Color: </td>
<td> 
<select name="cmbColor">
	<option value="Blanco" <%=elec.getColor().getNombre().charAt(0)=='B'?"selected":" "%>>Blanco</option>
  	<option value="Negro" <%=elec.getColor().getNombre().charAt(0)=='N'?"selected":" "%>>Negro</option>
  	<option value="Rojo" <%=elec.getColor().getNombre().charAt(0)=='R'?"selected":" "%>>Rojo</option>
  	<option value="Azul" <%=elec.getColor().getNombre().charAt(0)=='A'?"selected":" "%>>Azul</option>
  	<option value="Gris" <%=elec.getColor().getNombre().charAt(0)=='G'?"selected":" "%>>Gris</option>
</select> 
</td> 
</tr>
<tr> 
<td align="center"> Peso: </td>
<td><input type="text" name="peso" id="base" value="<%=elec.getPeso()%>"> </td>
</tr>
<tr> 
<td align="center"> Consumo energetico: </td>
<td> 
<select name="cmb">
	<option value="A" <%=elec.getConsumo().getLetra()=='A'?"selected":" "%>>A</option>
  	<option value="B" <%=elec.getConsumo().getLetra()=='B'?"selected":" "%>>B</option>
  	<option value="C" <%=elec.getConsumo().getLetra()=='C'?"selected":" "%>>C</option>
  	<option value="D" <%=elec.getConsumo().getLetra()=='D'?"selected":" "%>>D</option>
  	<option value="E" <%=elec.getConsumo().getLetra()=='E'?"selected":" "%>>E</option>
  	<option value="F" <%=elec.getConsumo().getLetra()=='F'?"selected":" "%>>F</option>
</select> 
</td>
</tr>
</table>
</div>

<% if(elec instanceof Entidades.Lavarropas) { %>
	<div id="lavarropas" style="display: none">
	<table>
	<tr>
	<td align="center"> Carga: </td>
	<td><input type="text" name="carga" id="carga" value="<%=((Lavarropas)elec).getCarga()%>" ></td> 
	</tr>
	</table>
	</div>
<% } %>
<% if (elec instanceof Television) { %>
	<div id="television" style="display: none">
	<table>
	<tr>
	<td align="center"> Resolucion: </td>
	<td><input type="text" name="resol" id="resol" value="<%=((Television)elec).getResolucion()%>"></td> 
	</tr>
	<tr>
	<td align="center"> <input type="checkbox" name="tdt" id="tdt" <%=(((Television)elec).isSintonizador_TDT())?"checked":" "%>>Sintonizador TDT</td> 
	</tr>
	</table>
	</div>
<% } %>
<table style="margin: 0;">
<tr>
<td align="center" width=300> <input type="button" value="Volver al inico" onclick="volverPaginaPpal()" style="color: red;font-size: 12px;font-weight: bold;"> </td>
<td align="center" width=100><input type="submit" value="Modificar" id="modificar" style="color: green;font-size: 12px; font-weight: bold;"></td>
</tr>
</table>
</fieldset>
</form>
</body>
</html>