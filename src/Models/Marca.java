package Models;

public class Marca {
	
	private int id_marca;
	private String nombre;

	public Marca(String nombre, int id_marca) {
		this.nombre = nombre;
		this.id_marca = id_marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdMarca() {
		return id_marca;
	}

}
