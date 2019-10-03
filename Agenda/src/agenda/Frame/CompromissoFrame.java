
package agenda.Frame;

import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import agenda.Model.Compromisso;
import agenda.OperacoesBD.ControleCompromissosBD;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;

public class CompromissoFrame extends  JPanel{

    private Agenda agenda;
    private JTextField txtTipo, txtLocalizar, txtId = new JTextField();
    private JLabel lbTipo, lbPrioridade, lbTitulo, lbData, lbHora;
    private JButton btnSalvar, btnAlterar, btnExcluir, btnClear, btnLocalizar,
            btnPrimeiro, btnProximo, btnAnterior, btnUltimo, btnVoltar;
    private JComboBox cbPrioridades;
    private JPanel plBotoes = new JPanel(), plTela = new JPanel(), 
            plLocalizar = new JPanel(), plRegistros = new JPanel();
    private MaskFormatter ftHora, ftData;
    private JFormattedTextField  txtData, txtHora;
    public int registroAtual = 0;
    public List<Compromisso> compromissosList = new ControleCompromissosBD().listaCompromissos();
    
    CompromissoFrame(Agenda agenda) throws ParseException{
        this.agenda = agenda;
        
        final String prioridades[] = {null, "Alta", "Média", "Baixa"};
        Border borda = (BorderFactory.createBevelBorder(EtchedBorder.LOWERED));
        lbTitulo = new JLabel("Cadastro de Compromissos");
        this.add(new JLabel((new ImageIcon(getClass().getResource("imagens/barra.png")))));        
        
        this.add(plRegistros);
        this.add(plTela);
        this.add(plLocalizar);
        this.add(plBotoes); 
        ftData = new MaskFormatter("##/##/####");
        ftHora = new MaskFormatter("##:##:##");
        ftData.setValidCharacters("0123456789"); 
        ftHora.setValidCharacters("0123456789");
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
        lbTipo = new JLabel("Tipo");txtTipo = new JTextField();
        lbData = new JLabel("Data");txtData = new JFormattedTextField(ftData);
        lbHora = new JLabel("Hora");txtHora = new JFormattedTextField(ftHora);
        lbPrioridade = new JLabel("Prioridade");cbPrioridades = new JComboBox(prioridades);
        lbTipo.setForeground(Color.BLACK);lbTipo.setFont(new Font("Courier New", Font.BOLD, 14));
        lbData.setForeground(Color.BLACK);lbData.setFont(new Font("Courier New", Font.BOLD, 14));
        lbPrioridade.setForeground(Color.BLACK);lbPrioridade.setFont(new Font("Courier New", Font.BOLD, 14));
        lbHora.setForeground(Color.BLACK);lbHora.setFont(new Font("Courier New", Font.BOLD, 14));
        lbTitulo.setForeground(Color.BLACK);lbTitulo.setFont(new Font("Arial", Font.BOLD, 17));
        plTela.add(lbTipo);plTela.add(txtTipo);
        plTela.add(lbData);plTela.add(txtData);
        plTela.add(lbHora);plTela.add(txtHora);
        plTela.add(lbPrioridade);plTela.add(cbPrioridades);
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
        JLabel lbLocalizar = new JLabel("Localizar por Tipo");
        txtLocalizar = new JTextField();
        txtLocalizar.setPreferredSize(new Dimension(257,30));
        lbLocalizar.setForeground(Color.BLACK);lbLocalizar.setFont(new Font("Courier New", Font.BOLD, 14));
        btnLocalizar = new JButton("Ir", new ImageIcon(getClass().getResource("imagens/ir.png")));
        plLocalizar.add(lbLocalizar);
        plLocalizar.add(txtLocalizar);
        plLocalizar.add(btnLocalizar);
        plLocalizar.setBorder(borda);
        setVisible(true);
        btnVoltar.addActionListener(
                new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent e) {
                try {
                    onClickVoltar();
                } catch (ParseException ex) {
                    Logger.getLogger(CompromissoFrame.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(CompromissoFrame.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(CompromissoFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(CompromissoFrame.class.getName()).log(Level.SEVERE, null, ex);
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
        if (index <= compromissosList.size() - 1) {
            Compromisso contatoAtual = compromissosList.get(index);
            txtTipo.setText(contatoAtual.getTipo());
            txtData.setText(contatoAtual.getData());
            txtHora.setText(contatoAtual.getHora());            
        }
    }
    private void onClickUltimo() {
        registroAtual = compromissosList.size() - 1;
        getValores(registroAtual);
        ControleCompromissosBD compromisso = new ControleCompromissosBD ();
        Compromisso  c = compromisso.listaCompromissos().get(registroAtual);
        String str = Long.toString(c.getId_compromisso());
        txtId.setText(str);
    }  
    
     private void onClickProximo() {
        if (registroAtual != compromissosList.size() - 1) {
            getValores(++registroAtual);
            ControleCompromissosBD compromissos = new ControleCompromissosBD ();
            Compromisso  c = compromissos.listaCompromissos().get(registroAtual);
            String str = Long.toString(c.getId_compromisso());
            txtId.setText(str);
        }
    }
    private void onClickAnterior() {
        if (registroAtual != 0) {
            getValores(--registroAtual);
            ControleCompromissosBD compromissos = new ControleCompromissosBD ();
            Compromisso  c = compromissos.listaCompromissos().get(registroAtual);
            String str = Long.toString(c.getId_compromisso());
            txtId.setText(str);
        }
    }
    private void onClickPrimeiro() {
        registroAtual = 0;
        getValores(registroAtual);
        ControleCompromissosBD compromissos = new ControleCompromissosBD ();
            Compromisso  c = compromissos.listaCompromissos().get(registroAtual);
            String str = Long.toString(c.getId_compromisso());
            txtId.setText(str);
    }
    
    private void onClickAlterar() throws ParseException, Exception {
        ControleCompromissosBD compromissos = new ControleCompromissosBD();
        long id = compromissosList.get(registroAtual).getId_compromisso();
        try {
            compromissos.alterar(id, txtTipo.getText(), txtData.getText(), txtHora.getText(), (String) cbPrioridades.getSelectedItem());
            JOptionPane.showMessageDialog(this, "alterado com sucesso!");
            clearFields();
            compromissosList = new ControleCompromissosBD().listaCompromissos();           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel alterar!\n" + e.getLocalizedMessage());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "CPF possui formato inválido!\n" + e.getLocalizedMessage());
        }
    }
    private void clearFields() {
        txtTipo.setText("");
        txtData.setText("");
        txtHora.setText("");
        txtLocalizar.setText("");
    }

    private void onClickSalvar() throws Exception {
        ControleCompromissosBD  compromissos = new ControleCompromissosBD();
        try {
            compromissos.salvar(txtTipo.getText(), txtData.getText(), txtHora.getText()
                    ,(String) cbPrioridades.getSelectedItem() );
            JOptionPane.showMessageDialog(this, "salvo com sucesso!");
            clearFields();
            compromissosList = new ControleCompromissosBD().listaCompromissos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel salvar!\n" + e.getLocalizedMessage());
        } catch (ParseException e) {
           JOptionPane.showMessageDialog(this, "Data possui formato inválido!\n" + e.getLocalizedMessage());
        }
    }
    
 
    private void onClickExcluir() {
        ControleCompromissosBD  compromissos = new ControleCompromissosBD ();
        long id = compromissosList.get(registroAtual).getId_compromisso();
        try {
            compromissos.excluir(id);
            JOptionPane.showMessageDialog(this, "excluido com sucesso!");
            clearFields();
            compromissosList = new ControleCompromissosBD().listaCompromissos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel excluir!\n" + e.getLocalizedMessage());
        }
    }

    private void onClickLocalizar() {
        ControleCompromissosBD compromissos = new ControleCompromissosBD ();
        try {
            Compromisso  c = compromissos.buscarCompromissoPorTipo((txtLocalizar.getText()));
            txtTipo.setText(c.getTipo());
            txtData.setText(c.getData());
            txtHora.setText(c.getHora());
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