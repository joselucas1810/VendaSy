/*
 * Controlador das vendas relacionadas a clientes.
 * Esta classe controla as operações relacionadas às vendas de clientes, permitindo obter uma lista de vendas associadas a clientes.
 */
package a.vendasy2.controller;

import a.vendasy2.dao.DAOVendasCliente;
import java.util.ArrayList;
import a.vendasy2.model.ModelVendasCliente;

/**
 * Controlador das vendas relacionadas a clientes.
 * Esta classe controla as operações relacionadas às vendas de clientes, permitindo obter uma lista de vendas associadas a clientes.
 */
public class ControllerVendasCliente {

    /**
     * Instância da classe DAOVendasCliente para realizar operações no banco de dados relacionadas às vendas de clientes.
     */
    public DAOVendasCliente daoVendasCliente = new DAOVendasCliente();

    /**
     * Construtor padrão.
     * Este é o construtor padrão da classe ControllerVendasCliente.
     */
    public ControllerVendasCliente(){}

    /**
     * Obtém uma lista de vendas relacionadas a clientes.
     *
     * @return ArrayList ModelVendasCliente Uma lista de vendas relacionadas a clientes
     */
    public ArrayList<ModelVendasCliente> getListaVendasClienteController() {
        return this.daoVendasCliente.getListaVendasClienteDAO();
    }
}
