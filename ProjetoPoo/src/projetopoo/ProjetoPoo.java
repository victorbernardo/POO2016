/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import projetopoo.gui.TClienteCastro;

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
        TClienteCastro TelaCadastroCliente = new TClienteCastro();
        TelaCadastroCliente.setVisible(true);
        TelaCadastroCliente.setTitle("Cadastro de Clientes");
        TelaCadastroCliente.setResizable(false);
    }
    
}
