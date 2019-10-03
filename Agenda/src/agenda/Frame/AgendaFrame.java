
package agenda.Frame;

import agenda.DAO.ContatosDAO;
import javax.swing.JPanel;
import javax.swing.JTable;
import agenda.Model.Contatos;
import agenda.OperacoesBD.ControleContatosBD;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
public class AgendaFrame extends JPanel{
    
    private JTable jtContatos, jtCompromissos;
    private  JScrollPane Scroll = new  JScrollPane();
    List<Contatos> contatos;
    DefaultTableModel tmContatos = new DefaultTableModel(null, new String[]{
                "Id", "Nome", "Telefone", "E-mail", "Grupo"});
    private JTabbedPane tpAbas;
    private JPanel pContatos, pCompromissos;
    private Agenda agenda;
    
    AgendaFrame(Agenda agenda){
        
        this.agenda = agenda;
        this.add(new JLabel((new ImageIcon(getClass().getResource("imagens/barra.png")))));
        int index = 0;
        ControleContatosBD cont = new ControleContatosBD();
        Contatos c = (Contatos) cont.listaContatos();
        if(contatos.size() == 0 ) 
                JOptionPane.showMessageDialog(null, "Não há Contatos Cadastrados!");
        else{
            while (index <= contatos.size() - 1){
                    tmContatos.addRow(new Object[]{c.getId_contato(), c.getNome(), c.getFone(), c.getEmail(), c.getGrupo()});
            }
        }
        
        JScrollPane scrollPane = new JScrollPane(jtContatos);
        add(jtContatos);
        add(scrollPane);
        
        
   }
}

    
