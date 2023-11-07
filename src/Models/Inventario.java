package Models;

import java.util.ArrayList;

public class Inventario {

	private ArrayList<Producto>  productos;
	private ArrayList<Tipo> tipos;
	private ArrayList<Marca> marcas;
	private ArrayList<Factura>facturas;
	
	public Inventario() {
		productos = new ArrayList<Producto>();
		tipos = new ArrayList<Tipo>();
		marcas = new ArrayList<Marca>();
		facturas = new ArrayList<Factura>();
	}
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public ArrayList<Tipo> getTipos() {
		return tipos;
	}

	public ArrayList<Marca> getMarcas() {
		return marcas;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
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
