package a.vendasy2.controller;

import a.vendasy2.dao.DAOProdutosVendasProdutos;
import a.vendasy2.model.ModelProdutosVendasProdutos;
import java.util.ArrayList;

/**
 * Controlador dos produtos vendidos em vendas específicas.
 * Esta classe controla as operações relacionadas aos produtos vendidos em vendas específicas,
 * permitindo a obtenção da lista de produtos associados a uma venda.
 */
public class ControllerProdutosVendasProdutos {
    
    /**
     * Instância da classe DAOProdutosVendasProdutos para realizar operações no banco de dados
     * relacionadas aos produtos vendidos em vendas específicas.
     */
    public DAOProdutosVendasProdutos dAOProdutosVendasProdutos = new DAOProdutosVendasProdutos();
    
    /**
     * Construtor padrão.
     * Este é o construtor padrão da classe ControllerProdutosVendasProdutos.
     */
    public ControllerProdutosVendasProdutos(){}

    /**
     * Obtém a lista de produtos relacionados a uma venda pelo código da venda.
     *
     * @param pCodigoVenda O código da venda para buscar os produtos associados
     * @return ArrayList ModelProdutosVendasProdutos Uma lista de produtos relacionados à venda
     */
    public ArrayList<ModelProdutosVendasProdutos> getListaProdutosVendasProdutosController(int pCodigoVenda) {
        return this.dAOProdutosVendasProdutos.getListaProdutosVendasProdutosDAO(pCodigoVenda);
    }
}
