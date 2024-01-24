/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.vendasy2.model;



import java.util.ArrayList;

public class ModelVendasCliente {
    
    private ModelVendas modelVendas;
    private ModelCliente modelCliente;
    private ArrayList<ModelVendasCliente> listaModelVendasCliente;

    /**
     * Obtém o modelo de vendas associado.
     * @return O modelo de vendas.
     */
    public ModelVendas getModelVendas() {
        return modelVendas;
    }

    /**
     * Define o modelo de vendas associado.
     * @param modelVendas O modelo de vendas a ser definido.
     */
    public void setModelVendas(ModelVendas modelVendas) {
        this.modelVendas = modelVendas;
    }

    /**
     * Obtém o modelo de cliente associado.
     * @return O modelo de cliente.
     */
    public ModelCliente getModelCliente() {
        return modelCliente;
    }

    /**
     * Define o modelo de cliente associado.
     * @param modelCliente O modelo de cliente a ser definido.
     */
    public void setModelCliente(ModelCliente modelCliente) {
        this.modelCliente = modelCliente;
    }

    /**
     * Obtém a lista de modelos de vendas de clientes.
     * @return A lista de modelos de vendas de clientes.
     */
    public ArrayList<ModelVendasCliente> getListaModelVendasCliente() {
        return listaModelVendasCliente;
    }

    /**
     * Define a lista de modelos de vendas de clientes.
     * @param listaModelVendasCliente A lista de modelos de vendas de clientes a ser definida.
     */
    public void setListaModelVendasCliente(ArrayList<ModelVendasCliente> listaModelVendasCliente) {
        this.listaModelVendasCliente = listaModelVendasCliente;
    }
}

