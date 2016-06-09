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
import projetopoo.negocio.basica.Fornecedor;
import projetopoo.util.GerenciadorConexao;
import projetopoo.util.GerenciadorConexaoMySQL;

/**
 *
 * @author fabiano
 */
public class DAOFornecedor implements IDAOFornecedor{
    private final GerenciadorConexao GC = GerenciadorConexaoMySQL.getInstancia();

    @Override
    public void alterar(Fornecedor fornecedor) throws ConexaoException, RepositorioException {
       Connection c = GC.conectar();
        String sql = "UPDATE fornecedor SET RAZAOSOCIAL=?, CNPJ=?, ENDERECO=?, TELEFONE=? WHERE ID_FORNECEDOR = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, fornecedor.getRazaoSocial());
            pstm.setString(2, fornecedor.getCpnj());
            pstm.setString(3, fornecedor.getEndereco());
            pstm.setString(4, fornecedor.getTelefone());
            pstm.setInt(5, fornecedor.getIdFornecedor());
            
            pstm.execute();
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }

    @Override
    public void inserir(Fornecedor fornecedor) throws ConexaoException, RepositorioException {
               Connection c = GC.conectar();
        String sql = "INSERT INTO CLIENTE (RAZAOSOCIAL, CNPJ, ENDERECO, TELEFONE) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, fornecedor.getRazaoSocial());
            pstm.setString(2, fornecedor.getCpnj());
            pstm.setString(3, fornecedor.getEndereco());
            pstm.setString(4, fornecedor.getTelefone());
            pstm.execute();
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }
     @Override
    public void excluir(Fornecedor fornecedor) throws ConexaoException, RepositorioException {
        Connection c = GC.conectar();
        String sql = "DELETE FROM CLIENTE WHERE id_Fornecedor=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, fornecedor.getIdFornecedor());
            pstm.execute();
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }

    @Override
    public void excluir(Integer id) throws ConexaoException, RepositorioException {
        Connection c = GC.conectar();
        String sql = "DELETE FROM Fornecedor WHERE id_Fornecedor=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }

    @Override
    public ArrayList<Fornecedor> listar() throws ConexaoException, RepositorioException {
       Connection c = GC.conectar();
        String sql = "SELECT ID_FORNECEDOR , RAZAOSOCIAL, CNPJ, ENDERECO, TELEFONE FROM Fornecedor";
        ArrayList<Fornecedor> lista = new ArrayList();
        try{
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                fornecedor.setCpnj(rs.getString("cnpj"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setTelefone(rs.getString("telefone"));
                                
                lista.add(fornecedor);
            }
            return lista;
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }

    @Override
    public Fornecedor pesquisar(Integer id) throws ConexaoException, RepositorioException {
          Connection c = GC.conectar();
        String sql = "SELECT ID_FORNECEDOR , RAZAOSOCIAL, CNPJ, CEP, ENDERECO, TELEFONE FROM Fornecedor WHERE Id_fornecedor=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            Fornecedor fornecedor = null;
            if(rs.next()){
                fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                fornecedor.setCpnj(rs.getString("cnpj"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setTelefone(rs.getString("telefone"));
            }
            return fornecedor;
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
        
    }

    @Override
    public Fornecedor pesquisar(String cnpj) throws ConexaoException, RepositorioException {
            Connection c = GC.conectar();
        String sql = "SELECT ID_FORNECEDOR , RAZAOSOCIAL, CNPJ,ENDERECO, TELEFONE FROM Fornecedor WHERE cnpj=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cnpj);
            ResultSet rs = pstm.executeQuery();
            Fornecedor fornecedor = null;
            if(rs.next()){
                fornecedor = new Fornecedor();
                fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
                fornecedor.setCpnj(rs.getString("cnpj"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setTelefone(rs.getString("telefone"));
            }
            return fornecedor;
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }

   
     
   
    
}
