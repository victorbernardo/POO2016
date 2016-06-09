/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo.negocio;

import java.util.ArrayList;
import projetopoo.acesso.DAOPagamento;
import projetopoo.erro.ConexaoException;
import projetopoo.erro.GeralException;
import projetopoo.erro.RepositorioException;
import projetopoo.negocio.basica.Cliente;
import projetopoo.negocio.basica.Pagamento;
import projetopoo.negocio.basica.Produto;



public class RNPagamento {
    
    private final DAOPagamento dao;
    
    public RNPagamento(){
        dao = new DAOPagamento();
    }
/*
###########################################################
FUNCIONALIDADES (servem cliente GUI)
###########################################################
*/
    /**
     * Valida um objeto e salva no BD
     * @param pagamento Obejto com os dados para salvar
     * @throws GeralException Quando ocorre qualquer problema
     */
    public void salvarNovo(Pagamento pagamento)throws GeralException, ConexaoException, RepositorioException{
        validaPreenchimento(pagamento);
        validar(pagamento);
        inserir(pagamento);
    }

    public void salvarAlteracao(Pagamento pagamento)throws GeralException, RepositorioException, ConexaoException{
        validaPreenchimento(pagamento);
        validaID(pagamento);
        validar(pagamento);
        existe(pagamento);
        alterar(pagamento);
    }
    
    public void excluirRegistro(Pagamento pagamento)throws GeralException{
        validaID(pagamento);
        existe(pagamento);
        excluir(pagamento);
    }
    
    public ArrayList<Pagamento> listarTodos()throws GeralException{
        return listar();
    }
    
    public Pagamento pesquisarPagamento(Pagamento pagamento)throws GeralException{
        return pesquisar(pagamento.getId_pagamento());
    }

    public Pagamento pesquisarCodigo(Pagamento pagamento)throws GeralException{
        return pesquisar(pagamento.getId_pagamento());
    }
/*
###########################################################
FUNÇÕES INTERNAS (fragmentação dos métodos)
###########################################################
*/
    //verificar preenchimento -> campos obrigatórios
    private void validaPreenchimento(Pagamento pagamento)throws GeralException{
        if(pagamento==null)
            throw new GeralException("Objeto invalido");
        if(pagamento.getValor()==null)
            throw new GeralException("Valor invalido");
        if(pagamento.getTipo()==null)
            throw new GeralException("Tipo invalido");
    }

    //validar -> valores dentro da regra (cpf, dt_nasc,emai)
    private void validar(Pagamento pagamento)throws GeralException{
        if(pagamento.getValor()== null)
            throw new GeralException("Valor invalido");
    }
    
    
    
    private void existe(Pagamento pagamento)throws GeralException{
        if(pesquisar(pagamento.getId_pagamento())==null)
            throw new GeralException("Pagamento Invalido");
    }
    
    //verificar duplicidade (bd)
    private Pagamento pesquisar(Integer codigo)throws GeralException{
        try{
            return dao.pesquisar(codigo);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
                
    }
    
    private Pagamento pesquisar(int id_pagamento)throws GeralException{
        try{
            return dao.pesquisar(id_pagamento);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
                
    }
    
    //inserir
    private void inserir(Pagamento pagamento)throws GeralException, ConexaoException,RepositorioException {
        try{
            dao.inserir(pagamento);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
    }

    private void alterar(Pagamento pagamento)throws ConexaoException,RepositorioException, GeralException {
        try{
            dao.inserir(pagamento);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
    }

    private void excluir(Pagamento pagamento)throws GeralException{
        try{
            dao.excluir(pagamento);
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
    }

    private void validaID(Pagamento pagamento)throws GeralException {
        if(pagamento.getId_pagamento()==0)
            throw new GeralException("Codigo invalido");
    }
    
    private ArrayList<Pagamento> listar()throws GeralException{
        try{
            return dao.listar();
        }catch(ConexaoException e){
            throw new GeralException("Tente novamente mais tarde");
        }catch(RepositorioException e){
            throw new GeralException("Entre em contato com o Suporte");
        }
                
    }
    
}
