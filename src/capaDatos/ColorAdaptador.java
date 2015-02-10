package capaDatos;

import capaEntidades.Color;
import connection.DataConnectionManager;
import java.sql.*;
import java.util.ArrayList;

public class ColorAdaptador {
	

	public static ArrayList<Color> getColores(){
		
		ArrayList<Color> cls= new ArrayList<Color>();
		
		String sql="SELECT idColor, color FROM color";
		Statement sentencia=null;
		ResultSet rs=null;
		
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().createStatement();
			rs = sentencia.executeQuery(sql);
			
			while(rs.next())
			{
				Color color = new Color(rs.getString("color"));
				color.setIdColor(rs.getInt("idColor"));
				
				cls.add(color);
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
				
		return cls;
	}
	
	
	public Color getColorById(int idColor)
	{
		return this.getColorById(idColor, true);
	}
	
	public  Color getColorById(int idColor, boolean CloseConnection){
		
		String sql="SELECT idColor, color FROM color WHERE idColor=?"; 
		
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		Color c = null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().prepareStatement(sql);
			sentencia.setInt(1, idColor);
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{
				c = new Color(rs.getString("color"));
				c.setIdColor(rs.getInt("idColor"));
				
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
	
	public Color getColorByNombre(String nombreColor)
	{
		return this.getColorByNombre(nombreColor, true);
	}
	
	
	public Color getColorByNombre(String nombreColor, boolean CloseConnection) 
	{
		String sql="SELECT idColor, color FROM color WHERE color=?"; 
		
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		Color c = null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConn().prepareStatement(sql);
			sentencia.setString(1, nombreColor);
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{
				c = new Color(rs.getString("color"));
				c.setIdColor(rs.getInt("idColor"));
				
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
