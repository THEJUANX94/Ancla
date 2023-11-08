package Controller;

import java.sql.SQLException;
import Models.Inventario;
import data.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.User;
import View.Views;

public class Controller implements ActionListener{

    private Views views;
    private User login;
    private Inventario inventario;
    private Data data;

    public Controller(User user) throws SQLException {
        views = new Views(this);
        this.login = user;
        data = new Data();
        inventario = new Inventario();
    }

    public void run(){
        data.loadData(inventario.getProductos(), inventario.getTipos(), inventario.getMarcas(), inventario.getFacturas());
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
                    views.dialogSeller.setVisible(confirm);
                }
                break;
            case "Boton_Facturacion":
                views.show1("Boton_Facturacion");
                break;
            case "Boton_Gestionar":
                views.show1("Boton_Gestionar");
                break;
            case "Salir":
                views.dialogSeller.setVisible(false);
                System.exit(0);
                break;
            case "Pestaña_Facturacion":
                views.show1("Boton_Facturacion");
                ;
                break;
            case "Pestaña_Historial":
                views.show1("Pestaña_Historial");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) throws SQLException {
        User user = new User("admin", "123");
        new Controller(user);
    }
    
}