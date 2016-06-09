
package projetopoo.acesso;

import java.util.ArrayList;
import projetopoo.erro.ConexaoException;
import projetopoo.erro.RepositorioException;
import projetopoo.negocio.basica.Fornecedor;

/**
 *
 * @author Jorge
 */
public interface IDAOFornecedor {
      /**
     * Altera os dados de um Fornecedor no BD
     * @param a Objeto contendo todos os dados tratados e validados do Fornecedor
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public void alterar(Fornecedor fornecedor) throws ConexaoException,RepositorioException;
    
    /**
     * Apaga um Fornecedor no BD
     * @param a Objeto contendo todos os dados tratados e validados do Fornecedor
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public void inserir(Fornecedor fornecedor) throws ConexaoException,RepositorioException;
    
    /**
     * Apaga um Fornecedor no BD
     * @param id Inteiro com o código do Fornecedor
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
    public void excluir(Fornecedor fornecedor) throws ConexaoException,RepositorioException;
    
    /**
     * Retorna a lista de animais
     * @return Lista com todos os animais do BD
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public ArrayList<Fornecedor> listar() throws ConexaoException,RepositorioException;
    
    /**
     * Retorna o fornecedor correspondente ao id passado
     * @param id Filtro da consulta
     * @return O Fornecedor
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public Fornecedor pesquisar(Integer id) throws ConexaoException,RepositorioException;
    
    
    
    /**
     * Retorna o fornecedor correspondente ao id passado
     * @param cnpj Filtro da consulta
     * @return O Fornecedor
     * @throws projetopoo.erro.ConexaoException
     * @throws projetopoo.erro.RepositorioException
     */
    public Fornecedor pesquisar(String cnpj) throws ConexaoException,RepositorioException;
    
    
}