package Models;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import data.data;

public class Inventario {

	private ArrayList<Producto>  productos;
	private ArrayList<Tipo> tipos;
	private ArrayList<Marca> marcas;
	private ArrayList<Factura> facturas;
	private data data;

	public Inventario() throws SQLException {
		productos = new ArrayList<Producto>();
		tipos = new ArrayList<Tipo>();
		marcas = new ArrayList<Marca>();
		facturas = new ArrayList<Factura>();
		data = new data();
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

	private int idDisponible(ArrayList<Integer> idUsados) {
		for (int i = 1; i < 10000; i++) {
			if(!idUsados.contains(i)) {
				return i;
			}
		}
		return 0;
	}

	public void agregarProducto(String nombre, String tipo, String marca, int precio, int cantidad) {
		ArrayList<Integer> idUsados = new ArrayList<Integer>();
		productos.forEach(x -> idUsados.add(x.getId()));
		productos.add(new Producto(idDisponible(idUsados), nombre, buscarTipo(tipo), buscarMarca(marca), precio, cantidad));
		data.createProducto(productos, idDisponible(idUsados));
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
	public void modificarProducto(int id, String nombre, int precio, int cantidad) {
		for (Producto producto : productos) {
			if(producto.getId() == id) {
				producto.setNombre(nombre);
				producto.setPrecio(precio);
				producto.setCantidad(cantidad);
			}
		}
		data.updateProductos(nombre, precio, cantidad, id);
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
			data.deleteProducto(id);
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

	public void agregarTipo(String nombre) {
		ArrayList<Integer> idUsados = new ArrayList<Integer>();
		tipos.forEach(x -> idUsados.add(x.getIdTipo()));
		tipos.add(new Tipo(nombre.toUpperCase(), idDisponible(idUsados)));
		data.createTipos(tipos, idDisponible(idUsados));
	}
	
	// metodo para mostrar tipos en la vista, devuelve un arreglo de strings con los nombres de los tipos
	public String[] obtenerTipos() {
		String[] tipos = new String[this.tipos.size()];
		for (int i = 0; i < this.tipos.size(); i++) {
			tipos[i] = this.tipos.get(i).getNombre();
		}
		return tipos;
	}

	public String[][] obtenerMatrizTipos() {
		String[][] tipos = new String[this.tipos.size()][2];
		for (int i = 0; i < this.tipos.size(); i++) {
			tipos[i][0] = String.valueOf(this.tipos.get(i).getIdTipo());
			tipos[i][1] = this.tipos.get(i).getNombre();
		}
		return tipos;
	}

	public void modificarTipo(int id, String nombre) {
		for (Tipo tipo : tipos) {
			if (tipo.getIdTipo() == id) {
				tipo.setNombre(nombre.toUpperCase());
				data.updateTipos(nombre.toUpperCase(), id);
				break;
			}
		}
	}
	
	public void agregarMarca(String nombre) {
		ArrayList<Integer> idUsados = new ArrayList<Integer>();
		marcas.forEach(x -> idUsados.add(x.getIdMarca()));
		marcas.add(new Marca(nombre.toUpperCase(), idDisponible(idUsados)));
		data.createMarcas(marcas, idDisponible(idUsados));
	}
	
	// metodo para mostrar marcas en la vista, devuelve un arreglo de strings con los nombres de las marcas
	public String[] obtenerMarcas() {
		String[] marcas = new String[this.marcas.size()];
		for (int i = 0; i < this.marcas.size(); i++) {
			marcas[i] = this.marcas.get(i).getNombre();
		}
		return marcas;
	}

	public String[][] obtenerMatrizMarcas() {
		String[][] marcas = new String[this.marcas.size()][2];
		for (int i = 0; i < this.marcas.size(); i++) {
			marcas[i][0] = String.valueOf(this.marcas.get(i).getIdMarca());
			marcas[i][1] = this.marcas.get(i).getNombre();
		}
		return marcas;
	}

	public void modificarMarca(int id, String nombre) {
		for (Marca marca : marcas) {
			if (marca.getIdMarca() == id) {
				marca.setNombre(nombre.toUpperCase());
				data.updateMarca(nombre.toUpperCase(), id);
				break;
			}
		}
	}
	
	public void agregarFactura(String[][] items) {
		int valor = 0;
		ArrayList<Item> itemsCreados = new ArrayList<Item>();
		ArrayList<Integer> idUsados = new ArrayList<Integer>();
		for (int i = 0; i < items.length; i++) {
			valor += obtenerProducto(Integer.parseInt(items[i][0])).getPrecio() * Integer.parseInt(items[i][1]);
			itemsCreados.add(new Item(obtenerProducto(Integer.parseInt(items[i][0])), Integer.parseInt(items[i][1])));
			modificarCantidadProducto(Integer.parseInt(items[i][0]), Integer.parseInt(items[i][1]));
		}
		facturas.forEach(x -> idUsados.add(x.getId()));
		facturas.add(new Factura(idDisponible(idUsados), new Date(System.currentTimeMillis()), valor, itemsCreados));
		data.createFactura(facturas, idDisponible(idUsados));
	}

	// para las ventas
	private void modificarCantidadProducto(int id, int cantidadVendida) {
		for (Producto producto : productos) {
			if(producto.getId() == id) {
				producto.setCantidad(producto.getCantidad() - cantidadVendida);
				data.updateProductos(producto.getNombre(), producto.getPrecio(), producto.getCantidad(), id);
			}
		}
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
