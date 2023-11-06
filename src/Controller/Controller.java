package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.Login;
import View.Views;

public class Controller implements ActionListener {

    private Views views;
    private Login login;

    public Controller(Login user) {
        views = new Views(this);
        this.login = user;
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
        Login user = new Login("admin", "123");
        new Controller(user);
    }
}