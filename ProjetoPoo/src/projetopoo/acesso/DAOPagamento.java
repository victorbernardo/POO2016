/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo.acesso;
import java.util.ArrayList;
import projetopoo.erro.ConexaoException;
import projetopoo.erro.RepositorioException;
import projetopoo.negocio.basica.Pagamento;
/**
 *
 * @author aluno
 */
public class DAOPagamento implements IDAOPagamento{

    @Override
    public void alterar(Pagamento pagamento) throws ConexaoException, RepositorioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Pagamento Pagamento) throws ConexaoException, RepositorioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Integer id_pagamento) throws ConexaoException, RepositorioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pagamento> listar() throws ConexaoException, RepositorioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pagamento pesquisar(Integer id_pagamento) throws ConexaoException, RepositorioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
