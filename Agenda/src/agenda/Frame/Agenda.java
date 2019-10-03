
package agenda.Frame;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Agenda extends JFrame{
    
    
     JFrame f = new JFrame();
     Agenda(int num) throws ParseException{
         super("Minha Agenda");
         if (num == 0){
            System.out.println("Tela Inicial"); 
            f.setSize(500, 450);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            pMenu panel = new pMenu(this);
            Container pane1 = f.getContentPane();
            getContentPane().setLayout(new BorderLayout());
            pane1.add(panel);
            f.setVisible(true);
         }
         if (num == 1){
            System.out.println("Cadastro de Contatos");
            f.setSize(500, 450);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            ContatosFrame panel2 = new ContatosFrame(this);
            Container pane2 = f.getContentPane();
            getContentPane().setLayout(new BorderLayout());
            pane2.add(panel2);
            f.setVisible(true);
         }
         
         if (num == 2){
            System.out.println("Cadastro de Compromissos");
            f.setSize(500, 450);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            CompromissoFrame panel3 = new CompromissoFrame(this);
            Container pane3 = f.getContentPane();
            getContentPane().setLayout(new BorderLayout());
            pane3.add(panel3);
            f.setVisible(true);
         }
          if (num == 3){
            System.out.println("Ver Agenda");  
            f.setSize(500, 450);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            AgendaFrame panel4 = new AgendaFrame(this);
            Container pane4 = f.getContentPane();
            getContentPane().setLayout(new BorderLayout());
            pane4.add(panel4);
            f.setVisible(true);
         }
           
     }
     
    public void desativa(){
           f.setVisible(false);
       }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ParseException /*throws IOException*/ {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        new Agenda(0);
              
    }
   
}
