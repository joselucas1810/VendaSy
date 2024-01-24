package a.vendasy2.model;



import java.util.Date;

public class ModelVendas {

    private int idVenda;
    private int cliente;
    private Date venData;
    private double venValorLiquido;
    private double venValorBruto;
    private double venDesconto;

    /**
     * Construtor padrão da classe ModelVendas.
     */
    public ModelVendas(){}

    /**
     * Define o valor do ID da venda.
     * @param pIdVenda O ID da venda a ser definido.
     */
    public void setIdVenda(int pIdVenda){
        this.idVenda = pIdVenda;
    }
    
    /**
     * Obtém o ID da venda.
     * @return O ID da venda.
     */
    public int getIdVenda(){
        return this.idVenda;
    }

    /**
     * Define o cliente da venda.
     * @param pCliente O cliente da venda a ser definido.
     */
    public void setCliente(int pCliente){
        this.cliente = pCliente;
    }
    
    /**
     * Obtém o cliente da venda.
     * @return O cliente da venda.
     */
    public int getCliente(){
        return this.cliente;
    }

    /**
     * Define a data da venda.
     * @param pVenData A data da venda a ser definida.
     */
    public void setVenData(Date pVenData){
        this.venData = pVenData;
    }
    
    /**
     * Obtém a data da venda.
     * @return A data da venda.
     */
    public Date getVenData(){
        return this.venData;
    }

    /**
     * Define o valor líquido da venda.
     * @param pVenValorLiquido O valor líquido da venda a ser definido.
     */
    public void setVenValorLiquido(double pVenValorLiquido){
        this.venValorLiquido = pVenValorLiquido;
    }
    
    /**
     * Obtém o valor líquido da venda.
     * @return O valor líquido da venda.
     */
    public double getVenValorLiquido(){
        return this.venValorLiquido;
    }

    /**
     * Define o valor bruto da venda.
     * @param pVenValorBruto O valor bruto da venda a ser definido.
     */
    public void setVenValorBruto(double pVenValorBruto){
        this.venValorBruto = pVenValorBruto;
    }
    
    /**
     * Obtém o valor bruto da venda.
     * @return O valor bruto da venda.
     */
    public double getVenValorBruto(){
        return this.venValorBruto;
    }

    /**
     * Define o desconto da venda.
     * @param pVenDesconto O desconto da venda a ser definido.
     */
    public void setVenDesconto(double pVenDesconto){
        this.venDesconto = pVenDesconto;
    }
    
    /**
     * Obtém o desconto da venda.
     * @return O desconto da venda.
     */
    public double getVenDesconto(){
        return this.venDesconto;
    }

}
