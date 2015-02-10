package capaDatos;

import capaEntidades.Consumo;
import connection.DataConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class ConsumoAdaptador {
	
	public static ArrayList<Consumo> getTodosConsu(){
		
		ArrayList<Consumo> consus = new ArrayList<Consumo>();
		
		String sql="SELECT idConsumo, consumo FROM consumo";
		Statement sentencia=null;
		ResultSet rs=null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().createStatement();
			rs = sentencia.executeQuery(sql);
			
			while(rs.next()) 
			{
				Consumo consu = new Consumo(rs.getString("consumo").charAt(0),rs.getFloat("precio"));
				consu.setIdConsumo(rs.getInt("idConsumo"));
				consus.add(consu);
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
				
		return consus;

	}
	
	public Consumo getConsumoPorID(int idConsumo)
	{
		return this.getConsumoPorID(idConsumo, true);
	}
	
	public Consumo getConsumoPorID(int idConsumo, Boolean CloseConnection)
	{
		String sql="SELECT idConsumo, consumo, precio FROM consumo WHERE idConsumo=?"; //evitamos que se filtre información y que haya posibilidad de hackeo
	
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		Consumo c = null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().prepareStatement(sql);
			sentencia.setInt(1, idConsumo);
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{
				c = new Consumo(rs.getString("consumo").charAt(0),rs.getFloat("precio"));
				c.setIdConsumo(rs.getInt("idConsumo"));			
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
				if (rs!=null)
				{
					rs.close();
				}
				if (sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				if(CloseConnection){
					DataConnectionManager.getInstancia().CloseConn();
				}
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
				
		return c;
	}
	
	
	public Character[] getLetras()
	{
		ArrayList<Character> letrasConsumo = new ArrayList<Character>();
		
		letrasConsumo.add(' ');
				
		String sql="SELECT idConsumo, consumo, precio FROM consumo";
		Statement sentencia=null;
		ResultSet rs=null;
				
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().createStatement();
			rs = sentencia.executeQuery(sql);
			
			while(rs.next())
			{
				letrasConsumo.add(rs.getString("consumo").charAt(0));
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
		
		Character[] letras = letrasConsumo.toArray(new Character[letrasConsumo.size()]);		
		
		return letras;
	}
	
	
	public Consumo getConsumoPorLetra(char letra)
	{
		return this.getConsumoPorLetra(letra, true);
	}
	
	public Consumo getConsumoPorLetra(char letra, boolean CloseConnection){
		
		
		String sql="SELECT idConsumo, consumo, precio FROM consumo WHERE consumo=?"; //evitamos que se filtre información y que haya posibilidad de hackeo
	
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		Consumo c = null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().prepareStatement(sql);
			sentencia.setString(1,String.valueOf(letra));
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{
				c = new Consumo(rs.getString("consumo").charAt(0),rs.getFloat("precio"));
				c.setIdConsumo(rs.getInt("idConsumo"));				
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
				if (rs!=null)
				{
					rs.close();
				}
				if (sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				if(CloseConnection){
					DataConnectionManager.getInstancia().CloseConn();
				}
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
				
		return c;
	}

}
