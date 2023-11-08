package Models;

import java.sql.Date;
import java.util.ArrayList;

public class Inventario {

	private ArrayList<Producto>  productos;
	private ArrayList<Tipo> tipos;
	private ArrayList<Marca> marcas;
	private ArrayList<Factura> facturas;
	
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

	// id
	public void agregarProducto(String nombre, String tipo, String marca, int precio, int cantidad) {
		productos.add(new Producto(0, nombre, buscarTipo(tipo), buscarMarca(marca), precio, cantidad));
	}

	// metodo para mostrar los productos en la vista
	// devuelve una matriz de strings donde cada fila es un producto: [id | nombre | tipo | marca | precio | cantidad]
	public String[][] obtenerProductos() {
		String[][] productos = new String[this.productos.size()][6];
		for (int i = 0; i < this.productos.size(); i++) {
			productos[i][0] = String.valueOf(this.productos.get(i).getId());
			productos[i][1] = this.productos.get(i).getNombre();
			productos[i][2] = this.productos.get(i).getTipo().getNombre();
			productos[i][3] = this.productos.get(i).getMarca().getNombre();
			productos[i][4] = String.valueOf(this.productos.get(i).getPrecio());
			productos[i][5] = String.valueOf(this.productos.get(i).getCantidad());
		}
		return productos;
	}
	
	// nota: llegan los nombres de tipo y marca y con buscarTipo() y buscarMarca() se asignan los objetos correspodientes
	public void modificarProducto(int id, String nombre, String tipo, String marca, int precio, int cantidad) {
		for (Producto producto : productos) {
			if(producto.getId() == id) {
				producto.setNombre(nombre);
				producto.setTipo(buscarTipo(tipo));
				producto.setMarca(buscarMarca(marca));
				producto.setPrecio(precio);
				producto.setCantidad(cantidad);
			}
		}
	}
 
	// para las ventas
	public void modificarCantidadProducto(int id, int cantidad) {
		for (Producto producto : productos) {
			if(producto.getId() == id) {
				producto.setCantidad(cantidad);
			}
		}
	}

	public void eliminarProducto(int id) {
		Producto productoAEliminar = null;
		for (Producto producto : productos) {
			if (producto.getId() == id) {
				productoAEliminar = producto;
				break;
			}
		}
		if (productoAEliminar != null) {
			productos.remove(productoAEliminar);
		}
	}	

	private Tipo buscarTipo(String nombre) {
		for (Tipo tipo : tipos) {
			if(tipo.getNombre().equals(nombre)) {
				return tipo;
			}
		}
		return null;
	}

	private Marca buscarMarca(String nombre) {
		for (Marca marca : marcas) {
			if(marca.getNombre().equals(nombre)) {
				return marca;
			}
		}
		return null;
	}

	// id
	public void agregarTipo(String nombre) {
		tipos.add(new Tipo(nombre.toUpperCase(), 0));
	}
	
	// metodo para mostrar tipos en la vista, devuelve un arreglo de strings con los nombres de los tipos
	public String[] obtenerTipos() {
		String[] tipos = new String[this.tipos.size()];
		for (int i = 0; i < this.tipos.size(); i++) {
			tipos[i] = this.tipos.get(i).getNombre();
		}
		return tipos;
	}
	
	// id
	public void agregarMarca(String nombre) {
		marcas.add(new Marca(nombre.toUpperCase(), 0));
	}
	
	// metodo para mostrar marcas en la vista, devuelve un arreglo de strings con los nombres de las marcas
	public String[] obtenerMarcas() {
		String[] marcas = new String[this.marcas.size()];
		for (int i = 0; i < this.marcas.size(); i++) {
			marcas[i] = this.marcas.get(i).getNombre();
		}
		return marcas;
	}
	
	// id
	public void agregarFactura(String[][] items) {
		int valor = 0;
		ArrayList<Item> itemsCreados = new ArrayList<Item>();
		for (int i = 0; i < items.length; i++) {
			valor += obtenerProducto(Integer.parseInt(items[i][0])).getPrecio() * Integer.parseInt(items[i][4]);
			itemsCreados.add(new Item(obtenerProducto(Integer.parseInt(items[i][0])), Integer.parseInt(items[i][4])));
		}
		facturas.add(new Factura(0, new Date(System.currentTimeMillis()), valor, itemsCreados));
	}

	private Producto obtenerProducto(int id) {
		Producto productoAObtener = null;
		for (Producto producto : productos) {
			if(producto.getId() == id) {
				productoAObtener = producto;
				break;
			}
		}
		return productoAObtener;
	}
	
	// metodo para mostrar las facturas en la vista
	// devuelve una matriz de strings donde cada fila es una factura: [id | fecha | valor]
	public String[][] obtenerFacturas() {
		String[][] facturas = new String[this.facturas.size()][3];
		for (int i = 0; i < this.facturas.size(); i++) {
			facturas[i][0] = String.valueOf(this.facturas.get(i).getId());
			facturas[i][1] = this.facturas.get(i).getFecha().toString();
			facturas[i][2] = String.valueOf(this.facturas.get(i).getValor());
		}
		return facturas;
	}

	// metodo para mostrar los items de una factura en la vista
	// devuelve una matriz de strings donde cada fila es un item: [nombre_producto | cantidad]
	public String[][] obtenerItems(int id) {
		String[][] items = new String[0][0];
		for (Factura factura : facturas) {
			if(factura.getId() == id) {
				items = new String[factura.getItems().size()][2];
				for (int i = 0; i < factura.getItems().size(); i++) {
					items[i][0] = factura.getItems().get(i).getProducto().getNombre();
					items[i][1] = String.valueOf(factura.getItems().get(i).getCantidad());
				}
			}
		}
		return items;
	}

}