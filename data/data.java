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
    private PreparedStatement stFactura;
    private PreparedStatement stItem;
    private PreparedStatement stMarca;
    private PreparedStatement stProductos;
    private PreparedStatement stTipo;

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
            stFactura = connect.prepareStatement("SELECT * FROM facturas");
            dataFacturas = stFactura.executeQuery();
            stItem = connect.prepareStatement("SELECT * FROM facturas_ventas_producto");
            dataItem = stItem.executeQuery();
            stMarca = connect.prepareStatement("SELECT * FROM marcas");
            dataMarca = stMarca.executeQuery();
            stProductos = connect.prepareStatement("SELECT * FROM productos");
            dataProductos = stProductos.executeQuery();
            stTipo = connect.prepareStatement("SELECT * FROM tipos_producto");
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
                        Date.valueOf(dataFacturas.getString("fecha_factura")),
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

                for (int i = 0; i < productos.size(); i++) {
                    if (productos.get(i).getId() == dataProductos.getInt("id_producto")) {
                        tipoAsignar = dataProductos.getInt("id_tipo");
                        for (int j = 0; j < tipos.size(); j++) {
                            if (tipoAsignar == tipos.get(j).getIdTipo()) {
                                productos.get(i).setTipo(tipos.get(j));
                            }
                        }

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
                marcas.add(new Marca(dataMarca.getString("nombre_marca"),
                        dataMarca.getInt("id_marca")));
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
                            if (dataItem.getInt("id_producto") == productos.get(j).getId()) {
                                foundedProduct = productos.get(j);
                                facturas.get(i).getItems()
                                        .add(new Item(foundedProduct, dataItem.getInt("cantidad_factura_producto")));
                                System.out.println(foundedProduct.getNombre());
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createFactura(ArrayList<Factura> facturas, int id) {
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
                        stFactura = connect
                                .prepareStatement("INSERT INTO facturas_ventas_producto values (" + id_producto + ", "
                                        + id_factura + ", " + cantidad_factura + ")");
                        stFactura.executeUpdate();
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createMarcas(ArrayList<Marca> marcas, int id) {
        try {
            for (int i = 0; i < marcas.size(); i++) {
                if (marcas.get(i).getIdMarca() == id) {
                    int id_marca = marcas.get(i).getIdMarca();
                    String nombre_marca = marcas.get(i).getNombre();

                    stMarca = connect
                            .prepareStatement("INSERT INTO marcas values (" + id_marca + ", '" + nombre_marca + "')");
                    stMarca.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTipos(ArrayList<Tipo> tipos, int id) {
        try {
            for (int i = 0; i < tipos.size(); i++) {
                if (tipos.get(i).getIdTipo() == id) {
                    int id_tipo = tipos.get(i).getIdTipo();
                    String nombre_tipo = tipos.get(i).getNombre();

                    stTipo = connect
                            .prepareStatement("INSERT INTO tipos_producto values (" + id_tipo + ", '"+ nombre_tipo + "')");
                    stTipo.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createProducto(ArrayList<Producto> productos, int id) {
        try {
            for (int i = 0; i < productos.size(); i++) {
                if (productos.get(i).getId() == id) {
                    int id_producto = productos.get(i).getId();
                    int id_tipo = productos.get(i).getTipo().getIdTipo();
                    int id_marca = productos.get(i).getMarca().getIdMarca();
                    String nombre_producto = productos.get(i).getNombre();
                    int precio = productos.get(i).getPrecio();
                    int cantidad = productos.get(i).getCantidad();

                    stProductos = connect
                            .prepareStatement("INSERT INTO productos values (" + id_producto + ", " + id_tipo + ", "
                                    + id_marca + ", '" + nombre_producto + "', " + precio + ", " + cantidad + ")");
                    stProductos.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFactura(int id) {
        try {
            stFactura = connect.prepareStatement("DELETE FROM facturas where id = " + id);
            stFactura.executeUpdate();
            stFactura = connect.prepareStatement("DELETE FROM facturas_ventas_producto where id = " + id);
            stFactura.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMarca(int id) {
        try {
            stMarca = connect.prepareStatement("DELETE FROM marca where id = " + id);
            stMarca.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProducto(int id) {
        try {
            stProductos = connect.prepareStatement("DELETE FROM productos where id = " + id);
            stProductos.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTipos(int id) {
        try {
            stTipo = connect.prepareStatement("DELETE FROM tipos_productos where id = " + id);
            stTipo.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMarca(String name, int id) {
        try {
            stMarca = connect.prepareStatement("UPDATE marcas SET nombre_marca = '" + name + "' WHERE id_marca = " + id);
            stMarca.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProductos(String name, int precio, int cantidad, int id) {
        try {
            stProductos = connect.prepareStatement("UPDATE productos SET nombre_producto ='" + name + "', precio = " + precio + ", cantidad =" + cantidad +  
            " WHERE id_producto = " + id);
            stProductos.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTipos(String name, int id) {
        try {
            stTipo = connect.prepareStatement("UPDATE tipos_producto SET nombre_tipo = '" + name + "' WHERE id_tipo = " + id);
            stTipo.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}