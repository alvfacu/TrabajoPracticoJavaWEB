<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Entidades.Electrodomestico" %>
<%@ page import="Negocio.ElectrodomesticoLogic;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>LISTADO</title></head>
<body>
	<h1>LISTADO</h1>
	
	<% ArrayList<Electrodomestico> electro = new ArrayList<Electrodomestico>();%>
	<% electro = new ElectrodomesticoLogic().GetAll();%>
	<%="Descripción"%>
	<%="Precio (U$S)"%>
	<%="Color"%>
	<%="Peso (kg)"%>
	<%="Consumo"%>
	<%="Carga (kg)"%>
	<%="Resol. (in)"%>
	<%="TDT"%>
		
 	<% for(int i=0; i<electro.size();i++) { %>
 	<div> 
 		<%= electro.get(i).getTipo() %>        <%= electro.get(i).precioFinal() %>           <%= electro.get(i).getColor().getNombre() %>
 		               <%= electro.get(i).getPeso() %>                <%= electro.get(i).getConsumo().getLetra() %>
 	</div> 
 	<% } %> 
	
</body>
</html>