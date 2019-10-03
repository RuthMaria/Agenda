
package agenda.Frame;

import agenda.Frame.Agenda;
import javax.swing.JPanel;
import agenda.Model.Contatos;
import agenda.OperacoesBD.ControleContatosBD;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;
public class ContatosFrame extends JPanel{
    
    
    private JTextField txtNome, txtEmail, txtLocalizar, txtId = new JTextField();
    private JFormattedTextField txtFone;
    private JLabel lbNome, lbFone, lbEmail, lbGrupo, lbTitulo;
    private JButton btnSalvar, btnAlterar, btnExcluir, btnClear, btnLocalizar,
            btnPrimeiro, btnProximo, btnAnterior, btnUltimo, btnVoltar;
    private JComboBox cbGrupo;
    private JPanel plBotoes = new JPanel(), plTela = new JPanel(), 
            plLocalizar = new JPanel(), plRegistros = new JPanel();
    private MaskFormatter ftFone;
    public int registroAtual = 0;
    public List<Contatos> contatosList = new ControleContatosBD().listaContatos();
    private Agenda agenda;
    
    ContatosFrame(Agenda aThis) throws ParseException {
        this.agenda = aThis;   
        final String grupos[] = {null, "Favoritos", "Amigos", "Trabalho", "Escola", "Família" };
        Border borda = (BorderFactory.createBevelBorder(EtchedBorder.LOWERED));
        lbTitulo = new JLabel("Cadastro de Contatos");
        this.add(new JLabel((new ImageIcon(getClass().getResource("imagens/barra.png")))));        
        
        this.add(plRegistros);
        this.add(plTela);
        this.add(plLocalizar);
        this.add(plBotoes); 
        ftFone = new MaskFormatter("(##)####-####");
        ftFone.setValidCharacters("0123456789"); 
        txtFone = new JFormattedTextField(ftFone);
        
        plTela.setPreferredSize(new Dimension(480,150));
        plLocalizar.setPreferredSize(new Dimension(480,50));
        plTela.setBorder(borda);
        plBotoes.setLayout(new GridLayout(1,4,5,20));
        plBotoes.setPreferredSize(new Dimension(480,50));
        plBotoes.setBorder(borda);
        plTela.setLayout(new GridLayout(5,2));
        
        plRegistros.setLayout(new  FlowLayout(FlowLayout.LEFT));
        plRegistros.setPreferredSize(new Dimension(480,50));
        plLocalizar.setLayout(new FlowLayout(FlowLayout.LEFT, 0,11));
        lbNome = new JLabel("Nome");txtNome = new JTextField();
        lbFone = new JLabel("Fome");
        lbEmail = new JLabel("e-mail");txtEmail = new JTextField();
        lbGrupo = new JLabel("Grupo");cbGrupo = new JComboBox(grupos);
        lbNome.setForeground(Color.BLACK);lbNome.setFont(new Font("Courier New", Font.BOLD, 14));
        lbFone.setForeground(Color.BLACK);lbFone.setFont(new Font("Courier New", Font.BOLD, 14));
        lbGrupo.setForeground(Color.BLACK);lbGrupo.setFont(new Font("Courier New", Font.BOLD, 14));
        lbEmail.setForeground(Color.BLACK);lbEmail.setFont(new Font("Courier New", Font.BOLD, 14));
        lbTitulo.setForeground(Color.BLACK);lbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        plTela.add(lbNome);plTela.add(txtNome);
        plTela.add(lbFone);plTela.add(txtFone);
        plTela.add(lbEmail);plTela.add(txtEmail);
        plTela.add(lbGrupo);plTela.add(cbGrupo);
        btnSalvar = new JButton("Salvar", new ImageIcon(getClass().getResource("imagens/salvar.png")));
        btnAlterar = new JButton("Alterar", new ImageIcon(getClass().getResource("imagens/atualizar.png")));
        btnExcluir = new JButton("Excluir", new ImageIcon(getClass().getResource("imagens/deletar.png")));
        btnClear = new JButton("Limpar", new ImageIcon(getClass().getResource("imagens/limpar.png")));
        btnPrimeiro = new JButton(new ImageIcon(getClass().getResource("imagens/primeiro.png")));
        btnAnterior = new JButton(new ImageIcon(getClass().getResource("imagens/anterior.png")));
        btnProximo = new JButton(new ImageIcon(getClass().getResource("imagens/proximo.png")));
        btnUltimo = new JButton(new ImageIcon(getClass().getResource("imagens/ultimo.png")));
        btnLocalizar = new JButton("Localizar", new ImageIcon(getClass().getResource("imagens/localizar.png")));
        btnVoltar = new JButton("Voltar", new ImageIcon(getClass().getResource("imagens/voltar.png")));
        plBotoes.add(btnSalvar);plBotoes.add(btnAlterar);
        plBotoes.add(btnExcluir);plBotoes.add(btnVoltar);
        plRegistros.add(lbTitulo);plRegistros.add(btnPrimeiro);
        plRegistros.add(btnAnterior);
        txtId.setPreferredSize(new Dimension(50,30));
        plRegistros.add(txtId);plRegistros.add(btnProximo);
        plRegistros.add(btnUltimo);
        plRegistros.setBorder(borda);
        plBotoes.add(btnClear);
        JLabel lbLocalizar = new JLabel("Localizar por nome");
        txtLocalizar = new JTextField();
        txtLocalizar.setPreferredSize(new Dimension(252,30));
        lbLocalizar.setForeground(Color.BLACK);lbLocalizar.setFont(new Font("Courier New", Font.BOLD, 14));
        btnLocalizar = new JButton("Ir", new ImageIcon(getClass().getResource("imagens/ir.png")));
        plLocalizar.add(lbLocalizar);
        plLocalizar.add(txtLocalizar);
        plLocalizar.add(btnLocalizar);
        plLocalizar.setBorder(borda);
        setVisible(true);
        
        btnVoltar.addActionListener(new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent e) {
                try {
                    onClickVoltar();
                } catch (ParseException ex) {
                    Logger.getLogger(ContatosFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
                }
        );
        btnAnterior.addActionListener(
                new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent e) {
                        onClickAnterior();
                    }
                }
        );
 
