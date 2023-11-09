package data;

import java.util.ArrayList;

import Models.Factura;
import Models.Item;
import Models.Marca;
import Models.Tipo;
import Models.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class data {

    public String url = "jdbc:sqlite:data/DataBase/AnclaDB.sqlite";
    public Connection connect;
    private ResultSet dataFacturas;
    private ResultSet dataItem;
    private ResultSet dataMarca;
    private ResultSet dataProductos;
    private ResultSet dataTipo;

    public data() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connect = DriverManager.getConnection(url);
    }

    public void loadData(ArrayList<Producto> productos, ArrayList<Tipo> tipos, ArrayList<Marca> marcas,
            ArrayList<Factura> facturas) {
        try {
            PreparedStatement stFactura = connect.prepareStatement("SELECT * FROM facturas");
            dataFacturas = stFactura.executeQuery();
            PreparedStatement stItem = connect.prepareStatement("SELECT * FROM facturas_ventas_producto");
            dataItem = stItem.executeQuery();
            PreparedStatement stMarca = connect.prepareStatement("SELECT * FROM marcas");
            dataMarca = stMarca.executeQuery();
            PreparedStatement stProductos = connect.prepareStatement("SELECT * FROM productos");
            dataProductos = stProductos.executeQuery();
            PreparedStatement stTipo = connect.prepareStatement("SELECT * FROM tipos_producto");
            dataTipo = stTipo.executeQuery();

            loadFacturas(facturas);
            loadTipos(tipos);
            loadMarcas(marcas);
            loadProductos(productos, tipos, marcas);
            loadItem(facturas, productos);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadFacturas(ArrayList<Factura> facturas) {
        try {
            while (dataFacturas.next()) {
                facturas.add(new Factura(dataFacturas.getInt("id_facturas"),
                        dataFacturas.getDate("fecha_factura"),
                        dataFacturas.getInt("valor_factura")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadProductos(ArrayList<Producto> productos, ArrayList<Tipo> tipos, ArrayList<Marca> marcas) {
        try {
            int tipoAsignar = 0;
            while (dataProductos.next()) {
                productos.add(new Producto(dataProductos.getInt("id_producto"),
                        dataProductos.getString("nombre_producto"),
                        null,
                        null,
                        dataProductos.getInt("precio"),
                        dataProductos.getInt("cantidad")));
            }
            while (dataProductos.next()) {
                for (int i = 0; i < productos.size(); i++) {
                    if (productos.get(i).getId() == dataProductos.getInt("id_producto")) {
                        tipoAsignar = dataProductos.getInt("id_tipo");
                        for (int j = 0; j < tipos.size(); j++) {
                            if (tipoAsignar == tipos.get(j).getIdTipo()) {
                                productos.get(i).setTipo(tipos.get(j));
                            }
                        }
                    }
                }
            }

            while (dataProductos.next()) {
                for (int i = 0; i < productos.size(); i++) {
                    if (productos.get(i).getId() == dataProductos.getInt("id_producto")) {
                        tipoAsignar = dataProductos.getInt("id_marca");
                        for (int j = 0; j < marcas.size(); j++) {
                            if (tipoAsignar == marcas.get(j).getIdMarca()) {
                                productos.get(i).setMarca(marcas.get(j));
                                ;
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadTipos(ArrayList<Tipo> tipos) {
        try {
            while (dataTipo.next()) {
                tipos.add(new Tipo(dataTipo.getString("nombre_tipo"),
                        dataTipo.getInt("id_tipo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadMarcas(ArrayList<Marca> marcas) {
        try {
            while (dataMarca.next()) {
                marcas.add(new Marca(dataTipo.getString("nombre_marca"),
                        dataTipo.getInt("id_marca")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadItem(ArrayList<Factura> facturas, ArrayList<Producto> productos) {
        try {
            while (dataItem.next()) {
                Producto foundedProduct = null;
                for (int i = 0; i < facturas.size(); i++) {
                    if (facturas.get(i).getId() == dataItem.getInt("id_factura")) {
                        for (int j = 0; j < productos.size(); j++) {
                            if (dataItem.getInt("id_product") == productos.get(j).getId()) {
                                foundedProduct = productos.get(j);
                                facturas.get(i).getItems()
                                        .add(new Item(foundedProduct, dataItem.getInt("cantidad_factura_producto")));
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFactura(ArrayList<Factura> facturas, int id) {
        try {
            for (int i = 0; i < facturas.size(); i++) {
                if (facturas.get(i).getId() == id) {
                    int id_factura = facturas.get(i).getId();
                    Date fecha = facturas.get(i).getFecha();
                    int valor_factura = facturas.get(i).getValor();
                    int id_producto;
                    int cantidad_factura;

                    PreparedStatement stFactura = connect.prepareStatement("INSERT INTO facturas values (" + id_factura
                            + ", \"" + fecha + "\", " + valor_factura + ")");
                    stFactura.executeUpdate();
                    for (int j = 0; j < facturas.get(i).getItems().size(); j++) {
                        id_producto = facturas.get(i).getItems().get(j).getProducto().getId();
                        cantidad_factura = facturas.get(i).getItems().get(j).getCantidad();
                        PreparedStatement stItem = connect
                                .prepareStatement("INSERT INTO facturas_ventas_producto values (" + id_factura + ", "
                                        + id_producto + ", " + cantidad_factura);
                        stItem.executeUpdate();
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMarcas(ArrayList<Marca> marcas, int id) {
        try {
            for (int i = 0; i < marcas.size(); i++) {
                if (marcas.get(i).getIdMarca() == id) {
                    int id_marca = marcas.get(i).getIdMarca();
                    String nombre_marca = marcas.get(i).getNombre();

                    PreparedStatement stMarca = connect.prepareStatement("INSERT INTO facturas values (" + id_marca + ", " + nombre_marca + ")");
                    stMarca.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTipos(ArrayList<Tipo> tipos, int id) {
        try {
            for (int i = 0; i < tipos.size(); i++) {
                if (tipos.get(i).getIdTipo() == id) {
                    int id_tipo = tipos.get(i).getIdTipo();
                    String nombre_tipo = tipos.get(i).getNombre();

                    PreparedStatement stMarca = connect.prepareStatement("INSERT INTO facturas values (" + id_tipo + ", " + nombre_tipo + ")");
                    stMarca.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProducto(ArrayList<Producto> productos, int id) {
        try {
            for (int i = 0; i < productos.size(); i++) {
                if (productos.get(i).getId() == id) {
                    int id_producto = productos.get(i).getId();
                    int id_tipo = productos.get(i).getTipo().getIdTipo();
                    int id_marca = productos.get(i).getMarca().getIdMarca();
                    String nombre_producto = productos.get(i).getNombre();
                    int precio = productos.get(i).getPrecio();
                    int cantidad = productos.get(i).getCantidad();

                    PreparedStatement stProductos = connect.prepareStatement("INSERT INTO productos values (" + id_producto + ", " + id_tipo + ", " + id_marca + ", " + nombre_producto + ", " + precio + ", " + cantidad + ")");
                    stProductos.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}