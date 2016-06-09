/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo.acesso;

import java.util.ArrayList;
import projetopoo.erro.ConexaoException;
import projetopoo.erro.GeralException;
import projetopoo.erro.RepositorioException;
import projetopoo.negocio.basica.Pagamento;

/**
 *
 * @author aluno
 */
public interface IDAOPagamento {
     /**
     * Altera os dados de um Cliente no BD
     * @param a Objeto contendo todos os dados tratados e validados do Cliente
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public void alterar(Pagamento pagamento) throws ConexaoException,RepositorioException;
    
    /**
     * Apaga um Cliente no BD
     * @param a Objeto contendo todos os dados tratados e validados do Cliente
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public void excluir(Pagamento Pagamento) throws ConexaoException,RepositorioException;
    
    /**
     * Apaga um Cliente no BD
     * @param id Inteiro com o código do Cliente
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public void excluir(Integer id_pagamento) throws ConexaoException,RepositorioException;
    
    /**
     * Retorna a lista de animais
     * @return Lista com todos os animais do BD
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public ArrayList<Pagamento> listar() throws ConexaoException,RepositorioException;
    
    /**
     * Retorna o animal correspondente ao id passado
     * @return O Cliente
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public Pagamento pesquisar(Integer id_pagamento) throws ConexaoException,RepositorioException;
    void inserir(Pagamento pagamento)throws GeralException, ConexaoException,RepositorioException;
}

