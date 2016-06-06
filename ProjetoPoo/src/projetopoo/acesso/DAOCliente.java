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
import projetopoo.negocio.basica.Cliente;
import projetopoo.util.GerenciadorConexao;
import projetopoo.util.GerenciadorConexaoMySQL;

/**
 *
 * @author fabiano
 */
public class DAOCliente implements IDAOCliente{
    private final GerenciadorConexao GC = GerenciadorConexaoMySQL.getInstancia();

    @Override
    public void alterar(Cliente cliente) throws ConexaoException, RepositorioException {
       Connection c = GC.conectar();
        String sql = "UPDATE cliente SET NOME=?, CPF=?, CEP=?, ENDERECO=?, TELEFONE=? WHERE ID_CLIENTE = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            pstm.setString(3, cliente.getCep());
            pstm.setString(4, cliente.getEndereco());
            pstm.setString(5, cliente.getTelefone());
            pstm.setInt(6, cliente.getIdCliente());
            
            pstm.execute();
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }

    @Override
    public void inserir(Cliente cliente) throws ConexaoException, RepositorioException {
               Connection c = GC.conectar();
        String sql = "INSERT INTO CLIENTE (NOME, CPF, CEP, ENDERECO, TELEFONE) VALUES (?,?, ?, ?, ?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCpf());
            pstm.setString(3, cliente.getCep());
            pstm.setString(4, cliente.getEndereco());
            pstm.setString(5, cliente.getTelefone());
            pstm.execute();
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }
     @Override
    public void excluir(Cliente cliente) throws ConexaoException, RepositorioException {
        Connection c = GC.conectar();
        String sql = "DELETE FROM CLIENTE WHERE id_Cliente=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, cliente.getIdCliente());
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
        String sql = "DELETE FROM Cliente WHERE id_Cliente=?";
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
    public ArrayList<Cliente> listar() throws ConexaoException, RepositorioException {
       Connection c = GC.conectar();
        String sql = "SELECT ID_CLIENTE , NOME, CPF, CEP, ENDERECO, TELEFONE FROM Cliente";
        ArrayList<Cliente> lista = new ArrayList();
        try{
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                                
                lista.add(cliente);
            }
            return lista;
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }

    @Override
    public Cliente pesquisar(Integer id) throws ConexaoException, RepositorioException {
          Connection c = GC.conectar();
        String sql = "SELECT ID_CLIENTE , NOME, CPF, CEP, ENDERECO, TELEFONE FROM Cliente WHERE Id_cliente=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            Cliente cliente = null;
            if(rs.next()){
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
            }
            return cliente;
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
        
    }

    @Override
    public Cliente pesquisar(String cpf) throws ConexaoException, RepositorioException {
            Connection c = GC.conectar();
        String sql = "SELECT ID_CLIENTE , NOME, CPF, CEP, ENDERECO, TELEFONE FROM Cliente WHERE cpf=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cpf);
            ResultSet rs = pstm.executeQuery();
            Cliente cliente = null;
            if(rs.next()){
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
            }
            return cliente;
        }catch(SQLException e){
            throw new RepositorioException();
        }finally{
            GC.desconectar(c);
        }
    }

   
     
   
    
}
