package capaEntidades;

public class Lavarropas extends Electrodomesticos {

	private float carga;
	
	public double getCarga() {
		return carga;
	}

	public void setCarga(float carga) {
		this.carga = carga;
	}
	
	/* Constructor por defecto*/
	
	public Lavarropas(){
		super();
		this.carga=5;
	
	}
	
	public Lavarropas(float pre, float pes)
	{ 
		super(pre,pes);
		carga=5;
	  
	}
	public Lavarropas(float pre, float pes, float car, char cons, String col) {
		super(pre, pes,col,cons);
		carga=car;
	}
	
	public String getTipo()
	{
		String tipo = "Lavarropas";
				return tipo;
	}
	
	
	public double precioFinal()
	{
		double precio_final = super.precioFinal();
		
		if (this.carga > 30)
		{
			precio_final += 50;
		}
		
		return precio_final;
	}
	
	
}
