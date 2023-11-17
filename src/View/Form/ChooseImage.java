package View.Form;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.*;

public class ChooseImage extends JDialog{

    public JFileChooser image;
    private  String path = "";

    public ChooseImage(ActionListener listener){
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener){
        this.setBackground(new Color(217, 147, 255));
    }

    public String selection(){
        image = new JFileChooser();
        int result = image.showOpenDialog(this);
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "png", "jpeg");
        image.setFileFilter(imgFilter);
        image.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (result == JFileChooser.APPROVE_OPTION) {
            File fileName = image.getSelectedFile();

            if ((fileName != null)) {
                path = fileName.getAbsolutePath();
            }
            else{
                path = "src/images/sin-foto.png";
            }
        }
        add(image);
        return path;
    }

    public String imagePath(){
        return path;
    }
    
}
