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
public class Produto {
    private Integer idProduto;
    private Integer IdFornecedor;
    private String nome;
    private String descricao;

    /**
     * @return the idProduto
     */
    public Integer getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the IdFornecedor
     */
    public Integer getIdFornecedor() {
        return IdFornecedor;
    }

    /**
     * @param IdFornecedor the IdFornecedor to set
     */
    public void setIdFornecedor(Integer IdFornecedor) {
        this.IdFornecedor = IdFornecedor;
    }
    public void setIdFornecedor(String IdFornecedor){
        this.IdFornecedor = Integer.parseInt(IdFornecedor);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Boolean isValido(){
        if(nome == null)
            return false;
        else
            return true;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
