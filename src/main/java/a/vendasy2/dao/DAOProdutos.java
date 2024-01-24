package a.vendasy2.dao;

import a.vendasy2.model.ModelProdutos;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe responsável por acessar e manipular dados relacionados aos produtos no banco de dados.
 */
public class DAOProdutos extends ConexaoDAO {

    /**
     * Construtor padrão.
     * Este é o construtor padrão da classe DAOProdutos.
     */
    public DAOProdutos() {
        // Construtor padrão vazio
    }
    
    /**
     * Cadastra um produto no banco de dados.
     *
     * @param pModelProdutos O modelo de produto a ser cadastrado
     * @return int O ID do produto cadastrado
     */
    public int salvarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_produto ("
                    + "pro_nome,"
                    + "pro_valor,"
                    + "pro_estoque"
                    + ") VALUES ("
                    + " ' " + pModelProdutos.getProNome() + "',"
                    + " ' " + pModelProdutos.getProValor() + "',"
                    + " ' " + pModelProdutos.getProEstoque() + "'"
                    + ");"
            );
        } catch (Exception e) {
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Exclui um produto do banco de dados.
     *
     * @param pIdProduto O ID do produto a ser excluído
     * @return boolean Retorna verdadeiro se a exclusão for bem-sucedida, caso contrário, falso
     */
    public boolean excluirProdutoDAO(int pIdProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_produto WHERE pk_id_produto = '" + pIdProduto + "'"
            );
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Altera os dados de um produto.
     *
     * @param pModelProdutos O modelo de produto com os novos dados
     * @return boolean Retorna verdadeiro se a alteração for bem-sucedida, caso contrário, falso
     */
    public boolean alterarProdutoDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_produto SET "
                    + "pro_nome = '" + pModelProdutos.getProNome() + "',"
                    + "pro_valor = '" + pModelProdutos.getProValor() + "',"
                    + "pro_estoque = '" + pModelProdutos.getProEstoque() + "'"
                    + "WHERE pk_id_produto = '" + pModelProdutos.getIdProduto() + "'"
            );

        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Retorna um produto pelo código.
     *
     * @param pIdProduto O código do produto a ser retornado
     * @return ModelProdutos O produto recuperado pelo código
     */
    public ModelProdutos retornarProdutoDAO(int pIdProduto) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto,"
                    + "pro_nome,"
                    + "pro_valor,"
                    + "pro_estoque "
                    + "FROM tbl_produto WHERE pk_id_produto = '" + pIdProduto + "'"
            );
            while (this.getResultSet().next()) {
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProNome(this.getResultSet().getString(2));
                modelProdutos.setProValor(this.getResultSet().getDouble(3));
                modelProdutos.setProEstoque(this.getResultSet().getInt(4));
            }

        } catch (SQLException e) {
            // Tratamento de exceção
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /**
     * Retorna um produto pelo nome.
     *
     * @param pNomeProduto O nome do produto a ser retornado
     * @return ModelProdutos O produto recuperado pelo nome
     */
    public ModelProdutos retornarProdutoDAO(String pNomeProduto) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto,"
                    + "pro_nome,"
                    + "pro_valor,"
                    + "pro_estoque "
                    + "FROM tbl_produto WHERE pro_nome = '" + pNomeProduto + "'"
            );
            while (this.getResultSet().next()) {
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProNome(this.getResultSet().getString(2));
                modelProdutos.setProValor(this.getResultSet().getDouble(3));
                modelProdutos.setProEstoque(this.getResultSet().getInt(4));
            }

        } catch (SQLException e) {
            // Tratamento de exceção
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /**
     * Retorna uma lista completa de produtos.
     *
     * @return ArrayList ModelProdutos Lista de todos os produtos
     */
    public ArrayList<ModelProdutos> retornarListaProdutosDAO() {
        ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
        ModelProdutos modelProdutos;
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto,"
                    + "pro_nome,"
                    + "pro_valor,"
                    + "pro_estoque "
                    + "FROM tbl_produto");

            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos();
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProNome(this.getResultSet().getString(2));
                modelProdutos.setProValor(this.getResultSet().getDouble(3));
                modelProdutos.setProEstoque(this.getResultSet().getInt(4));
                listaModelProdutos.add(modelProdutos);
            }

        } catch (SQLException e) {
            // Tratamento de exceção
        } finally {
            this.fecharConexao();
        }
        return listaModelProdutos;
    }

    /**
     * Altera o estoque de produtos no banco de dados.
     *
     * @param pListaModelProdutos A lista de produtos a terem seus estoques alterados
     * @return boolean Retorna verdadeiro se a alteração do estoque for bem-sucedida, caso contrário, falso
     */
    public boolean alterarEstoqueProdutosDAO(ArrayList<ModelProdutos> pListaModelProdutos) {
        try {
            this.conectar();
            for (int i = 0; i < pListaModelProdutos.size(); i++) {
                this.executarUpdateDeleteSQL(
                        "UPDATE tbl_produto SET "
                        + "pro_estoque = '" + pListaModelProdutos.get(i).getProEstoque() + "'"
                        + "WHERE pk_id_produto = '" + pListaModelProdutos.get(i).getIdProduto() + "'"
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

