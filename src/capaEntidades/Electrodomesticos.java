package capaEntidades;

public class Electrodomesticos {
	
	private int idElectro;
	private float precioBase;
	private float peso;
	private Color col;
	private Consumo consu;
	
	
	
	
	
	
	/* Constructor por defecto */
	
	public int getIdElectro() {
		return idElectro;
	}

	public void setIdElectro(int idElectro) {
		this.idElectro = idElectro;
	}

	public float getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Color getCol() {
		return col;
	}

	public void setCol(Color col) {
		this.col = col;
	}

	public Consumo getConsu() {
		return consu;
	}

	public void setConsu(Consumo consu) {
		this.consu = consu;
	}

	public Electrodomesticos()
	
	{
		precioBase=100;
		peso=5;
		col = new Color();
		consu=new Consumo();
		
	};
		
	public Electrodomesticos(float p, float pe)
	
	{
		precioBase = p ;
		peso = pe;
		col = new Color();
		consu=new Consumo();
		
	}
	
	public Electrodomesticos(float p, float pe, String colo, char consu)
	
	{
		;
		precioBase = p ;
		peso = pe;
		if (this.comprobarConsumoEnergetico(consu))
		{
			this.consu = new Consumo(consu);
		}
		else
		{
			this.consu = new Consumo('F');
		}
		if (this.comprobarColor(colo))
		{
			colo = transformar(colo);
			this.col = new Color(colo);
		}
		else
		{
			this.col = new Color("Blanco");
		}		
	}
		
	
	
	
	private boolean comprobarConsumoEnergetico(char letra)
	{
		char[] letras = {'A','B','C','D','E','F'};
		letra = Character.toUpperCase(letra);
		boolean estado = false;
		for(int i = 0; i < 6 ; i++)
		{
			if (letras[i] == letra)
			{
				estado = true;
				break;
			}
		}
		if (estado == true)
		{
			return estado;
		}
		else 
		{
			return false;
		}
	}
	
	private boolean comprobarColor(String color)
	{
		String[] colores = {"blanco","negro","rojo","azul","gris"};
		boolean estado = false;
		for(int i = 0; i < 5 ; i++)
		{
			if (color.compareToIgnoreCase(colores[i]) == 0)
			{
				estado = true;
				break;
			}
		}
		if (estado == true)
		{
			return estado;
		}
		else 
		{
			return false;
		}
	}
	
	public String getTipo()
	{
		String tipo = "Electrodomesticos";
				return tipo;
	}
	
	public double precioFinal()
	{
		double precio_final = 0;
		
		precio_final += this.getPrecioBase();
		
		if((this.peso > 0) && (this.peso <= 19)) 
		{
			precio_final += 10;
		}
		else if ((this.peso > 19) && (this.peso <= 49))
		{
			precio_final += 50;
		}
		else if ((this.peso > 49) && (this.peso <= 79))
		{
			precio_final += 80;
		}
		else if (this.peso > 79)
		{
			precio_final += 100;
		}
		
		switch((this.consu).getConsumo())
		{
			case('A'): 
			{
				precio_final += 100;
				break;
			}
			case('B'): 
			{
				precio_final += 80;
				break;
			}
			case('C'): 
			{
				precio_final += 60;
				break;
			}
			case('D'): 
			{
				precio_final += 50;
				break;
			}
			case('E'): 
			{
				precio_final += 30;
				break;
			}
			case('F'): 
			{
				precio_final += 10;
				break;
			}
		}
		
		return precio_final; 
	}
	private String transformar(String color)
	{
		char[] caracteres = color.toCharArray();
		
		for (int i = 0; i < color.length(); i++)
		{
			if (i == 0)
			{
				caracteres[i] = Character.toUpperCase(caracteres[i]);
			}
			else
			{
				caracteres[i] = Character.toLowerCase(caracteres[i]);
			}
		}
		
		return new String(caracteres);
	}
	}

