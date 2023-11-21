package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class AdverstingDialog extends JDialog{

    private JLabel txtLowQuantity;
    private JLabel adverstingIcon;
    private JButton bttClose;

    public AdverstingDialog(ActionListener listener){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("Advertencia");
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents(listener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener listener) {
        txtLowQuantity = new JLabel();
        txtLowQuantity.setHorizontalAlignment(JLabel.CENTER);
        add(txtLowQuantity, BorderLayout.CENTER);

        adverstingIcon = new JLabel(new ImageIcon("data\\Images\\pngwing.com.png"));
        adverstingIcon.setHorizontalAlignment(JLabel.CENTER);
        add(adverstingIcon, BorderLayout.NORTH);

        bttClose = new JButton("Cerrar");
        bttClose.addActionListener(listener);
        bttClose.setActionCommand("Cancelar");
        add(bttClose, BorderLayout.SOUTH);
    }

    public void lowQuantity(String product){
        txtLowQuantity.setText("El producto " + product + " esta escaso. Se recomienda reabastecimiento");
    }
    
}
