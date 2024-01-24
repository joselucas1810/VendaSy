package a.vendasy2.dao;

import java.util.ArrayList;
import a.vendasy2.model.ModelCliente;
import a.vendasy2.model.ModelVendas;
import a.vendasy2.model.ModelVendasCliente;
import java.sql.SQLException;

/**
 * Classe responsável por acessar e manipular dados de vendas de clientes no banco de dados.
 */
public class DAOVendasCliente extends ConexaoDAO {
    
    /**
     * Construtor padrão.
     * Este é o construtor padrão da classe DAOVendasCliente.
     */
    public DAOVendasCliente() {}

    /**
     * Retorna uma lista de vendas de clientes com detalhes.
     *
     * @return ArrayList ModelVendasCliente Retorna uma lista de vendas de clientes com detalhes
     */
    public ArrayList<ModelVendasCliente> getListaVendasClienteDAO() {

        ArrayList<ModelVendasCliente> listamodelVendasCliente = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        ModelCliente modelCliente = new ModelCliente();
        ModelVendasCliente modelVendasCliente = new ModelVendasCliente();

        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                + "tbl_vendas.pk_id_vendas,"
                + "tbl_vendas.fk_cliente,"
                + "tbl_vendas.ven_data_venda,"
                + "tbl_vendas.ven_valor_liquido,"
                + "tbl_vendas.ven_valor_bruto,"
                + "tbl_vendas.ven_desconto,"
                + "tbl_cliente.pk_id_cliente,"
                + "tbl_cliente.cli_nome,"
                + "tbl_cliente.cli_endereco,"
                + "tbl_cliente.cli_bairro,"
                + "tbl_cliente.cli_cidade,"
                + "tbl_cliente.cli_uf,"
                + "tbl_cliente.cli_cep,"
                + "tbl_cliente.cli_telefone "
                + "FROM"
                + " tbl_vendas INNER JOIN tbl_cliente "
                + "ON tbl_cliente.pk_id_cliente = tbl_vendas.fk_cliente; "
            );
            while (this.getResultSet().next()) {
                modelVendas = new ModelVendas();
                modelCliente = new ModelCliente();
                modelVendasCliente = new ModelVendasCliente();

                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setVenData(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVenDesconto(this.getResultSet().getDouble(6));
                // Cliente
                modelCliente.setIdCliente(this.getResultSet().getInt(7));
                modelCliente.setCliNome(this.getResultSet().getString(8));
                modelCliente.setCliEndereco(this.getResultSet().getString(9));
                modelCliente.setCliBairro(this.getResultSet().getString(10));
                modelCliente.setCliCidade(this.getResultSet().getString(11));
                modelCliente.setCliUf(this.getResultSet().getString(12));
                modelCliente.setCliCep(this.getResultSet().getString(13));
                modelCliente.setCliTelefone(this.getResultSet().getString(14));

                modelVendasCliente.setModelVendas(modelVendas);
                modelVendasCliente.setModelCliente(modelCliente);

                listamodelVendasCliente.add(modelVendasCliente);
            }
        } catch (SQLException e) {
        } finally {
            this.fecharConexao();
        }
        return listamodelVendasCliente;
    }
}
