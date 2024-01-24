/*
 * Esta classe é responsável por controlar as operações relacionadas aos produtos.
 */
package a.vendasy2.controller;

import a.vendasy2.dao.DAOProdutos;
import java.util.ArrayList;
import a.vendasy2.model.ModelProdutos;

/**
 * Controlador dos produtos.
 * Esta classe controla as operações relacionadas aos produtos, como salvar, excluir, alterar e retornar informações sobre os produtos.
 */
public class ControllerProdutos {

    /**
     * Instância da classe DAOProdutos para realizar operações no banco de dados relacionadas aos produtos.
     */
    public DAOProdutos daoProdutos = new DAOProdutos();

    /**
     * Construtor padrão.
     * Este é o construtor padrão da classe ControllerProdutos.
     */
    public ControllerProdutos() {
        // Construtor padrão da classe ControllerProdutos
    }

    /**
     * Salva um produto no Controller.
     *
     * @param pModelProdutos O modelo do produto a ser salvo
     * @return int O ID do produto salvo
     */
    public int salvarProdutoController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.salvarProdutosDAO(pModelProdutos);
    }

    /**
     * Exclui um produto pelo código.
     *
     * @param pCodigo O código do produto a ser excluído
     * @return boolean Retorna verdadeiro se a exclusão for bem-sucedida, caso contrário, falso
     */
    public boolean excluirProdutoController(int pCodigo) {
        return this.daoProdutos.excluirProdutoDAO(pCodigo);
    }

    /**
     * Altera um produto.
     *
     * @param pModelProdutos O modelo do produto a ser alterado
     * @return boolean Retorna verdadeiro se a alteração for bem-sucedida, caso contrário, falso
     */
    public boolean alterarProdutoController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.alterarProdutoDAO(pModelProdutos);
    }

    /**
     * Retorna um produto pelo código.
     *
     * @param pCodigo O código do produto a ser retornado
     * @return ModelProdutos O produto recuperado pelo código
     */
    public ModelProdutos retornarProdutoController(int pCodigo) {
        return this.daoProdutos.retornarProdutoDAO(pCodigo);
    }

    /**
     * Retorna um produto pelo nome.
     *
     * @param pNomeProduto O nome do produto a ser retornado
     * @return ModelProdutos O produto recuperado pelo nome
     */
    public ModelProdutos retornarProdutoControllerS(String pNomeProduto) {
        return this.daoProdutos.retornarProdutoDAO(pNomeProduto);
    }

    /**
     * Retorna uma lista de produtos.
     *
     * @return ArrayList ModelProdutos Lista de todos os produtos
     */
    public ArrayList<ModelProdutos> retornarListaProdutoController() {
        return this.daoProdutos.retornarListaProdutosDAO();
    }

    /**
     * Altera a lista de produtos no banco.
     *
     * @param pListaModelProdutos Lista de modelos de produtos a serem alterados
     * @return boolean Retorna verdadeiro se a alteração for bem-sucedida, caso contrário, falso
     */
    public boolean alterarEstoqueProdutoController(ArrayList<ModelProdutos> pListaModelProdutos) {
        return this.daoProdutos.alterarEstoqueProdutosDAO(pListaModelProdutos);
    }
}
