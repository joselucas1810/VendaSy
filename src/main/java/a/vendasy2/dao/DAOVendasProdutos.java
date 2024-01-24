package a.vendasy2.dao;

import a.vendasy2.model.ModelVendasProdutos;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe responsável por acessar e manipular dados de vendas de produtos no banco de dados.
 */
public class DAOVendasProdutos extends ConexaoDAO {
    
    /**
     * Construtor padrão.
     * Este é o construtor padrão da classe DAOVendasProdutos.
     */
    public DAOVendasProdutos(){}

    /**
     * Grava VendasProdutos no banco de dados.
     *
     * @param pModelVendasProdutos O objeto ModelVendasProdutos a ser salvo
     * @return int Retorna o ID da venda do produto salvo
     */
    public int salvarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos) {
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_vendas_produtos ("
                + "fk_produto,"
                + "fk_vendas,"
                + "ven_pro_valor,"
                + "ven_pro_quantidade"
                + ") VALUES ("
                + "'" + pModelVendasProdutos.getProduto() + "',"
                + "'" + pModelVendasProdutos.getVendas() + "',"
                + "'" + pModelVendasProdutos.getVenProValor() + "',"
                + "'" + pModelVendasProdutos.getVenProQuantidade() + "'"
                + ");"
            );
        } catch (Exception e) {
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Recupera VendasProdutos pelo ID.
     *
     * @param pIdVendaProduto O ID do produto da venda a ser recuperado
     * @return ModelVendasProdutos Retorna o objeto ModelVendasProdutos recuperado
     */
    public ModelVendasProdutos getVendasProdutosDAO(int pIdVendaProduto) {
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                + "pk_id_venda_produto,"
                + "fk_produto,"
                + "fk_vendas,"
                + "ven_pro_valor,"
                + "ven_pro_quantidade"
                + " FROM"
                + " tbl_vendas_produtos"
                + " WHERE"
                + " pk_id_venda_produto = '" + pIdVendaProduto + "'"
                + ";"
            );

            while (this.getResultSet().next()) {
                modelVendasProdutos.setIdVendaProduto(this.getResultSet().getInt(1));
                modelVendasProdutos.setProduto(this.getResultSet().getInt(2));
                modelVendasProdutos.setVendas(this.getResultSet().getInt(3));
                modelVendasProdutos.setVenProValor(this.getResultSet().getDouble(4));
                modelVendasProdutos.setVenProQuantidade(this.getResultSet().getInt(5));
            }
        } catch (SQLException e) {
        } finally {
            this.fecharConexao();
        }
        return modelVendasProdutos;
    }

    /**
     * Recupera uma lista de VendasProdutos.
     *
     * @return ArrayList ModelVendasProdutos Retorna uma lista de objetos ModelVendasProdutos
     */
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosDAO() {
        ArrayList<ModelVendasProdutos> listamodelVendasProdutos = new ArrayList();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                + "pk_id_venda_produto,"
                + "fk_produto,"
                + "fk_vendas,"
                + "ven_pro_valor,"
                + "ven_pro_quantidade"
                + " FROM"
                + " tbl_vendas_produtos"
                + ";"
            );

            while (this.getResultSet().next()) {
                modelVendasProdutos = new ModelVendasProdutos();
                modelVendasProdutos.setIdVendaProduto(this.getResultSet().getInt(1));
                modelVendasProdutos.setProduto(this.getResultSet().getInt(2));
                modelVendasProdutos.setVendas(this.getResultSet().getInt(3));
                modelVendasProdutos.setVenProValor(this.getResultSet().getDouble(4));
                modelVendasProdutos.setVenProQuantidade(this.getResultSet().getInt(5));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        } catch (SQLException e) {
        } finally {
            this.fecharConexao();
        }
        return listamodelVendasProdutos;
    }

    /**
     * Atualiza VendasProdutos.
     *
     * @param pModelVendasProdutos O objeto ModelVendasProdutos com as informações atualizadas
     * @return boolean Retorna true se a atualização for bem-sucedida, false caso contrário
     */
    public boolean atualizarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_vendas_produtos SET "
                + "pk_id_venda_produto = '" + pModelVendasProdutos.getIdVendaProduto() + "',"
                + "fk_produto = '" + pModelVendasProdutos.getProduto() + "',"
                + "fk_vendas = '" + pModelVendasProdutos.getVendas() + "',"
                + "ven_pro_valor = '" + pModelVendasProdutos.getVenProValor() + "',"
                + "ven_pro_quantidade = '" + pModelVendasProdutos.getVenProQuantidade() + "'"
                + " WHERE "
                + "pk_id_venda_produto = '" + pModelVendasProdutos.getIdVendaProduto() + "'"
                + ";"
            );
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Exclui VendasProdutos pelo ID da venda.
     *
     * @param pIdVendaProduto O ID da venda do produto a ser excluído
     * @return boolean Retorna true se a exclusão for bem-sucedida, false caso contrário
     */
    public boolean excluirVendasProdutosDAO(int pIdVendaProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_vendas_produtos "
                + " WHERE "
                + "fk_vendas = '" + pIdVendaProduto + "'"
                + ";"
            );
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Salva uma lista de produtos da venda no banco de dados.
     *
     * @param pListaModelVendasProdutos Lista de ModelVendasProdutos a serem salvos
     * @return boolean Retorna true se a operação for bem-sucedida, false caso contrário
     */
    public boolean salvarVendasProdutosDAO(ArrayList<ModelVendasProdutos> pListaModelVendasProdutos) {
        try {
            this.conectar();
            int cont = pListaModelVendasProdutos.size();
            for (int i = 0; i < cont; i++) {
                this.insertSQL(
                    "INSERT INTO tbl_vendas_produtos ("
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "ven_pro_valor,"
                    + "ven_pro_quantidade"
                    + ") VALUES ("
                    + "'" + pListaModelVendasProdutos.get(i).getProduto() + "',"
                    + "'" + pListaModelVendasProdutos.get(i).getVendas() + "',"
                    + "'" + pListaModelVendasProdutos.get(i).getVenProValor() + "',"
                    + "'" + pListaModelVendasProdutos.get(i).getVenProQuantidade() + "'"
                    + ");"
                );
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
