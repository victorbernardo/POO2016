/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo.negocio.basica;

/**
 *
 * @author victor
 */
public class Fornecedor {
    private Integer idFornecedor;
    private String endereco;
    private String cpnj;
    private String razaoSocial;
    private String telefone;

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
    public void setIdFornecedor(String idFornecedor) {
        this.idFornecedor = Integer.parseInt(idFornecedor);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
     public Boolean isValido()
    {   
        if (this.razaoSocial== null){
            return false;
        }
        if (this.cpnj == null){
            return false;
        }
        return true;
    }
}
