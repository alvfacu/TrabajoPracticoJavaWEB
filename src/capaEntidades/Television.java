package capaEntidades;

public class Television extends Electrodomesticos {
	
	private float resolucion;
	private boolean sintonizadorTdt;
	
	 
	
	public float getResolucion() {
		return resolucion;
	}
	public void setResolucion(float resolucion) {
		this.resolucion = resolucion;
	}
	public boolean isSintonizadorTdt() {
		return sintonizadorTdt;
	}
	public void setSintonizadorTdt(boolean sintonizadorTdt) {
		this.sintonizadorTdt = sintonizadorTdt;
	
	}
	
	public Television(){
		
		super();
		resolucion=20;
		sintonizadorTdt=false;
	}
	
	public Television(float pre,float pes){
		super(pre,pes);
		resolucion=20;
		sintonizadorTdt=false;
	}
	
	public Television(float prec,float peso,char cons,  float res,String col,boolean sinto)

	{
		super(prec,peso,col,cons);
		resolucion = res ;
		sintonizadorTdt = sinto;
	}
	
	public String getTipo()
	{
		String tipo = "Television";
				return tipo;
	}
	
	public boolean getSintonizadorTdt()
	{
	return sintonizadorTdt;
	}
	
	public String getTDT(){
		if (this.isSintonizadorTdt())
		{
			return "Si";
		}
		else
		{
			return "No";
		}
	}
	
	public double precioFinal()
	{
		double precio_final = super.precioFinal();
		
		if (this.resolucion > 40)
		{
			precio_final += precio_final * 0.3;
		}
		if (this.sintonizadorTdt)
		{
			precio_final += 50;
		}
		
		return precio_final;
	}
	
	
}
