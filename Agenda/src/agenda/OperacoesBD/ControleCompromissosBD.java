
package agenda.OperacoesBD;

import java.sql.SQLException;
import java.text.ParseException;
import agenda.DAO.CompromissosDAO;
import agenda.Model.Compromisso;
import java.util.List;
import javax.swing.JOptionPane;

public class ControleCompromissosBD {
    
    public void salvar(String tipo, String data, String hora, String prioridade) throws SQLException, ParseException, Exception {
        Compromisso conpromisso = new Compromisso();
        conpromisso.setTipo(tipo);
        conpromisso.setData(data);
        conpromisso.setHora(hora);
        conpromisso.setPrioridade(prioridade);
        new CompromissosDAO().salvar(conpromisso);
    }
 
    public void alterar(long id, String tipo, String data, String hora, String prioridade) throws ParseException, SQLException, Exception {
        Compromisso compromisso = new Compromisso();
        compromisso.setId_compromisso(id);
        compromisso.setTipo(tipo);
        compromisso.setData(data);
        compromisso.setHora(hora);
        compromisso.setPrioridade(prioridade);
        new CompromissosDAO().alterar(compromisso);
        

    }

    public List<Compromisso> listaCompromissos() {
        CompromissosDAO dao = new CompromissosDAO();
        try {
            return dao.findContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar\n" + e.getLocalizedMessage());
        }
        return null;
    }

    public void excluir(long id) throws SQLException {
        new CompromissosDAO().excluir(id);
    }
    public Compromisso buscarCompromissoPorTipo(String tipo) throws SQLException {
        CompromissosDAO dao = new CompromissosDAO();
        return dao.findByName(tipo);
    }
    
}

    

