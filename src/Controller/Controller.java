package Controller;

import java.sql.SQLException;

import Models.Inventario;
import data.data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.User;
import View.Views;

public class Controller implements ActionListener {

    private Views views;
    private User login;
    private Inventario inventario;
    private data data;

    public Controller(User user) throws SQLException {
        views = new Views(this);
        this.login = user;
        data = new data();
        inventario = new Inventario();
    }

    public void run() {
        data.loadData(inventario.getProductos(), inventario.getTipos(), inventario.getMarcas(),
                inventario.getFacturas());
    }

    public boolean login(String user, String password) {
        boolean confirm = login.authenticate(user, password);
        if (confirm == false) {
            views.showMessageLogin("Invalid username or password");
        }
        return confirm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        switch (source) {
            case "Ingresar":
                String user = views.getTxtLoginUser();
                String password = views.getTxtLoginPassword();
                boolean confirm = login(user, password);
                if (confirm) {
                    views.setVisible(confirm);
                    views.loginPanel.setVisible(false);
                }
                break;
            case "Boton_Facturacion":
                views.show1("Boton_Facturacion");
                views.loadDataTable1(inventario.obtenerProductos());
                break;
            case "Boton_Gestionar":
                views.show1("Boton_Gestionar");
                views.loadDataTableManage(inventario.obtenerProductos());
                break;
            case "Salir":
                views.loginPanel.setVisible(false);
                System.exit(0);
                break;
            case "Pestaña_Facturacion":
                views.show1("Boton_Facturacion");
                views.loadDataTable1(inventario.obtenerProductos());
                break;
            case "Pestaña_Historial":
                views.show1("Pestaña_Historial");
                views.loadDataHistory(inventario.obtenerFacturas());
                break;
            case "Pestaña_Gestionar_Producto":
                views.show1("Boton_Gestionar");
                views.loadDataTableManage(inventario.obtenerProductos());
                break;
            case "Pestaña_Gestionar_Tipo":
                views.show1("Pestaña_GestionarTipo");
                views.loadDataTableType(inventario.obtenerMatrizTipos());
                break;
            case "Pestaña_Gestionar_Marca":
                views.show1("Pestaña_GestionarMarca");
                views.loadDataTableBrand(inventario.obtenerMatrizMarcas());
                break;
            case "Crear_producto":
                views.obtainedTypes(inventario.obtenerTipos());
                views.obtainedMarks(inventario.obtenerMarcas());
                views.dialogForm.setName("");
                views.dialogForm.setType(true);
                views.dialogForm.setMark(true);
                views.dialogForm.setPrice("");
                views.dialogForm.setQuantity("");
                views.dialogForm.setVisible(true);
                views.dialogForm.setComand("Aceptar creacion Producto");
                break;
            case "Crear_Tipo":
                views.dialogTypeForm.setNameType("");
                views.dialogTypeForm.setVisible(true);
                views.dialogTypeForm.setComandType("Aceptar creacion Tipo");
                break;
            case "Crear_Marca":
                views.dialogMarkForm.setNameMark("");
                views.dialogMarkForm.setVisible(true);
                views.dialogMarkForm.setComandMark("Aceptar creacion Marca");
                break;
            case "AddProductToBill":
                views.loadDataTable2();
                break;
            case "Aceptar creacion Producto":
                if (views.selectedPrice() != 0 && !views.newName().equals("")
                        && views.dialogForm.selectedQuantity() != 0) {
                    String nombre = views.newName();
                    String tipo = views.selectedType();
                    String marca = views.selectedMark();
                    int precio = views.selectedPrice();
                    inventario.agregarProducto(nombre, tipo, marca, precio, views.dialogForm.selectedQuantity());
                    views.loadDataTableManage(inventario.obtenerProductos());
                    views.dialogForm.setVisible(false);
                }
                break;
            case "Cancelar":
                views.dialogForm.setVisible(false);
                views.dialogMarkForm.setVisible(false);
                views.dialogTypeForm.setVisible(false);
                views.itemsDialog.setVisible(false);
                views.getConfirm(true);
                views.deleteDialog.setVisible(false);
                views.adverstingDialog.setVisible(false);
                break;
            case "Aceptar creacion Marca":
                if (!views.newMarkName().equals("")) {
                    inventario.agregarMarca(views.newMarkName());
                    views.loadDataTableBrand(inventario.obtenerMatrizMarcas());
                    views.dialogMarkForm.setVisible(false);
                }
                break;
            case "Aceptar creacion Tipo":
                if (!views.newTypeName().equals("")) {
                    inventario.agregarTipo((views.newTypeName()));
                    views.loadDataTableType(inventario.obtenerMatrizTipos());
                    views.dialogTypeForm.setVisible(false);
                }
                break;
            case "Buscar_Fecha":
                views.getDate();
                break;
            case "Aceptar_venta":
                if (views.confirmTabla2() == true) {
                    inventario.agregarFactura(views.getItems());
                    views.setTable2();
                    views.loadDataTable1(inventario.obtenerProductos());
                }
                break;
            case "Cancelar_venta":
                views.setTable2();
                break;
            case "CancelarBusqueda":
                views.setHistoryTable();
                break;
            case "VerItemList":
                if (views.getIdBill() != 0) {
                    views.getItemList(inventario.obtenerItems(views.getIdBill()));
                    views.itemsDialog.setVisible(true);
                }
                break;
            case "Eliminar_producto":
                if (views.getIdProduct() != 0) {
                    views.deleteDialog.setVisible(true);
                }
                break;
            case "Aceptar_Eliminar_Producto":
                inventario.eliminarProducto(views.getIdProduct());
                views.loadDataTableManage(inventario.obtenerProductos());
                views.deleteDialog.setVisible(false);
                break;
            case "Modificar_Marca":
                if (!views.getNameMark().equals("")) {
                    views.dialogMarkForm.setNameMark(views.getNameMark());
                    views.dialogMarkForm.setVisible(true);
                    views.dialogMarkForm.setComandMark("Aceptar_modificar_Marca");
                }
                break;
            case "Aceptar_modificar_Marca":
                if (!views.newMarkName().equals("")) {
                    inventario.modificarMarca(views.getIdmark(), views.newMarkName());
                    views.loadDataTableBrand(inventario.obtenerMatrizMarcas());
                    views.dialogMarkForm.setVisible(false);
                }
                break;
            case "Modificar_Tipo":
                if (!views.getNameType().equals("")) {
                    views.dialogTypeForm.setNameType(views.getNameType());
                    views.dialogTypeForm.setVisible(true);
                    views.dialogTypeForm.setComandType("Aceptar_modificar_Tipo");
                }
                break;
            case "Aceptar_modificar_Tipo":
                if (!views.newTypeName().equals("")) {
                    inventario.modificarTipo(views.getIdType(), views.newTypeName());
                    views.loadDataTableType(inventario.obtenerMatrizTipos());
                    views.dialogTypeForm.setVisible(false);
                }
                break;
            case "Modificar_producto":
                if (views.getIdProduct() != 0) {
                    views.dialogForm.setName(views.getNameProduct());
                    views.dialogForm.setType(false, views.getTypeProduct());
                    views.dialogForm.setMark(false, views.getMarkProduct());
                    views.dialogForm.setPrice(views.getPriceProduct());
                    views.dialogForm.setQuantity(views.getQuantityProduct());
                    views.dialogForm.setVisible(true);
                    views.dialogForm.setComand("Aceptar_modificar_producto");
                }
                break;
            case "Aceptar_modificar_producto":
                if (views.selectedPrice() != 0 && !views.newName().equals("")
                        && views.dialogForm.selectedQuantity() != 0) {
                    int id = views.getIdProduct();
                    String nombre = views.newName();
                    int precio = views.selectedPrice();
                    int quantity = views.dialogForm.selectedQuantity();
                    inventario.modificarProducto(id, nombre, precio, quantity);
                    views.loadDataTableManage(inventario.obtenerProductos());
                    views.dialogForm.setVisible(false);
                }
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) throws SQLException {
        User user = new User("admin", "123");
        Controller controller = new Controller(user);
        controller.run();
    }
}