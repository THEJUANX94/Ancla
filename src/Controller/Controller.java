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
                break;
            case "Salir":
                views.loginPanel.setVisible(false);
                System.exit(0);
                break;
            case "Pestaña_Facturacion":
                views.show1("Boton_Facturacion");
                views.loadDataTable1(inventario.obtenerFacturas());
                break;
            case "Pestaña_Historial":
                views.show1("Pestaña_Historial");
                break;
            case "Crear_producto":
                views.obtainedTypes(inventario.obtenerTipos());
                views.obtainedMarks(inventario.obtenerMarcas());
                views.dialogForm.setVisible(true);
                break;
            case "AddProductToBill":
                views.loadDataTable2();
                break;
            case "Aceptar creacion Producto":
                String nombre = views.newName();
                String tipo = views.selectedType();
                String marca = views.selectedMark();
                int precio = views.selectedPrice();
                inventario.agregarProducto(nombre, tipo, marca, precio, 0);
                views.dialogForm.setVisible(false);
                break;
            case "Cargar Imagen":
                views.chooseImage.setVisible(true);
                views.setProductImage(views.chooseImage.selection());
                views.chooseImage.setVisible(false);
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