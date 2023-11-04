package Models;

import java.sql.Date;
import java.util.ArrayList;

public class Factura {

	private int id;
	private Date fecha;
	private int valor;
	private ArrayList<Item> items;
	
	public Factura(int id, Date fecha, int valor, ArrayList<Item> items) {
		this.id = id;
		this.fecha = fecha;
		this.valor = valor;
		this.items = items;
	}

	public Factura(int id, Date fecha, int valor) {
		this.id = id;
		this.fecha = fecha;
		this.valor = valor;
		this.items = new ArrayList<Item>();
	}

	public int getId() {
		return id;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getValor() {
		return valor;
	}

	public ArrayList<Item> getItems() {
		return items;
	}
	
}
