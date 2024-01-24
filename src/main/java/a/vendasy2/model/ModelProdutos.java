/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.vendasy2.model;


public class ModelProdutos {
    private int idProduto;
    private String proNome;
    private Double proValor;
    private int proEstoque;

    /**
     * Obtém o ID do produto.
     * @return O ID do produto.
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * Define o ID do produto.
     * @param idProduto O ID do produto a ser definido.
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * Obtém o nome do produto.
     * @return O nome do produto.
     */
    public String getProNome() {
        return proNome;
    }

    /**
     * Define o nome do produto.
     * @param proNome O nome do produto a ser definido.
     */
    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    /**
     * Obtém o valor do produto.
     * @return O valor do produto.
     */
    public Double getProValor() {
        return proValor;
    }

    /**
     * Define o valor do produto.
     * @param proValor O valor do produto a ser definido.
     */
    public void setProValor(Double proValor) {
        this.proValor = proValor;
    }

    /**
     * Obtém a quantidade em estoque do produto.
     * @return A quantidade em estoque do produto.
     */
    public int getProEstoque() {
        return proEstoque;
    }

    /**
     * Define a quantidade em estoque do produto.
     * @param proEstoque A quantidade em estoque do produto a ser definida.
     */
    public void setProEstoque(int proEstoque) {
        this.proEstoque = proEstoque;
    }
}
