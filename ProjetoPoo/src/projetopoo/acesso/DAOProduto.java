/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo.acesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projetopoo.erro.ConexaoException;
import projetopoo.erro.RepositorioException;
import projetopoo.negocio.basica.Produto;
import projetopoo.util.GerenciadorConexao;
import projetopoo.util.GerenciadorConexaoMySQL;

/**
 *
 * @author victor
 */
public class DAOProduto implements IDAOProduto{
    private final GerenciadorConexao GC = GerenciadorConexaoMySQL.getInstancia();
    @Override
    public void inserir(Produto p) throws ConexaoException, RepositorioException {
        Connection c = GC.conectar();
        String sql = "INSERT INTO produto (Nome, IdFornecedor) VALUES (?,?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, p.getNome());
            pstm.setInt(2, p.getIdFornecedor());
           
            pstm.execute();
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }

    @Override
    public void excluir(Produto p) throws ConexaoException, RepositorioException {
        Connection c = GC.conectar();
        String sql = "DELETE FROM produto WHERE id_Produto=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, p.getIdProduto());
            pstm.execute();
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }

    @Override
    public void alterar(Produto p) throws ConexaoException, RepositorioException {
        Connection c = GC.conectar();
        String sql = "UPDATE produto SET NOME=?, IdFornecedor=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, p.getNome());
            pstm.setInt(2, p.getIdFornecedor());
           
            pstm.execute();
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }
    

    @Override
    public ArrayList<Produto> listar() throws ConexaoException, RepositorioException {
        Connection c = GC.conectar();
        String sql = "SELECT NOME FROM Produto";
        ArrayList<Produto> lista = new ArrayList();
        try{
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setIdFornecedor(rs.getInt("IdFornecedor"));
              
                
                
                lista.add(p);
            }
            return lista;
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }

    @Override
    public void buscar(Integer id) throws ConexaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
