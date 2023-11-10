package View.Form;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class TopLeftFormPanel extends JPanel{

    private Properties properties;
    private UtilDateModel model; 
    private JDatePanelImpl datePanel; 
    private JDatePickerImpl datePicker; 
    private JLabel lblid;
    private JLabel lblDate
    
    ;

    public TopLeftFormPanel(ActionListener listener) {
        this.setLayout(new GridLayout(2, 2));
        properties  = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        lblid = new JLabel("4132");
        add(lblid);

        model = new UtilDateModel();
        datePanel = new JDatePanelImpl(model, properties);
        datePicker = new JDatePickerImpl(datePanel, new DatalabelFormatter());
        model.setDate(2023, 12, 24);
        add(datePicker);
    }

    public Date selectedDate() {
        return (java.sql.Date) datePicker.getModel().getValue();
    }

}
