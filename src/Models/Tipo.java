package Models;

public class Tipo {

	private int id_tipo;
	private String nombre;

	public Tipo(String nombre, int id_tipo) {
		this.nombre = nombre;
		this.id_tipo = id_tipo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getIdTipo() {
		return id_tipo;
	}
}