package Controller;

import java.sql.SQLException;

import Models.Inventario;
import data.Data;

public class Controller {

    private Inventario inventario;
    private Data data;

    public Controller() throws SQLException {
        data = new Data();
        inventario = new Inventario();
    }

    public void run(){
        data.loadData(inventario.getProductos(), inventario.getTipos(), inventario.getMarcas(), inventario.getFacturas());
    }
    
    public static void main(String[] args) {
        Controller controller;
        try {
            controller = new Controller();
            controller.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}