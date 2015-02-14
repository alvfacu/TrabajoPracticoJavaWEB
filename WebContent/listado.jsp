<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Entidades.Electrodomestico" %>
<%@ page import="Negocio.ElectrodomesticoLogic;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Listado de Electrodomésticos</title>
</head>
<script type="text/javascript">
function volverPagListado(){
	location.href  = "paginaListado.html";
}

function volverPagPrincipal(){
	location.href = "paginaPrincipal.html";
}

</script>

<body>
	<h1 style="font-style: 2 ;color: blue;">LISTADO</h1>
	
	<% ArrayList<Electrodomestico> electro = (ArrayList<Electrodomestico>)request.getAttribute("electros");%>
 
<table border="1" bordercolor="Blue">
 <tr style="font-weight: bold;">
  	<td> Descripción </td>
	<td> Precio (U$S) </td>
	<td> Color </td>
	<td> Peso (kg) </td>
	<td> Consumo	</td>
	<td> Carga (kg) </td>
	<td> Resol. (in)	</td>
	<td> TDT	</td>
 </tr>
 <% for(int i=0; i<electro.size();i++) { %>
 <tr>
 		<td align="center"> <%= electro.get(i).getTipo() %> </td>
 		<td align="center"> <%= electro.get(i).precioFinal() %> </td>
 		<td align="center"> <%= electro.get(i).getColor().getNombre() %> </td>
 		<td align="center"> <%= electro.get(i).getPeso() %> </td>
 		<td align="center"> <%= electro.get(i).getConsumo().getLetra() %> </td>
 		<td align="center"> <% if(electro.get(i) instanceof Entidades.Lavarropas) 
 								{ %> <%= ((Entidades.Lavarropas)electro.get(i)).getCarga() %> 
 								<% } else { %>
 								<%="" %> <% } %> </td>
 		<td align="center"> <% if(electro.get(i) instanceof Entidades.Television) 
 								{ %> <%= ((Entidades.Television)electro.get(i)).getResolucion() %> 
 								<% } else { %>
 								<%="" %> <% } %></td>
 		<td align="center"> <% if(electro.get(i) instanceof Entidades.Television) 
 								{ %> <%= ((Entidades.Television)electro.get(i)).getTDT() %> 
 								<% } else { %>
 								<%="" %> <% } %></td>
  </tr>
 <% } %> 
</table>
<br>
<table>
<tr>
<td><input type="button" value="Definir otros criterios" style="color: purple;" onClick="volverPagListado()"></td>
<td><input type="button" value="Volver a página principal" style="color: red;" onClick="volverPagPrincipal()"></td>
</tr>
</table>
</body>
</html>