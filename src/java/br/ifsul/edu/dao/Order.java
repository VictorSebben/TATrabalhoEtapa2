/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifsul.edu.dao;

import java.io.Serializable;

/**
 *
 * @author Jorge Luis Boeira Bavaresco jlbavaresco@gmail.com
 */
public class Order implements Serializable {

    private String attribute;
    private String label;
    private String operator;

    /**
     *
     * @param attribute Atributo da classe será usado na consulta
     * @param label Chave de internacionalização para o valor do atributo que será exibido na tela
     * @param operator Operador usado na consulta =,like,<,>
     */
    public Order(String attribute, String label, String operator) {
        this.attribute = attribute;
        this.label = label;
        this.operator = operator;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return this.label;
    }
    
    

}
