
package agenda.OperacoesBD;
import agenda.DAO.ContatosDAO;
import agenda.Model.Contatos;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
        


public class ControleContatosBD {
    
      public void salvar(String nome, String fone, String email, String grupo) throws SQLException, ParseException, Exception {
        Contatos contatos = new Contatos();
        contatos.setNome(nome);
        contatos.setFone(fone);
        contatos.setEmail(email);
        contatos.setGrupo(grupo);
        new ContatosDAO().salvar(contatos);
    }
 
    public void alterar(long id, String nome, String fone, String email, String grupo) throws ParseException, SQLException, Exception {
        Contatos contatos = new Contatos();
        contatos.setId_contato(id);
        contatos.setNome(nome);
        contatos.setFone(fone);
        contatos.setEmail(email);
        contatos.setGrupo(grupo);
        new ContatosDAO().alterar(contatos);

    }

    public List<Contatos> listaContatos() {
        ContatosDAO dao = new ContatosDAO();
        try {
            return dao.findContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar contato\n" + e.getLocalizedMessage());
        }
        return null;
    }

    public void excluir(long id) throws SQLException {
        new ContatosDAO().excluir(id);
    }
    public Contatos buscarContatosPorNome(String nome) throws SQLException {
        ContatosDAO dao = new ContatosDAO();
        return dao.findByName(nome);
    }
    
}
