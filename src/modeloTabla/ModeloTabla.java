package modeloTabla;


import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import capaEntidades.*;
import capaLogica.*;

public class ModeloTabla extends AbstractTableModel {

	
	private static final long serialVersionUID = 1L;
	private ArrayList<Electrodomesticos> dataSource;
	
	
	public ArrayList<Electrodomesticos> getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(ArrayList<Electrodomesticos> dataSource) {
		this.dataSource = dataSource;
	}
	
	public int getColumnCount() {

		return 8;
	}

	public int getRowCount() {

		return dataSource.size();
	}
	public  ModeloTabla(String min,String max,char letra){
		
	
	ArrayList<Electrodomesticos> electros = new capaLogica.Ejecuta().getOrden();
	ArrayList<Electrodomesticos> elecSeleccionados = new ArrayList<Electrodomesticos>();
	
		for(int i = 0; i < electros.size(); i++)
			{		if (!(letra == ' '))
				{
					if((min.isEmpty()) && (max.isEmpty()))
					{
						if(electros.get(i).getConsu().getConsumo() == letra)
						{
							if (electros.get(i) instanceof capaEntidades.Television)
							{
								elecSeleccionados.add(electros.get(i));
							}
							else if (electros.get(i) instanceof capaEntidades.Lavarropas)
							{
								elecSeleccionados.add(electros.get(i));
							}
						}
					}
					else if (!(min.isEmpty()) && !(max.isEmpty()))
					{
						if(electros.get(i).getConsu().getConsumo() == letra && (electros.get(i).precioFinal() > Double.parseDouble(min) && (electros.get(i).precioFinal() < Double.parseDouble(max))))
						{
							if (electros.get(i) instanceof capaEntidades.Television)
							{
								elecSeleccionados.add(electros.get(i));
							}
							else if (electros.get(i) instanceof capaEntidades.Lavarropas)
							{
								elecSeleccionados.add(electros.get(i));
							}
						}
					}
				}		
			else if(!(min.isEmpty()) && !(max.isEmpty()))
			{
				if((electros.get(i).precioFinal() > Double.parseDouble(min)) && (electros.get(i).precioFinal() < Double.parseDouble(max)))
				{
					if (electros.get(i) instanceof capaEntidades.Television)
					{
						elecSeleccionados.add(electros.get(i));
					}
					else if (electros.get(i) instanceof capaEntidades.Lavarropas)
					{
						elecSeleccionados.add(electros.get(i));
					}
				}
			}
		}
		
		this.setDataSource(elecSeleccionados);
	}
		
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		capaEntidades.Electrodomesticos b = dataSource.get(rowIndex);
		Object o;
		switch (columnIndex) {
		case 0:
			o=b.getTipo();
			break;
		case 1:
			o=b.precioFinal();
			break;
		case 2:
			o=b.getCol().getColor();
			break;
		case 3:
			o=b.getPeso();
			break;
		case 4:
			o=b.getConsu().getConsumo();
			break;
		case 5:
			if (b instanceof capaEntidades.Lavarropas)
			{
				o = ((capaEntidades.Lavarropas)b).getCarga();
			}
			else
			{
				o = "";
			};
			break;
		case 6:
			if (b instanceof capaEntidades.Television)
			{
				o = ((capaEntidades.Television)b).getResolucion();
			}
			else
			{
				o = "";
			};
			break;
		case 7:
			if (b instanceof capaEntidades.Television)
			{
				o = ((capaEntidades.Television)b).getTDT();
			}
			else
			{
				o = "";
			};
			break;
		default:
			o=null;
			break;
		}
		return o;
	}
	
	public String getColumnName(int column)
	{
		String nom="";
		switch (column) {
		case 0:
			nom="Descripción";
			break;
		case 1:
			nom="Precio (U$S)";
			break;
		case 2:
			nom="Color";
			break;
		case 3:
			nom="Peso (kg)";
			break;
		case 4:
			nom="Consumo";
			break;
		case 5:
			nom="Carga (kg)";
			break;
		case 6:
			nom="Resol. (in)";
			break;
		case 7:
			nom="TDT";
			break;
		default:
			nom="";
			break;
		}
		return nom;		
	}


}