package capaEntidades;

public class Consumo {
		
	private char consumo;
	private int idConsumo;
	private float precio;

	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	

	public int getIdConsumo() {
		return idConsumo;
	}

	public void setIdConsumo(int idConsumo) {
		this.idConsumo = idConsumo;
	}

	
	
	public char getConsumo() {
		return consumo;
	}

	public void setConsumo(char consumo) {
		this.consumo = consumo;
	}
	
	public Consumo(){	
		this.consumo='F';
		}
		
		
		public Consumo(char letra, float precio)
	
	{
		letra = Character.toUpperCase(letra);
		this.consumo = letra;
		this.precio = precio;
	}
	
	public Consumo(char con){
		consumo = Character.toUpperCase(con);

	}

	
}
