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

    /**
     *
     * @param p
     * @throws ConexaoException
     * @throws RepositorioException
     */
    @Override
    public void inserir(Produto p) throws ConexaoException, RepositorioException {
        Connection c = GC.conectar();
        String sql = "INSERT INTO produto(id_Fornecedor,Nome, Descricao) VALUES (?,?,?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, p.getIdFornecedor());
            pstm.setString(2, p.getNome());
            pstm.setString(3, p.getDescricao());
           
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
    public Produto pesquisar(Integer id) throws ConexaoException, RepositorioException {
        Produto p = null;
        String sql = "SELECT IdProduto, nome, idFornecedor, Qtd FROM produto WHERE idProduto=?";
        try{
            PreparedStatement pstm = GC.conectar().prepareStatement(sql);
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if(rs.next()){
                    p = new Produto();
                    p.setIdProduto(rs.getInt("codigo"));
                    p.setNome(rs.getString("nome"));
                    p.setIdFornecedor(rs.getInt("fornecedor"));
                }
            }
            return p;
        }catch(SQLException e){
            throw new RepositorioException();
        }
    }

    @Override
    public Produto pesquisar(String nome) throws ConexaoException, RepositorioException {
        Produto p = null;
        String sql = "SELECT Id_produto, Nome,Descricao, id_Fornecedor FROM produto WHERE Nome=?";
        try{
            PreparedStatement pstm = GC.conectar().prepareStatement(sql);
            pstm.setString(1, nome);
            try (ResultSet rs = pstm.executeQuery()) {
                if(rs.next()){
                    p = new Produto();
                    p.setIdProduto(rs.getInt("codigo"));
                    p.setNome(rs.getString("nome"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setIdFornecedor(rs.getInt("fornecedor"));
                }
            }
            return p;
        }catch(SQLException e){
            throw new RepositorioException();
        }
    }
    
    
}
