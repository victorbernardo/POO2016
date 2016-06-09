package projetopoo.negocio;

import projetopoo.acesso.DAOFornecedor;
import projetopoo.acesso.DAOFornecedor;
import projetopoo.erro.ConexaoException;
import projetopoo.erro.GeralException;
import projetopoo.erro.RepositorioException;
import projetopoo.negocio.basica.Fornecedor;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class RNFornecedor {
    private final DAOFornecedor dao;
    
    public RNFornecedor(){
        dao = new DAOFornecedor();
    }
/*
###########################################################
FUNCIONALIDADES (servem fornecedor GUI)
###########################################################
*/
    /**
     * Valida um objeto e salva no BD
     * @param fornecedor Obejto com os dados para salvar
     * @throws GeralException Quando ocorre qualquer problema
     */
    public void salvarNovo(Fornecedor fornecedor)throws GeralException{
        validaPreenchimento(fornecedor);
        validar(fornecedor);
        duplicidade(fornecedor);
        inserir(fornecedor);
    }

    public void salvarAlteracao(Fornecedor fornecedor)throws GeralException{
        validaPreenchimento(fornecedor);
        validaID(fornecedor);
        validar(fornecedor);
        existe(fornecedor);
        atualizar(fornecedor);
    }
    
    public void excluirRegistro(Fornecedor fornecedor)throws GeralException{
        validaID(fornecedor);
        existe(fornecedor);
        excluir(fornecedor);
    }
    
    public ArrayList<Fornecedor> listarTodos()throws GeralException{
        return listar();
    }
    
    public Fornecedor pesquisarCnpj(String cnpj)throws GeralException{
        return pesquisar(cnpj);
    }

    public Fornecedor pesquisarCodigo(int codigoFornecedor)throws GeralException{
        return pesquisar(codigoFornecedor);
    }
/*
###########################################################
FUNÇÕES INTERNAS (fragmentação dos métodos)
###########################################################
*/
    //verificar preenchimento -> campos obrigatórios
    private void validaPreenchimento(Fornecedor fornecedor)throws GeralException{
        if(fornecedor==null)
            throw new GeralException("Objeto invalido");
        if(!fornecedor.isValido())
            throw new GeralException("Preenchimento invalido");
        if(fornecedor.getCpnj()==null)
            throw new GeralException("Cnpj invalido");
        if(fornecedor.getRazaoSocial()==null)
            throw new GeralException("RazaoSocial invalido");
    }

    
    private void validar(Fornecedor fornecedor)throws GeralException{
        if(fornecedor.getRazaoSocial().trim().length()<=4)
            throw new GeralException("RazaoSocial invalido");
        if(fornecedor.getCpnj().trim().length()!=14)
            throw new GeralException("Cnpj inválido");
    }
    
    private void duplicidade(Fornecedor fornecedor)throws GeralException{
        if(pesquisar(fornecedor.getCpnj())!=null)
            throw new GeralException("Cnpj já existe");
    }
    
    private void existe(Fornecedor fornecedor)throws GeralException{
        if(pesquisar(fornecedor.getIdFornecedor())==null)
            throw new GeralException("Fornecedor Invalido");
    }
    
    //verificar duplicidade (bd)
    private Fornecedor pesquisar(Integer codigo)throws GeralException{
        try{
            return dao.pesquisar(codigo);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
                
    }
    
    private Fornecedor pesquisar(String cnpj)throws GeralException{
        try{
            return dao.pesquisar(cnpj);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
                
    }
    
    //inserir
    private void inserir(Fornecedor fornecedor)throws GeralException{
        try{
            dao.inserir(fornecedor);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
    }

    private void atualizar(Fornecedor fornecedor)throws GeralException{
        try{
            dao.alterar(fornecedor);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
    }

    private void excluir(Fornecedor fornecedor)throws GeralException{
        try{
            dao.excluir(fornecedor);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
    }

    private void validaID(Fornecedor fornecedor)throws GeralException {
        if(fornecedor.getIdFornecedor()==0)
            throw new GeralException("Codigo invalido");
    }
    
    private ArrayList<Fornecedor> listar()throws GeralException{
        try{
            return dao.listar();
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
                
    }
}
