///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package projetopoo.negocio;
//
//import java.util.ArrayList;
//import projetopoo.acesso.DAOProduto;
//import projetopoo.acesso.IDAOProduto;
//import projetopoo.erro.ConexaoException;
//import projetopoo.erro.GeralException;
//import projetopoo.erro.RepositorioException;
//import projetopoo.negocio.basica.Produto;
//
///**
// *
// * @author victor
// */
//public class RNProduto {
//    private final IDAOProduto dao;
//    
//    public RNProduto(){
//        dao = new DAOProduto();
//    }
///*
//###########################################################
//FUNCIONALIDADES (servem a GUI)
//###########################################################
//*/
//    /**
//     * Valida um objeto e salva no BD
//     * @param p Obejto com os dados para salvar
//     * @throws GeralException Quando ocorre qualquer problema
//     */
//    public void salvarNovo(Produto p)throws GeralException{
//        validaPreenchimento(p);
//        validar(p);
//        duplicidade(p);
//        inserir(p);
//    }
//
//    public void salvarAlteracao(Produto p)throws GeralException{
//        validaPreenchimento(p);
//        validaID(p);
//        validar(p);
//        existe(p);
//        atualizar(p);
//    }
//    
//    public void excluirRegistro(Produto p)throws GeralException{
//        validaID(p);
//        existe(p);
//        excluir(p);
//    }
//    
//    public ArrayList<Produto> listarTodos()throws GeralException{
//        return listar();
//    }
//    
//    public Produto pesquisarNome(Produto a)throws GeralException{
//        return pesquisar(a.getNome());
//    }
//
//    public Produto pesquisarCodigo(Produto p)throws GeralException{
//        return pesquisar(p.getIdProduto());
//    }
///*
//###########################################################
//FUNÇÕES INTERNAS (fragmentação dos métodos)
//###########################################################
//*/
//    //verificar preenchimento -> campos obrigatórios
//    private void validaPreenchimento(Produto p)throws GeralException{
//        if(p==null)
//            throw new GeralException("Objeto invalido");
//        if(!p.isValido())
//            throw new GeralException("Preenchimento invalido");
//    }
//
//    //validar -> valores dentro da regra (nome)
//    private void validar(Produto a)throws GeralException{
//        if(a.getNome().trim().length()<=2)
//            throw new GeralException("Nome invalido");
//    }
//    
//    private void duplicidade(Produto p)throws GeralException{
//        if(pesquisar(p.getNome())!=null)
//            throw new GeralException("Nome já existe");
//    }
//    
//    private void existe(Produto p)throws GeralException{
//        if(pesquisar(p.getIdProduto())==null)
//            throw new GeralException("Produto INVALIDO");
//    }
//    
//    //verificar duplicidade (bd)
//    private Produto pesquisar(Integer codigo)throws GeralException{
//        try{
//            return dao.pesquisar(codigo);
//        }catch(ConexaoException e){
//            throw new GeralException("Tente novamente mais tarde");
//        }catch(RepositorioException e){
//            throw new GeralException("Entre em contato com o Suporte");
//        }
//                
//    }
//    
//    private Produto pesquisar(String nome)throws GeralException{
//        try{
//            return dao.pesquisar(nome);
//        }catch(ConexaoException e){
//            throw new GeralException("Tente novamente mais tarde");
//        }catch(RepositorioException e){
//            throw new GeralException("Entre em contato com o Suporte");
//        }
//                
//    }
//    
//    //inserir
//    private void inserir(Produto p)throws GeralException{
//        try{
//            dao.inserir(p);
//        }catch(ConexaoException e){
//            throw new GeralException("Tente novamente mais tarde");
//        }catch(RepositorioException e){
//            throw new GeralException("Entre em contato com o Suporte");
//        }
//    }
//
//    private void atualizar(Produto p)throws GeralException{
//        try{
//            dao.alterar(p);
//        }catch(ConexaoException e){
//            throw new GeralException("Tente novamente mais tarde");
//        }catch(RepositorioException e){
//            throw new GeralException("Entre em contato com o Suporte");
//        }
//    }
//
//    private void excluir(Produto a)throws GeralException{
//        try{
//            dao.excluir(a);
//        }catch(ConexaoException e){
//            throw new GeralException("Tente novamente mais tarde");
//        }catch(RepositorioException e){
//            throw new GeralException("Entre em contato com o Suporte");
//        }
//    }
//
//    private void validaID(Produto p)throws GeralException {
//        if((p.getIdProduto()==null)||(p.getIdProduto()==0))
//            throw new GeralException("Codigo invalido");
//    }
//    
//    private ArrayList<Produto> listar()throws GeralException{
//        try{
//            return dao.listar();
//        }catch(ConexaoException e){
//            throw new GeralException("Tente novamente mais tarde");
//        }catch(RepositorioException e){
//            throw new GeralException("Entre em contato com o Suporte");
//        }
//                
//    }
//}
//
//    
