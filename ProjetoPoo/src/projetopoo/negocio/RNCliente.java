package projetopoo.negocio;

import projetopoo.acesso.DAOCliente;
import projetopoo.acesso.DAOCliente;
import projetopoo.erro.ConexaoException;
import projetopoo.erro.GeralException;
import projetopoo.erro.RepositorioException;
import projetopoo.negocio.basica.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Adauto
 */
public class RNCliente {
    private final DAOCliente dao;
    
    public RNCliente(){
        dao = new DAOCliente();
    }
/*
###########################################################
FUNCIONALIDADES (servem cliente GUI)
###########################################################
*/
    /**
     * Valida um objeto e salva no BD
     * @param cliente Obejto com os dados para salvar
     * @throws GeralException Quando ocorre qualquer problema
     */
    public void salvarNovo(Cliente cliente)throws GeralException{
        validaPreenchimento(cliente);
        validar(cliente);
        duplicidade(cliente);
        inserir(cliente);
    }

    public void salvarAlteracao(Cliente cliente)throws GeralException{
        validaPreenchimento(cliente);
        validaID(cliente);
        validar(cliente);
        existe(cliente);
        atualizar(cliente);
    }
    
    public void excluirRegistro(Cliente cliente)throws GeralException{
        validaID(cliente);
        existe(cliente);
        excluir(cliente);
    }
    
    public ArrayList<Cliente> listarTodos()throws GeralException{
        return listar();
    }
    
    public Cliente pesquisarCpf(Cliente cliente)throws GeralException{
        return pesquisar(cliente.getCpf());
    }

    public Cliente pesquisarCodigo(Cliente cliente)throws GeralException{
        return pesquisar(cliente.getIdCliente());
    }
/*
###########################################################
FUNÇÕES INTERNAS (fragmentação dos métodos)
###########################################################
*/
    //verificar preenchimento -> campos obrigatórios
    private void validaPreenchimento(Cliente cliente)throws GeralException{
        if(cliente==null)
            throw new GeralException("Objeto invalido");
        if(!cliente.isValido())
            throw new GeralException("Preenchimento invalido");
        if(cliente.getCpf()==null)
            throw new GeralException("Cpf invalida");
        if(cliente.getNome()==null)
            throw new GeralException("Nome invalido");
    }

    //validar -> valores dentro da regra (cpf, dt_nasc,emai)
    private void validar(Cliente cliente)throws GeralException{
        if(cliente.getNome().trim().length()<=4)
            throw new GeralException("Nome invalido");
        if(cliente.getCpf().trim().length()!=11)
            throw new GeralException("Cpf inválido");
    }
    
    private void duplicidade(Cliente cliente)throws GeralException{
        if(pesquisar(cliente.getCpf())!=null)
            throw new GeralException("Cpf já existe");
    }
    
    private void existe(Cliente cliente)throws GeralException{
        if(pesquisar(cliente.getIdCliente())==null)
            throw new GeralException("Cliente Invalido");
    }
    
    //verificar duplicidade (bd)
    private Cliente pesquisar(Integer codigo)throws GeralException{
        try{
            return dao.pesquisar(codigo);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
                
    }
    
    private Cliente pesquisar(String cpf)throws GeralException{
        try{
            return dao.pesquisar(cpf);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
                
    }
    
    //inserir
    private void inserir(Cliente cliente)throws GeralException{
        try{
            dao.inserir(cliente);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
    }

    private void atualizar(Cliente cliente)throws GeralException{
        try{
            dao.alterar(cliente);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
    }

    private void excluir(Cliente cliente)throws GeralException{
        try{
            dao.excluir(cliente);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
    }

    private void validaID(Cliente cliente)throws GeralException {
        if(cliente.getIdCliente()==0)
            throw new GeralException("Codigo invalido");
    }
    
    private ArrayList<Cliente> listar()throws GeralException{
        try{
            return dao.listar();
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
                
    }
}
