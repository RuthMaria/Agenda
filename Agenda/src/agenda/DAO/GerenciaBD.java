
package agenda.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciaBD {
    
    
    private Connection conexao;
 
    protected GerenciaBD(){
        
        this.conexao = (Connection) ConexaoBD.getConnection();
    }
 
    protected Connection getConnection() {
        return conexao;
    }
 
    protected void salvar(String insertSql, Object... parametros) throws SQLException {
        PreparedStatement pstmt = (PreparedStatement) getConnection().prepareStatement(insertSql);
 
        for (int i = 0; i < parametros.length; i++) {
        pstmt.setObject(i+1, parametros[i]);
        }
 
    pstmt.execute();
    pstmt.close();
    }
 
    protected void alterar(String updateSql, Object id, Object... parametros) throws SQLException {
    PreparedStatement pstmt = (PreparedStatement) getConnection().prepareStatement(updateSql);
    for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i+1, parametros[i]);
    }
    pstmt.setObject(parametros.length + 1, id);
    pstmt.execute();
    pstmt.close();
    }

    protected void deletar(String deleteSql, Object... parametros) throws SQLException {
    PreparedStatement pstmt = (PreparedStatement) getConnection().prepareStatement(deleteSql);
        for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i+1, parametros[i]);
    }
    pstmt.execute();
    pstmt.close();

    }
        
    
}
