package a.vendasy2.controller;

import a.vendasy2.model.ModelVendasProdutos;
import java.util.ArrayList;
import a.vendasy2.dao.DAOVendasProdutos;

/**
 * Controlador das vendas de produtos.
 * Esta classe controla as operações relacionadas às vendas de produtos,
 * permitindo gravar, recuperar, atualizar e excluir informações sobre as vendas de produtos.
 */
public class ControllerVendasProdutos {

    /**
     * Instância da classe DAOVendasProdutos para realizar operações no banco de dados relacionadas às vendas de produtos.
     */
    public DAOVendasProdutos daoVendasProdutos = new DAOVendasProdutos();

    /**
     * Construtor padrão.
     * Este é o construtor padrão da classe ControllerVendasProdutos.
     */
    public ControllerVendasProdutos(){}

    /**
     * Grava vendas de produtos.
     *
     * @param pModelVendasProdutos O modelo de vendas de produtos a ser gravado
     * @return int O ID da venda de produtos gravada
     */
    public int salvarVendasProdutosController(ModelVendasProdutos pModelVendasProdutos){
        return this.daoVendasProdutos.salvarVendasProdutosDAO(pModelVendasProdutos);
    }

    /**
     * Recupera vendas de produtos pelo ID.
     *
     * @param pIdVendaProduto O ID da venda de produtos a ser recuperada
     * @return ModelVendasProdutos A venda de produtos recuperada pelo ID
     */
    public ModelVendasProdutos getVendasProdutosController(int pIdVendaProduto){
        return this.daoVendasProdutos.getVendasProdutosDAO(pIdVendaProduto);
    }

    /**
     * Recupera uma lista de vendas de produtos.
     *
     * @return ArrayList ModelVendasProdutos Lista de todas as vendas de produtos
     */
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosController(){
        return this.daoVendasProdutos.getListaVendasProdutosDAO();
    }

    /**
     * Atualiza vendas de produtos.
     *
     * @param pModelVendasProdutos O modelo de vendas de produtos a ser atualizado
     * @return boolean Retorna verdadeiro se a atualização for bem-sucedida, caso contrário, falso
     */
    public boolean atualizarVendasProdutosController(ModelVendasProdutos pModelVendasProdutos){
        return this.daoVendasProdutos.atualizarVendasProdutosDAO(pModelVendasProdutos);
    }

    /**
     * Exclui vendas de produtos pelo ID.
     *
     * @param pIdVendaProduto O ID da venda de produtos a ser excluída
     * @return boolean Retorna verdadeiro se a exclusão for bem-sucedida, caso contrário, falso
     */
    public boolean excluirVendasProdutosController(int pIdVendaProduto){
        return this.daoVendasProdutos.excluirVendasProdutosDAO(pIdVendaProduto);
    }

    /**
     * Salva uma lista de produtos da venda.
     *
     * @param pListaModelVendasProdutos Lista de produtos de vendas a serem salvos
     * @return boolean Retorna verdadeiro se a gravação for bem-sucedida, caso contrário, falso
     */
    public boolean salvarVendasProdutosController(ArrayList<ModelVendasProdutos> pListaModelVendasProdutos) {
       return this.daoVendasProdutos.salvarVendasProdutosDAO(pListaModelVendasProdutos);
    }
}
