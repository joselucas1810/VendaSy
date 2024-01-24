/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.vendasy2.model;

/**
 *Classe "fusão" entre modelProdutos e modelVendasProdutos
 * @author jose_
 */
public class ModelProdutosVendasProdutos {
    private ModelProdutos modelProdutos;
    private ModelVendasProdutos modelVendasProdutos;

    /**
     * Obtém o modelo de produtos associado.
     * @return O modelo de produtos associado.
     */
    public ModelProdutos getModelProdutos() {
        return modelProdutos;
    }

    /**
     * Define o modelo de produtos associado.
     * @param modelProdutos O modelo de produtos a ser associado.
     */
    public void setModelProdutos(ModelProdutos modelProdutos) {
        this.modelProdutos = modelProdutos;
    }

    /**
     * Obtém o modelo de vendas de produtos associado.
     * @return O modelo de vendas de produtos associado.
     */
    public ModelVendasProdutos getModelVendasProdutos() {
        return modelVendasProdutos;
    }

    /**
     * Define o modelo de vendas de produtos associado.
     * @param modelVendasProdutos O modelo de vendas de produtos a ser associado.
     */
    public void setModelVendasProdutos(ModelVendasProdutos modelVendasProdutos) {
        this.modelVendasProdutos = modelVendasProdutos;
    }
}
