package capaDatos;

import java.util.ArrayList;

import capaEntidades.*;


public class Datos {
										/* Create a new  ArrayList of appliance */
	
	
	static ArrayList<Electrodomesticos> electrodomesticos = new ArrayList<Electrodomesticos>();


										/* return all the objects */ 
	
		public static ArrayList<Electrodomesticos> getElectrodomesticos() {
		return electrodomesticos;
	}
		
		public static void setElectrodomesticos(
				ArrayList<Electrodomesticos> electrodomesticos) {
			Datos.electrodomesticos = electrodomesticos;
		}
		
		
		
								/* return that between at rangeMin and rangeMax */
		
		public static ArrayList<Electrodomesticos> getPorRangoDeImporte(float precmin, float precmax) {
			for(int i = 0; i< electrodomesticos.size(); i++){
		         if(electrodomesticos.get(i).getPrecioBase()>precmin &&  electrodomesticos.get(i).getPrecioBase()<precmax){
		        	electrodomesticos.add(electrodomesticos.get(i));

		         }}
			return electrodomesticos;
		}
										
											/* Add a new appliance */
		
		public static  void guardaElectrodomestico(Electrodomesticos electro)
			{
		electrodomesticos.add(electro);
			}
	
	
	
		

	public void modificarElectrodomestico(Electrodomesticos electro)
	{
		
		
		
	}

	
	
	 public ArrayList<Electrodomesticos> GetAll()
	    {
	        return electrodomesticos;
	    }

	public static void eliminarElectro(Electrodomesticos electroActual) {
		electrodomesticos.remove(electroActual);
	}}

