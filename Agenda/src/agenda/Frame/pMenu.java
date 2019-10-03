package agenda.Frame;

import agenda.Frame.Agenda;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class pMenu extends JPanel{
    
   private JPanel botoes = new JPanel(), centro = new JPanel();
   private JButton sair = new JButton
                ("Sair", new ImageIcon(getClass().getResource("imagens/sair.png")));
   private JButton agenda = new JButton
                ("Agenda", new ImageIcon(getClass().getResource("imagens/agenda.png")));
   private JButton compromisso = new JButton
                (new ImageIcon(getClass().getResource("imagens/compromisso.png")));
   private JButton contatos = new JButton
                (new ImageIcon(getClass().getResource("imagens/contatos.png")));
   private JButton sobre = new JButton
                ("Sobre", new ImageIcon(getClass().getResource("imagens/sobre.png")));
   private Agenda Agenda;   
   
    pMenu(agenda.Frame.Agenda aThis) {
       super();
       this.Agenda = aThis;
       setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));  
       Border borda = BorderFactory.createBevelBorder(EtchedBorder.LOWERED);
       this.add(new JLabel((new ImageIcon(getClass().getResource("imagens/barra.png")))));
       setBackground(new Color(85,85,255));
       botoes.setLayout(new GridLayout(1,5));
       //botoes.setBorder(borda);
       
       centro.setLayout(new FlowLayout(FlowLayout.LEFT, 50,43));
       centro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));  
       compromisso.setRolloverIcon(new ImageIcon(getClass().getResource("imagens/compInativo.png"))); 
       compromisso.setRolloverIcon(new ImageIcon(getClass().getResource("imagens/compAtivo.png"))); 
       compromisso.setPressedIcon(new ImageIcon(getClass().getResource("imagens/compAtivo.png")));
       compromisso.addActionListener(new onCompromisso());
       contatos.setRolloverIcon(new ImageIcon(getClass().getResource("imagens/contInativo.png"))); 
       contatos.setRolloverIcon(new ImageIcon(getClass().getResource("imagens/contAtivo.png"))); 
       contatos.setPressedIcon(new ImageIcon(getClass().getResource("imagens/contAtivo.png")));
       contatos.addActionListener(new onContatos());
       centro.add(compromisso);
       //centro.setBorder(borda);
       centro.add(contatos);
       botoes.setPreferredSize(new Dimension(465,70));
       botoes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));  
       agenda.addActionListener(new onAgenda());
       botoes.add("South",agenda);
       sobre.addActionListener(new onSobre());
       botoes.add("South",sobre);
       sair.addActionListener(new onSair());
       botoes.add("South", sair);
       this.add(centro);
       this.add(botoes);       
   }

       
   private class onSair implements ActionListener {

        @Override
        public  void actionPerformed( ActionEvent event ){
                System.exit(0);
            
        }
    
    }
   private class onContatos implements ActionListener {

        @Override
        public  void actionPerformed( ActionEvent event ){
            try {
                new Agenda(1);
            } catch (ParseException ex) {
                Logger.getLogger(pMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
                Agenda.desativa();
            
        }
    
    }
   private class onCompromisso implements ActionListener {

        @Override
        public  void actionPerformed( ActionEvent event ){
            try {
                new Agenda(2);
            } catch (ParseException ex) {
                Logger.getLogger(pMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
                Agenda.desativa();
            
        }
    
    }
    private class onAgenda implements ActionListener {

        @Override
        public  void actionPerformed( ActionEvent event ){
            try {
                new Agenda(3);
            } catch (ParseException ex) {
                Logger.getLogger(pMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
                Agenda.desativa();
            
        }
    
    }
   
    private class onSobre implements ActionListener {

        @Override
        public  void actionPerformed( ActionEvent event ){
            SobreFrame sf = new SobreFrame(); 
            sf.setSize(500, 450);
            sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sf.setResizable(false);
            sf.setLocationRelativeTo(null);
            sf.setVisible(true);
            }
                
            
        }
    
  }

