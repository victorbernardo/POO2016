/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo.acesso;

import java.util.ArrayList;
import projetopoo.erro.ConexaoException;
import projetopoo.erro.RepositorioException;
import projetopoo.negocio.basica.Produto;

/**
 *
 * @author victor
 */
public interface IDAOProduto {
    public void inserir(Produto p) throws ConexaoException, RepositorioException;
    public void excluir(Produto p)throws ConexaoException, RepositorioException;
    public void alterar(Produto p)throws ConexaoException, RepositorioException;
    public ArrayList<Produto> listar()throws ConexaoException, RepositorioException;
    public Produto pesquisar(Integer id) throws ConexaoException,RepositorioException;
    public Produto pesquisar(String nome) throws ConexaoException,RepositorioException;
}
