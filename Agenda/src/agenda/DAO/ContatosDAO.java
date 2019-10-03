
package agenda.DAO;
import agenda.Model.Contatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatosDAO extends GerenciaBD{
    
       public void salvar(Contatos contatos) throws SQLException {
        String inserir = "INSERT INTO CONTATOS(nome, fone, email, grupo) VALUES(?,?,?,?)";
        salvar(inserir, contatos.getNome(), contatos.getFone(), contatos.getEmail(), contatos.getGrupo());
       }
 
    public void alterar(Contatos contatos) throws SQLException {

        String alterar = "UPDATE CONTATOS " +
                "SET nome = ?, fone = ?, email = ?, grupo = ?" +
                "WHERE id_contato = ?";

        alterar(alterar, contatos.getId_contato(), contatos.getNome()
                ,contatos.getFone(), contatos.getGrupo());
    }
    
    public void excluir(long id) throws SQLException {

        String delete = "DELETE FROM CONTATOS WHERE id = ?";
        deletar(delete, id);
    }

    public List<Contatos> findContatos() throws SQLException {
        List<Contatos> contatos = new ArrayList<Contatos>();
         
        String select = "SELECT * FROM CONTATOS";
 
        PreparedStatement stmt = getConnection().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Contatos c = new Contatos();
            c.setId_contato(rs.getLong("id_contato"));
            c.setNome(rs.getString("nome"));
            c.setFone(rs.getString("fone"));
            c.setEmail(rs.getString("email"));
            c.setGrupo(rs.getString("grupo"));
            contatos.add(c);
        }

        rs.close();
        stmt.close();
        return contatos;
    }
 
    public Contatos findByName(String nome) throws SQLException {

        String select = "SELECT * FROM CONTATOS WHERE nome = ?";
        Contatos contato = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
 
        while (rs.next()) {

            contato = new Contatos();
            contato.setId_contato(rs.getLong("id_contato"));
            contato.setNome(rs.getString("nome"));
            contato.setFone(rs.getString("fone"));
            contato.setEmail(rs.getString("email"));
            contato.setGrupo(rs.getString("grupo"));
        }
        rs.close();
        stmt.close();
        return contato;

}
    
}
