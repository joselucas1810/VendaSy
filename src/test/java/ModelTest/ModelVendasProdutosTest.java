package ModelTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import a.vendasy2.model.ModelVendasProdutos;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author jose_
 */
public class ModelVendasProdutosTest {
    @Test
    public void testConstrutorPadrao() {
        // Teste se o construtor padrão cria uma instância não nula da classe ModelVendasProdutos.
        ModelVendasProdutos vendasProdutos = new ModelVendasProdutos();
        assertNotNull(vendasProdutos);
    }

    @Test
    public void testSettersAndGetters() {
        ModelVendasProdutos vendasProdutos = new ModelVendasProdutos();

        // Defina valores usando os setters
        vendasProdutos.setIdVendaProduto(1);
        vendasProdutos.setProduto(2);
        vendasProdutos.setVendas(3);
        vendasProdutos.setVenProValor(100.0);
        vendasProdutos.setVenProQuantidade(5);

        // Verifique se os valores obtidos dos getters correspondem aos valores definidos
        assertEquals(1, vendasProdutos.getIdVendaProduto());
        assertEquals(2, vendasProdutos.getProduto());
        assertEquals(3, vendasProdutos.getVendas());
        assertEquals(100.0, vendasProdutos.getVenProValor(), 0.001); // Usamos delta para lidar com erros de arredondamento
        assertEquals(5, vendasProdutos.getVenProQuantidade());
    }
}
