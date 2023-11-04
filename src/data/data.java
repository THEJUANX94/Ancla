package data;

import java.util.ArrayList;

import Models.Factura;
import Models.Item;
import Models.Marca;
import Models.Tipo;
import Models.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class data {

    public String url = "src/data/DataBase/AnclaDB";
    public Connection connect;
    private ResultSet dataFacturas;
    private ResultSet dataInventario;
    private ResultSet dataItem;
    private ResultSet dataMarca;
    private ResultSet dataProductos;
    private ResultSet dataTipo;

    public data() throws SQLException {
        connect = DriverManager.getConnection(url);
    }

    public void loadData(ArrayList<Producto> productos, ArrayList<Tipo> tipos, ArrayList<Marca> marcas, ArrayList<Factura> facturas){
        try {
            PreparedStatement stFactura = connect.prepareStatement("SELECT * FROM Factura");
            dataFacturas = stFactura.executeQuery();
            PreparedStatement stInventario = connect.prepareStatement("SELECT * FROM Inventario");
            dataInventario = stInventario.executeQuery();
            PreparedStatement stItem = connect.prepareStatement("SELECT * FROM facturas_ventas_producto");
            dataItem = stItem.executeQuery();
            PreparedStatement stMarca = connect.prepareStatement("SELECT * FROM Marca");
            dataMarca = stMarca.executeQuery();
            PreparedStatement stProductos = connect.prepareStatement("SELECT * FROM Producto");
            dataProductos = stProductos.executeQuery();
            PreparedStatement stTipo = connect.prepareStatement("SELECT * FROM Tipo");
            dataTipo = stTipo.executeQuery();

            while (dataFacturas.next()) {
                facturas.add(new Factura(dataFacturas.getInt("id_facturas"),
                                        dataFacturas.getDate("fecha_factura"), 
                                        dataFacturas.getInt("valor_factura")));
            }

            while (dataProductos.next()) {
                productos.add(new Producto(dataProductos.getInt("id_producto"),dataProductos.getString("nombre_producto") , null, null, 0, 0));
            }

            while(dataItem.next()){
                Producto foundedProduct = null;
                for (int i = 0; i < facturas.size(); i++) {
                    if (facturas.get(i).getId() == dataItem.getInt("id_factura")) {
                        for (int j = 0; j < productos.size(); j++) {
                            if (dataItem.getInt("id_product") == productos.get(j).getId()) {
                            foundedProduct = productos.get(j);
                            facturas.get(i).getItems().add(new Item(foundedProduct, dataItem.getInt("cantidad_factura_producto")));
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
