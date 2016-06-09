package projetopoo.fachada;

import projetopoo.erro.GeralException;
import projetopoo.negocio.RNCliente;
import projetopoo.negocio.basica.Cliente;
import java.util.ArrayList;
import projetopoo.negocio.RNProduto;
import projetopoo.negocio.basica.Produto;

/**
 *
 * @author Adauto
 */
public class Fachada {
    private static Fachada instancia;
    private static RNCliente rnCliente;
    private static RNProduto rnProduto;
    
    private Fachada(){
        rnCliente = new RNCliente();
        rnProduto = new RNProduto();
    }
    
    public static Fachada getInstancia(){
        if(instancia==null) instancia=new Fachada();
        return instancia;
    }
    
    /**
     * Solicita a inclusao de novo registro no BD de Cliente
     * @param a Objeto com todos os dados
     * @throws GeralException 
     */
    public void  salvarNovoCliente(Cliente a) throws GeralException{
        rnCliente.salvarNovo(a);
    }
      public void  salvarNovoProduto(Produto p) throws GeralException{
        rnProduto.salvarNovo(p);
    }
    
    /**
     * Solicita a atualizacao dos dados no BD do Cliente
     * @param a Objeto com todos os dados, iniclusive o codigo
     * @throws GeralException 
     */
    public void salvarAlteracaoCliente(Cliente a) throws GeralException{
        rnCliente.salvarAlteracao(a);
    }
     public void salvarAlteracaoProduto(Produto p) throws GeralException{
        rnProduto.salvarAlteracao(p);
    }
    
    /**
     * Solicita a exclusao de um registro do BD de Cliente
     * @param a Objeto com o codigo do Cliente
     * @throws GeralException 
     */
    public void excluirCliente(Cliente a)throws GeralException{
        rnCliente.excluirRegistro(a);
    }
     public void excluirProduto(Produto p)throws GeralException{
        rnProduto.excluirRegistro(p);
    }
    
    /**
     * Retorna uma lista com todos os registros do BD de Cliente
     * @return Lista de Cliente
     * @throws GeralException 
     */
    public ArrayList<Cliente> listarTodosClientes()throws GeralException{
        return rnCliente.listarTodos();
    }
     public ArrayList<Produto> listarTodosProdutos()throws GeralException{
        return rnProduto.listarTodos();
    }
    
    /**
     * Retorna um registro do BD de Cliente
     * @param codigoCliente
     * @return Lista de Cliente
     * @throws GeralException 
     */
    public  Cliente pesqisaClientePorCodigo(int codigoCliente)throws GeralException{
        return rnCliente.pesquisarCodigo(codigoCliente);
    }
     /**
     * Retorna um registro do BD de Produto
     * @param codigoProduto
     * @return  Produto pelo id
     * @throws GeralException 
     */
    public  Produto pesqisaProdutoPorCodigo(Produto codigoProduto)throws GeralException{
        return rnProduto.pesquisarCodigo(codigoProduto);
    }
    /**
     * Retorna um registro do BD de Produto
     * @param nomeProduto
     * @return  Produto pelo nome
     * @throws GeralException 
     */
    public  Produto pesqisaProdutoPorNome(Produto nomeProduto)throws GeralException{
        return rnProduto.pesquisarNome(nomeProduto);
    }
    
    
    public Cliente pesquisaClientePorCpf(String cpf) throws GeralException
    {
        return rnCliente.pesquisarCpf(cpf);
    }
}
