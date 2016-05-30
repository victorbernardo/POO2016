package projetopoo.util;

import projetopoo.erro.ConexaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Tito
 */
public class GerenciadorConexaoMySQL implements GerenciadorConexao{
    private static GerenciadorConexaoMySQL instancia;
    private final String URL,NOME,SENHA;
    
    
    private GerenciadorConexaoMySQL(){
        ResourceBundle rb = ResourceBundle.getBundle("projetopoo.util.banco");
        URL = rb.getString("url");
        NOME = rb.getString("nome");
        SENHA = rb.getString("senha");
    }
    
    /**
     * Retorna uma instancia Singleton da Classe
     * @return 
     */
    public static GerenciadorConexaoMySQL getInstancia(){
        if(instancia==null) instancia = new GerenciadorConexaoMySQL();
        return instancia;
    }
    
    @Override
    public Connection conectar() throws ConexaoException {
        try{
            Connection c;
            c = DriverManager.getConnection(URL,NOME,SENHA);
            return c;
        }catch(SQLException e){
            throw new ConexaoException();
        }
    }

    @Override
    public void desconectar(Connection c) throws ConexaoException {
        try{
            c.close();
        }catch(SQLException e){
            throw new ConexaoException();
        }
    }
    
}
