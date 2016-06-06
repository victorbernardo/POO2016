package projetopoo.fachada;

import projetopoo.erro.GeralException;
import projetopoo.negocio.RNCliente;
import projetopoo.negocio.basica.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Adauto
 */
public class Fachada {
    private static Fachada instancia;
    private static RNCliente rnCliente;
    
    private Fachada(){
        rnCliente = new RNCliente();
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
    
    /**
     * Solicita a atualizacao dos dados no BD do Cliente
     * @param a Objeto com todos os dados, iniclusive o codigo
     * @throws GeralException 
     */
    public void salvarAlteracaoCliente(Cliente a) throws GeralException{
        rnCliente.salvarAlteracao(a);
    }
    
    /**
     * Solicita a exclusao de um registro do BD de Cliente
     * @param a Objeto com o codigo do Cliente
     * @throws GeralException 
     */
    public void excluirCliente(Cliente a)throws GeralException{
        rnCliente.excluirRegistro(a);
    }
    
    /**
     * Retorna uma lista com todos os registros do BD de Cliente
     * @return Lista de Cliente
     * @throws GeralException 
     */
    public ArrayList<Cliente> listarTodosClientes()throws GeralException{
        return rnCliente.listarTodos();
    }
    
    /**
     * Retorna um registro do BD de Cliente
     * @return Lista de Cliente
     * @throws GeralException 
     */
    public  Cliente pesqisaClientePorCodigo(int codigoCliente)throws GeralException{
        return rnCliente.pesquisarCodigo(codigoCliente);
    }
    public Cliente pesquisaClientePorCpf(String cpf) throws GeralException
    {
        return rnCliente.pesquisarCpf(cpf);
    }
}
