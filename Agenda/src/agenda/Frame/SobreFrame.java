package agenda.Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class SobreFrame extends JFrame{
    
       
    SobreFrame(){
        setLayout(new BorderLayout());
        this.add(new JLabel((new ImageIcon(getClass().getResource("imagens/barra.png")))));
        this.add(new JLabel((new ImageIcon(getClass().getResource("imagens/sobreApl.png")))));
        this.add(BorderLayout.SOUTH, new JLabel(new ImageIcon(getClass().getResource("imagens/logo.png"))));
        this.add(BorderLayout.SOUTH, new JLabel("© 2011 || Gisela Cesario"));
       
        
    }
    
}
