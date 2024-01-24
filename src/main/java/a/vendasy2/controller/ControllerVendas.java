package a.vendasy2.controller;

import a.vendasy2.model.ModelVendas;
import java.util.ArrayList;
import a.vendasy2.dao.DAOVendas;

/**
 * Controlador das vendas.
 * Esta classe controla as operações relacionadas às vendas, como salvar, recuperar, atualizar e excluir informações sobre as vendas.
 */
public class ControllerVendas {

    /**
     * Instância da classe DAOVendas para realizar operações no banco de dados relacionadas às vendas.
     */
    public DAOVendas daoVendas = new DAOVendas();

    /**
     * Construtor padrão.
     * Este é o construtor padrão da classe ControllerVendas.
     */
    public ControllerVendas(){}

    /**
     * Grava vendas.
     *
     * @param pModelVendas O modelo de vendas a ser gravado
     * @return int O ID da venda gravada
     */
    public int salvarVendasController(ModelVendas pModelVendas){
        return this.daoVendas.salvarVendasDAO(pModelVendas);
    }

    /**
     * Recupera vendas pelo ID.
     *
     * @param pIdVenda O ID da venda a ser recuperada
     * @return ModelVendas A venda recuperada pelo ID
     */
    public ModelVendas getVendasController(int pIdVenda){
        return this.daoVendas.getVendasDAO(pIdVenda);
    }

    /**
     * Recupera uma lista de vendas.
     *
     * @return ArrayList ModelVendas Lista de todas as vendas
     */
    public ArrayList<ModelVendas> getListaVendasController(){
        return this.daoVendas.getListaVendasDAO();
    }

    /**
     * Atualiza vendas.
     *
     * @param pModelVendas O modelo de vendas a ser atualizado
     * @return boolean Retorna verdadeiro se a atualização for bem-sucedida, caso contrário, falso
     */
    public boolean atualizarVendasController(ModelVendas pModelVendas){
        return this.daoVendas.atualizarVendasDAO(pModelVendas);
    }

    /**
     * Exclui vendas pelo ID.
     *
     * @param pIdVenda O ID da venda a ser excluída
     * @return boolean Retorna verdadeiro se a exclusão for bem-sucedida, caso contrário, falso
     */
    public boolean excluirVendasController(int pIdVenda){
        return this.daoVendas.excluirVendasDAO(pIdVenda);
    }
}
