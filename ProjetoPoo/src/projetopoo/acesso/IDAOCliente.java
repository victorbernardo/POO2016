/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo.acesso;

import java.util.ArrayList;
import projetopoo.erro.ConexaoException;
import projetopoo.erro.RepositorioException;
import projetopoo.negocio.basica.Cliente;

/**
 *
 * @author Adauto
 */
public interface IDAOCliente {
      /**
     * Altera os dados de um Cliente no BD
     * @param a Objeto contendo todos os dados tratados e validados do Cliente
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public void alterar(Cliente cliente) throws ConexaoException,RepositorioException;
    
    /**
     * Apaga um Cliente no BD
     * @param a Objeto contendo todos os dados tratados e validados do Cliente
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public void inserir(Cliente cliente) throws ConexaoException,RepositorioException;
    
    /**
     * Apaga um Cliente no BD
     * @param id Inteiro com o código do Cliente
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public void excluir(Integer id) throws ConexaoException,RepositorioException;
    
     /**
     * Apaga um Animal no BD
     * @param a Objeto contendo todos os dados tratados e validados do Animal
     * @throws ads02n2016.erro.ConexaoException
     * @throws ads02n2016.erro.RepositorioException
     */
    public void excluir(Cliente cliente) throws ConexaoException,RepositorioException;
    
    /**
     * Retorna a lista de animais
     * @return Lista com todos os animais do BD
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public ArrayList<Cliente> listar() throws ConexaoException,RepositorioException;
    
    /**
     * Retorna o cliente correspondente ao id passado
     * @param id Filtro da consulta
     * @return O Cliente
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public Cliente pesquisar(Integer id) throws ConexaoException,RepositorioException;
    
    
    
    /**
     * Retorna o cliente correspondente ao id passado
     * @param cpf Filtro da consulta
     * @return O Cliente
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public Cliente pesquisar(String cpf) throws ConexaoException,RepositorioException;
    
    
}
