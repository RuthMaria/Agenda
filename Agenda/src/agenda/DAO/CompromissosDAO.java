package agenda.DAO;

import agenda.Model.Compromisso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompromissosDAO extends GerenciaBD{
    
      public void salvar(Compromisso compromisso) throws SQLException {
        String inserir = "INSERT INTO COMPROMISSOS(tipo, data, hora, prioridade, id_compromisso) VALUES(?,?,?,?,?)";
        salvar(inserir, compromisso.getTipo(), compromisso.getData(), compromisso.getHora(), compromisso.getPrioridade(), compromisso.getId_compromisso());
    }
 
    public void alterar(Compromisso compromisso) throws SQLException {

        String alterar = "UPDATE COMPROMISSOS " +
                "SET tipo = ?, data = ?, hora = ?, prioridade = ?, id_prioridade = ?" +
                "WHERE id_contato = ?";

        alterar(alterar, compromisso.getTipo(),compromisso.getData(), compromisso.getHora(),
                compromisso.getPrioridade(), compromisso.getId_compromisso());
    }
    
    public void excluir(long id) throws SQLException {

        String delete = "DELETE FROM COMPROMISSOS WHERE id = ?";
        deletar(delete, id);
    }

    public List<Compromisso> findContatos() throws SQLException {
        List<Compromisso> compromissos = new ArrayList<Compromisso>();
         
        String select = "SELECT * FROM COMPROMISSOS";
 
        PreparedStatement stmt = getConnection().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Compromisso c = new Compromisso();
            c.setId_compromisso(rs.getLong("id_compromisso"));
            c.setTipo(rs.getString("tipo"));
            c.setData(rs.getString("data"));
            c.setHora(rs.getString("hora"));
            c.setPrioridade(rs.getString("prioridade"));
            compromissos.add(c);
        }

        rs.close();
        stmt.close();
        return compromissos;
    }
 
    public Compromisso findByName(String tipo) throws SQLException {

        String select = "SELECT * FROM COMPROMISSO WHERE tipo = ?";
        Compromisso compromisso = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setString(1, tipo);
        ResultSet rs = stmt.executeQuery();
 
        while (rs.next()) {

            compromisso = new Compromisso();
            compromisso.setId_compromisso(rs.getLong("id_compromisso"));
            compromisso.setTipo(rs.getString("tipo"));
            compromisso.setData(rs.getString("data"));
            compromisso.setHora(rs.getString("hora"));
            compromisso.setPrioridade(rs.getString("prioridade"));
        }
        rs.close();
        stmt.close();
        return compromisso;

}

       
}
