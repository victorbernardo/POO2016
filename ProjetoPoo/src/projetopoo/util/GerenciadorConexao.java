package projetopoo.util;

import projetopoo.erro.ConexaoException;
import java.sql.Connection;

/**
 *
 * @author Tito
 */
public interface GerenciadorConexao {
    
    /**
     * Retorna uma conexao com o BD
     * @return 
     * @throws projetopoo.erro.ConexaoException 
     */
    public Connection conectar() throws ConexaoException;
    
    /**
     * Desconecta do BD
     * @param c 
     * @throws projetopoo.erro.ConexaoException 
     */
    public void desconectar(Connection c) throws ConexaoException;
    
}