        btnProximo.addActionListener(
                new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent e) {
                        onClickProximo();
                    }
                }
        );
        btnLocalizar.addActionListener(
                new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent e) {
                        onClickLocalizar();
                    }
                }
        );
        btnSalvar.addActionListener(
                new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent e) {
                try {
                    onClickSalvar();
                } catch (Exception ex) {
                    Logger.getLogger(ContatosFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
                }
        );
 
       btnAlterar.addActionListener(
                new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent e) {
                try {
                    onClickAlterar();
                } catch (ParseException ex) {
                    Logger.getLogger(ContatosFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ContatosFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
             }
        );
        btnExcluir.addActionListener(
                new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent e) {
                        onClickExcluir();
                    }
                }
        );
 
        btnPrimeiro.addActionListener(
                new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent e) {
                        onClickPrimeiro();
                    }
                }
        );
        
        btnUltimo.addActionListener(
                new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent e) {
                        onClickUltimo();
                    }
                }
        );
        btnClear.addActionListener(
                new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent e) {
                        clearFields();
                        registroAtual = 0;
                    }
              }

    );
    }
     
   
   private void getValores(int index) {
        if (index <= contatosList.size() - 1) {
            Contatos contatoAtual = contatosList.get(index);
            txtNome.setText(contatoAtual.getNome());
            txtFone.setText(contatoAtual.getFone());
            txtEmail.setText(contatoAtual.getEmail());            
        }
    }
    private void onClickUltimo() {
        registroAtual = contatosList.size() - 1;
        getValores(registroAtual);
        ControleContatosBD contatos = new ControleContatosBD ();
        Contatos  c = contatos.listaContatos().get(registroAtual);
        String str = Long.toString(c.getId_contato());
        txtId.setText(str);
    }  
    
     private void onClickProximo() {
        if (registroAtual != contatosList.size() - 1) {
            getValores(++registroAtual);
            ControleContatosBD contatos = new ControleContatosBD ();
            Contatos  c = contatos.listaContatos().get(registroAtual);
            String str = Long.toString(c.getId_contato());
            txtId.setText(str);
        }
    }
    private void onClickAnterior() {
        if (registroAtual != 0) {
            getValores(--registroAtual);
            ControleContatosBD contatos = new ControleContatosBD ();
            Contatos  c = contatos.listaContatos().get(registroAtual);
            String str = Long.toString(c.getId_contato());
            txtId.setText(str);
        }
    }
    private void onClickPrimeiro() {
        registroAtual = 0;
        getValores(registroAtual);
        ControleContatosBD contatos = new ControleContatosBD ();
            Contatos  c = contatos.listaContatos().get(registroAtual);
            String str = Long.toString(c.getId_contato());
            txtId.setText(str);
    }
    
    private void onClickAlterar() throws ParseException, Exception {
        ControleContatosBD contatos = new ControleContatosBD();
        long id = contatosList.get(registroAtual).getId_contato();
        try {
            contatos.alterar(id, txtNome.getText(), txtFone.getText(), txtEmail.getText(), (String) cbGrupo.getSelectedItem());
            JOptionPane.showMessageDialog(this, "alterado com sucesso!");
            clearFields();
            contatosList = new ControleContatosBD().listaContatos();           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel alterar!\n" + e.getLocalizedMessage());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Tetefone inválido possui formato inválido!\n" + e.getLocalizedMessage());
        }
     
    }
    private void clearFields() {
        txtNome.setText("");
        txtFone.setText("");
        txtEmail.setText("");
        txtLocalizar.setText("");
    }

    private void onClickSalvar() throws Exception {
        ControleContatosBD  contatos = new ControleContatosBD();
        try {
            contatos.salvar(txtNome.getText(), txtFone.getText(), txtEmail.getText(),(String) cbGrupo.getSelectedItem() );
            JOptionPane.showMessageDialog(this, "salvo com sucesso!");
            clearFields();
            contatosList = new ControleContatosBD().listaContatos(); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel salvar contato!\n" + e.getLocalizedMessage());
        } catch (ParseException e) {
           JOptionPane.showMessageDialog(this, "Data possui formato inválido!\n" + e.getLocalizedMessage());
        }
    
    }
 
    private void onClickExcluir() {
        ControleContatosBD  contatos = new ControleContatosBD ();
        long id = contatosList.get(registroAtual).getId_contato();
        try {
            contatos.excluir(id);
            JOptionPane.showMessageDialog(this, "excluido com sucesso!");
            clearFields();
            contatosList = new ControleContatosBD().listaContatos(); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel excluir!\n" + e.getLocalizedMessage());
        }
    }

    private void onClickLocalizar() {
        ControleContatosBD contatos = new ControleContatosBD ();
        try {
            Contatos  c = contatos.buscarContatosPorNome((txtLocalizar.getText()));
            txtNome.setText(c.getNome());
            txtFone.setText(c.getFone());
            txtEmail.setText(c.getEmail());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro, tente novamente!\n" + e.getLocalizedMessage());
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, "Conatato não localizdo ou não existe!\n" + e.getLocalizedMessage());
        }
    }  
    private void onClickVoltar() throws ParseException {
        agenda.desativa();
        new Agenda(0);
    }
}  