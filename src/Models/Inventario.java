package Models;

import java.util.ArrayList;

public class Inventario {

	private ArrayList<Producto>  productos;
	private ArrayList<Tipo> tipos;
	private ArrayList<Marca> marcas;
	private ArrayList<Factura>facturas;
	
	public Inventario(ArrayList<Producto> productos, ArrayList<Tipo> tipos, ArrayList<Marca> marcas, ArrayList<Factura> facturas) {
		this.productos = productos;
		this.tipos = tipos;
		this.marcas = marcas;
		this.facturas = facturas;
	}
	
	public void agregarProducto() {

	}
	
	public void agregarTipo() {
		
	}
	
	public String[] obtenerTipos() {
		return new String[0];
	}
	
	public void agregarMarca() {
		
	}
	
	public String[] obtenerMarcas() {
		return new String[0];
	}
	
	public void agregarFactura() {
		
	}
	
}
