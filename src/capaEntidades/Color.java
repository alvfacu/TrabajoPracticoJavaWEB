package capaEntidades;

public class Color {
	
	private String color;
	private int idColor;
	
	public int getIdColor() {
		return idColor;
	}
	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		this.color = color;
	}
	
	public Color(){
		color="Blanco";
	}
	
	public Color(String c){
		color = c ;
	}

}
