package capaDatos;

import java.util.ArrayList;

import connection.DataConnectionManager;
import capaEntidades.Color;
import capaEntidades.Consumo;
import capaEntidades.Electrodomesticos;
import capaEntidades.Lavarropas;
import capaEntidades.Television;
import capaDatos.ColorAdaptador;

import java.sql.*;

public class ElectroAdaptador {

	
	
	public static ArrayList<Electrodomesticos> getTodos(){
		
		ArrayList<Electrodomesticos> electros = new ArrayList<Electrodomesticos>();
		
		String sql = "SELECT idElectrodomestico, precioBase, peso, carga, resolucion, sintonizadorTdt, idConsumo, idColor FROM electrodomesticos";
		Statement sentencia=null;
		ResultSet rs=null;
		
		try{
			sentencia = DataConnectionManager.getInstancia().getConn().createStatement();
			rs = sentencia.executeQuery(sql);


			while(rs.next())
			{
				Electrodomesticos el;
				
				Color clr = new ColorAdaptador().getColorById(rs.getInt("idColor"),false);
				Consumo consu = new ConsumoAdaptador().getConsumoPorID(rs.getInt("idConsumo"),false);
				
				if(rs.getDouble("carga") == 0)
				{					
					el = new Television(rs.getFloat("precioBase"),rs.getFloat("peso"), consu.getConsumo(), rs.getFloat("resolucion"), clr.getColor(), rs.getBoolean("sintonizadorTdt"));
				}
				else
				{
					el = new Lavarropas(rs.getFloat("precioBase"),rs.getFloat("peso"), rs.getFloat("carga"), consu.getConsumo(),clr.getColor());					
				}
				el.setIdElectro(rs.getInt("idElectrodomestico"));
				electros.add(el);
				
			}					
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				DataConnectionManager.getInstancia().CloseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}		
		return electros;
	}
		
		
	public static void guardaElectro(Electrodomesticos elec){
		String sql = "INSERT INTO electrodomesticos(precioBase,peso,carga,resolucion,SintonizadorTdt,idConsumo,idColor) values (?,?,?,?,?,?,?)";
		PreparedStatement sentencia = null;
		Connection conn = DataConnectionManager.getInstancia().getConn();
		
		try 
		{
			sentencia = conn.prepareStatement(sql);
			sentencia.setDouble(1, elec.getPrecioBase());
			sentencia.setDouble(2, elec.getPeso());
			
			Color clr = new ColorAdaptador().getColorByNombre(elec.getCol().getColor(),false);
			Consumo consu = new ConsumoAdaptador().getConsumoPorLetra(elec.getConsu().getConsumo(), false);
		
			sentencia.setInt(7,clr.getIdColor());
			sentencia.setInt(6, consu.getIdConsumo());
			
			if(elec instanceof Lavarropas)
			{
				sentencia.setDouble(3,((Lavarropas)elec).getCarga());
			}
			else
			{
				sentencia.setObject(3, null);
			}
			if(elec instanceof Television)
			{
				sentencia.setDouble(4,((Television)elec).getResolucion());
				sentencia.setBoolean(5,((Television)elec).getSintonizadorTdt());
			}
			else
			{
				sentencia.setObject(4, null);
				sentencia.setObject(5, null);
			}
			sentencia.execute(); 

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				DataConnectionManager.getInstancia().CloseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}			
		}		
	}   
	
	 public static void eliminarElectrodomestico(Electrodomesticos electro)
	    {
	    	String sql = "DELETE FROM electrodomesticos WHERE idElectrodomestico=?";
			
			PreparedStatement sentencia = null;
			ResultSet rs = null;
			
			try 
			{			
				sentencia = DataConnectionManager.getInstancia().getConn().prepareStatement(sql);
				sentencia.setInt(1, electro.getIdElectro());
				sentencia.executeUpdate();					
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					if (rs!=null)
					{
						rs.close();
					}
					if (sentencia!=null && !sentencia.isClosed())
					{
						sentencia.close();
					}
					DataConnectionManager.getInstancia().CloseConn();
				}
				catch (SQLException sqle)
				{
					sqle.printStackTrace();
				}
			}
	    }
		
		
}
		
	
	
	

