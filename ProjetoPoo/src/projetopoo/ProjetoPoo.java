/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import javax.swing.JOptionPane;
import projetopoo.erro.GeralException;
import projetopoo.fachada.Fachada;
import projetopoo.gui.TClienteCastro;
import projetopoo.gui.TProdutoCadastro;
import projetopoo.negocio.basica.Produto;

/**
 *
 * @author fabiano
 */
public class ProjetoPoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //TClienteCastro TelaCadastroCliente = new TClienteCastro();
        //TelaCadastroCliente.setVisible(true);
        //TelaCadastroCliente.setTitle("Cadastro de Clientes");
        //TelaCadastroCliente.setResizable(false);
        
        TProdutoCadastro telaCadastroProduto = new TProdutoCadastro();
        telaCadastroProduto.setVisible(true);
        //telaCadastroProduto.setTitle("Cadastro de Produto");
        //TelaCadastroProduto.setResizable(false);
        /*
        Fachada fachada = Fachada.getInstancia();
        Produto produto = new Produto();
        
        produto.setIdFornecedor(1);
        produto.setNome("Manteiga");
        produto.setDescricao("Pastosa");
        try{
            fachada.salvarNovoProduto(produto);
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso");
        }
        catch(GeralException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        */
    }
    
}
