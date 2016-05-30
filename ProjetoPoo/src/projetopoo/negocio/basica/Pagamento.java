/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo.negocio.basica;

/**
 *
 * @author aluno
 */
public class Pagamento {
    private String tipo;
    private Integer valor;
    private Integer id_pagamento;

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the valor
     */
    public Integer getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Integer valor) {
        this.valor = valor;
    }

    /**
     * @return the id_pagamento
     */
    public Integer getId_pagamento() {
        return id_pagamento;
    }

    /**
     * @param id_pagamento the id_pagamento to set
     */
    public void setId_pagamento(Integer id_pagamento) {
        this.id_pagamento = id_pagamento;
    }
}
