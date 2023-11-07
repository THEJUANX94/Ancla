package Controller;

import java.sql.SQLException;

import Models.Inventario;
import data.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.Login;
import View.Views;

public class Controller implements ActionListener{

    private Views views;
    private Login login;
    private Inventario inventario;
    private Data data;

    public Controller(Login user) throws SQLException {
        data = new Data();
        inventario = new Inventario();
        views = new Views(this);
        this.login = user;
    }

    public void run(){
        data.loadData(inventario.getProductos(), inventario.getTipos(), inventario.getMarcas(), inventario.getFacturas());
    }

    public boolean login(String user, String password) {
        boolean confirm = login.authenticate(user, password);
        if (confirm== false) {
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
            case "Ventas":
                
                break;
            case "Gestionar":

                break;
            case "a":

                break;
            case "Salir":
                views.dialogSeller.setVisible(false);
                System.exit(0);
                break;
            default:
                break;
        }
    }
    
    public static void main(String[] args) {
        Controller controller;
        try {
            Login user = new Login("admin", "123");
            controller = new Controller(user);
            controller.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}