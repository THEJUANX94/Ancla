package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import Models.User;
import View.Views;
import data.Credentials;

public class Controller implements ActionListener {

    private Views views;
    private User login;

    public Controller(User user) {
        views = new Views(this);
        this.login = user;
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

    public static void main(String[] args) throws FileNotFoundException {
        Credentials credentials = new Credentials();
        ArrayList<User> userList = credentials.readUser();
        User user = null;
        for (int i = 0; i < userList.size(); i++) {
            user = new User(userList.get(i).getUsername(), userList.get(i).getPassword());
        }
        new Controller(user);
    }
}