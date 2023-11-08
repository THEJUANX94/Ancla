package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class CenterPanel extends JPanel{

    private BillingPanel centerPanel1;
    private ManagePanel centerPanel2;
    private HistoryPanel historyPanel;
    private CardLayout cl;
    
    public CenterPanel(ActionListener listener){
        initComponents(listener);
    }

    public void initComponents(ActionListener listener){
        this.setBackground(Color.WHITE);
        this.setLayout(new CardLayout());
        cl = (CardLayout) this.getLayout();
        centerPanel1 = new BillingPanel(listener);
        centerPanel2 = new ManagePanel(listener);
        historyPanel = new HistoryPanel();

        add(centerPanel1, "Boton_Facturacion");
        add(centerPanel2, "Boton_Gestionar");
        add(historyPanel, "Pestaña_Historial");
    }

    public void show(String a) {
        cl.show(this, a);
    }
}
