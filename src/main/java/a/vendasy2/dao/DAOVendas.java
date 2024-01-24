package a.vendasy2.dao;

import a.vendasy2.model.ModelVendas;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe responsável por acessar e manipular dados de vendas no banco de dados.
 */
public class DAOVendas extends ConexaoDAO {

    /**
     * Construtor padrão.
     * Este é o construtor padrão da classe DAOVendas.
     */
    public DAOVendas() {}

    /**
     * Grava uma venda no banco de dados.
     *
     * @param pModelVendas O objeto ModelVendas a ser salvo
     * @return int Retorna o ID da venda gravada
     */
    public int salvarVendasDAO(ModelVendas pModelVendas) {
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_vendas ("
                    + "fk_cliente,"
                    + "ven_data_venda,"
                    + "ven_valor_liquido,"
                    + "ven_valor_bruto,"
                    + "ven_desconto"
                + ") VALUES ("
                    + "'" + pModelVendas.getCliente() + "',"
                    + "'" + pModelVendas.getVenData() + "',"
                    + "'" + pModelVendas.getVenValorLiquido() + "',"
                    + "'" + pModelVendas.getVenValorBruto() + "',"
                    + "'" + pModelVendas.getVenDesconto() + "'"
                + ");"
            );
        } catch (Exception e) {
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Recupera uma venda pelo ID.
     *
     * @param pIdVenda O ID da venda a ser recuperada
     * @return ModelVendas Retorna um objeto ModelVendas correspondente ao ID
     */
    public ModelVendas getVendasDAO(int pIdVenda) {
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_vendas,"
                    + "fk_cliente,"
                    + "ven_data_venda,"
                    + "ven_valor_liquido,"
                    + "ven_valor_bruto,"
                    + "ven_desconto"
                + " FROM"
                    + " tbl_vendas"
                + " WHERE"
                    + " pk_id_vendas = '" + pIdVenda + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setVenData(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVenDesconto(this.getResultSet().getDouble(6));
            }
        } catch (SQLException e) {
        } finally {
            this.fecharConexao();
        }
        return modelVendas;
    }

    /**
     * Recupera uma lista de todas as vendas.
     *
     * @return ArrayList ModelVendas Retorna uma lista com todas as vendas
     */
    public ArrayList<ModelVendas> getListaVendasDAO() {
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_id_vendas,"
                    + "fk_cliente,"
                    + "ven_data_venda,"
                    + "ven_valor_liquido,"
                    + "ven_valor_bruto,"
                    + "ven_desconto"
                + " FROM"
                    + " tbl_vendas"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelVendas.setIdVenda(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setVenData(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVenDesconto(this.getResultSet().getDouble(6));
                listamodelVendas.add(modelVendas);
            }
        } catch (SQLException e) {
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
     * Atualiza informações de uma venda existente.
     *
     * @param pModelVendas O objeto ModelVendas com as informações atualizadas
     * @return boolean Retorna true se a atualização for bem-sucedida
     */
    public boolean atualizarVendasDAO(ModelVendas pModelVendas) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_vendas SET "
                    + "pk_id_vendas = '" + pModelVendas.getIdVenda() + "',"
                    + "fk_cliente = '" + pModelVendas.getCliente() + "',"
                    + "ven_data_venda = '" + pModelVendas.getVenData() + "',"
                    + "ven_valor_liquido = '" + pModelVendas.getVenValorLiquido() + "',"
                    + "ven_valor_bruto = '" + pModelVendas.getVenValorBruto() + "',"
                    + "ven_desconto = '" + pModelVendas.getVenDesconto() + "'"
                + " WHERE "
                    + "pk_id_vendas = '" + pModelVendas.getIdVenda() + "'"
                + ";"
            );
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Exclui uma venda do banco de dados.
     *
     * @param pIdVenda O ID da venda a ser excluída
     * @return boolean Retorna true se a exclusão for bem-sucedida
     */
    public boolean excluirVendasDAO(int pIdVenda) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_vendas "
                + " WHERE "
                    + "pk_id_vendas = '" + pIdVenda + "'"
                + ";"
            );
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
