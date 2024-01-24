package a.vendasy2.model;


public class ModelVendasProdutos {

    private int idVendaProduto;
    private int produto;
    private int vendas;
    private double venProValor;
    private int venProQuantidade;

    /**
     * Construtor padrão da classe.
     */
    public ModelVendasProdutos(){}

    /**
     * Define o valor do ID do produto da venda.
     * @param pIdVendaProduto O ID do produto da venda a ser definido.
     */
    public void setIdVendaProduto(int pIdVendaProduto){
        this.idVendaProduto = pIdVendaProduto;
    }

    /**
     * Obtém o ID do produto da venda.
     * @return O ID do produto da venda.
     */
    public int getIdVendaProduto(){
        return this.idVendaProduto;
    }

    /**
     * Define o valor do ID do produto associado.
     * @param pProduto O ID do produto a ser associado.
     */
    public void setProduto(int pProduto){
        this.produto = pProduto;
    }

    /**
     * Obtém o ID do produto associado.
     * @return O ID do produto associado.
     */
    public int getProduto(){
        return this.produto;
    }

    /**
     * Define o valor do ID da venda associada.
     * @param pVendas O ID da venda a ser associada.
     */
    public void setVendas(int pVendas){
        this.vendas = pVendas;
    }

    /**
     * Obtém o ID da venda associada.
     * @return O ID da venda associada.
     */
    public int getVendas(){
        return this.vendas;
    }

    /**
     * Define o valor do valor do produto da venda.
     * @param pVenProValor O valor do produto da venda a ser definido.
     */
    public void setVenProValor(double pVenProValor){
        this.venProValor = pVenProValor;
    }

    /**
     * Obtém o valor do produto da venda.
     * @return O valor do produto da venda.
     */
    public double getVenProValor(){
        return this.venProValor;
    }

    /**
     * Define o valor da quantidade do produto da venda.
     * @param pVenProQuantidade A quantidade do produto da venda a ser definida.
     */
    public void setVenProQuantidade(int pVenProQuantidade){
        this.venProQuantidade = pVenProQuantidade;
    }

    /**
     * Obtém a quantidade do produto da venda.
     * @return A quantidade do produto da venda.
     */
    public int getVenProQuantidade(){
        return this.venProQuantidade;
    }
}
