package a.vendasy2.model;

public class ModelCliente {

    private int idCliente;
    private String cliNome;
    private String cliEndereco;
    private String cliBairro;
    private String cliCidade;
    private String cliUf;
    private String cliCep;
    private String cliTelefone;

    /**
     * Construtor padrão da classe ModelCliente.
     */
    public ModelCliente(){}

    /**
     * Define o valor do ID do cliente.
     * @param pIdCliente O ID do cliente a ser definido.
     */
    public void setIdCliente(int pIdCliente){
        this.idCliente = pIdCliente;
    }
    
    /**
     * Obtém o ID do cliente.
     * @return O ID do cliente.
     */
    public int getIdCliente(){
        return this.idCliente;
    }

    /**
     * Define o nome do cliente.
     * @param pCliNome O nome do cliente a ser definido.
     */
    public void setCliNome(String pCliNome){
        this.cliNome = pCliNome;
    }
    
    /**
     * Obtém o nome do cliente.
     * @return O nome do cliente.
     */
    public String getCliNome(){
        return this.cliNome;
    }

    /**
     * Define o endereço do cliente.
     * @param pCliEndereco O endereço do cliente a ser definido.
     */
    public void setCliEndereco(String pCliEndereco){
        this.cliEndereco = pCliEndereco;
    }
    
    /**
     * Obtém o endereço do cliente.
     * @return O endereço do cliente.
     */
    public String getCliEndereco(){
        return this.cliEndereco;
    }

    /**
     * Define o bairro do cliente.
     * @param pCliBairro O bairro do cliente a ser definido.
     */
    public void setCliBairro(String pCliBairro){
        this.cliBairro = pCliBairro;
    }
    
    /**
     * Obtém o bairro do cliente.
     * @return O bairro do cliente.
     */
    public String getCliBairro(){
        return this.cliBairro;
    }

    /**
     * Define a cidade do cliente.
     * @param pCliCidade A cidade do cliente a ser definida.
     */
    public void setCliCidade(String pCliCidade){
        this.cliCidade = pCliCidade;
    }
    
    /**
     * Obtém a cidade do cliente.
     * @return A cidade do cliente.
     */
    public String getCliCidade(){
        return this.cliCidade;
    }

    /**
     * Define o estado (UF) do cliente.
     * @param pCliUf O estado (UF) do cliente a ser definido.
     */
    public void setCliUf(String pCliUf){
        this.cliUf = pCliUf;
    }
    
    /**
     * Obtém o estado (UF) do cliente.
     * @return O estado (UF) do cliente.
     */
    public String getCliUf(){
        return this.cliUf;
    }

    /**
     * Define o CEP do cliente.
     * @param pCliCep O CEP do cliente a ser definido.
     */
    public void setCliCep(String pCliCep){
        this.cliCep = pCliCep;
    }
    
    /**
     * Obtém o CEP do cliente.
     * @return O CEP do cliente.
     */
    public String getCliCep(){
        return this.cliCep;
    }

    /**
     * Define o telefone do cliente.
     * @param pCliTelefone O telefone do cliente a ser definido.
     */
    public void setCliTelefone(String pCliTelefone){
        this.cliTelefone = pCliTelefone;
    }
    
    /**
     * Obtém o telefone do cliente.
     * @return O telefone do cliente.
     */
    public String getCliTelefone(){
        return this.cliTelefone;
    }
}