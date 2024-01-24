package a.vendasy2.controller;

import a.vendasy2.model.ModelCliente;
import java.util.ArrayList;
import a.vendasy2.dao.DAOCliente;


/**
 * Classe responsável por controlar as operações relacionadas aos clientes.
 */
public class ControllerCliente{
    
    /**
     * Construtor padrão
     */
    public ControllerCliente(){}
    
    /**
     * Instância da classe DAOCliente para realizar operações no banco de dados relacionadas aos clientes
     */
    public DAOCliente daoCliente = new DAOCliente();

    /**
     * Grava um cliente no banco de dados.
     *
     * @param pModelCliente O modelo do cliente a ser gravado
     * @return int O ID do cliente gravado
     */
    public int salvarClienteController(ModelCliente pModelCliente){
        return this.daoCliente.salvarClienteDAO(pModelCliente);
    }

    /**
     * Recupera um cliente pelo ID.
     *
     * @param pIdCliente O ID do cliente a ser recuperado
     * @return ModelCliente O cliente recuperado pelo ID
     */
    public ModelCliente getClienteController(int pIdCliente){
        return this.daoCliente.getClienteDAO(pIdCliente);
    }

    /**
     * Recupera um cliente pelo nome.
     *
     * @param pNomeCliente O nome do cliente a ser recuperado
     * @return ModelCliente O cliente recuperado pelo nome
     */
    public ModelCliente getClienteController(String pNomeCliente){
        return this.daoCliente.getClienteDAO(pNomeCliente);
    }

    /**
     * Recupera uma lista de todos os clientes.
     *
     * @return ArrayList ModelCliente Lista de todos os clientes
     */
    public ArrayList<ModelCliente> getListaClienteController(){
        return this.daoCliente.getListaClienteDAO();
    }

    /**
     * Atualiza as informações de um cliente no banco de dados.
     *
     * @param pModelCliente O modelo do cliente a ser atualizado
     * @return boolean Retorna verdadeiro se a atualização for bem-sucedida, caso contrário, falso
     */
    public boolean atualizarClienteController(ModelCliente pModelCliente){
        return this.daoCliente.atualizarClienteDAO(pModelCliente);
    }

    /**
     * Exclui um cliente do banco de dados pelo ID.
     *
     * @param pIdCliente O ID do cliente a ser excluído
     * @return boolean Retorna verdadeiro se a exclusão for bem-sucedida, caso contrário, falso
     */
    public boolean excluirClienteController(int pIdCliente){
        return this.daoCliente.excluirClienteDAO(pIdCliente);
    }
}
