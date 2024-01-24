package ModelTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import a.vendasy2.model.ModelProdutos;
import a.vendasy2.model.ModelProdutosVendasProdutos;
import a.vendasy2.model.ModelVendasProdutos;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author jose_
 */
public class ModelProdutosVendasProdutosTest {
      @Test
    public void testConstrutorPadrao() {
        ModelProdutosVendasProdutos produtosVendas = new ModelProdutosVendasProdutos();
        assertNotNull(produtosVendas);
    }

    @Test
    public void testSettersAndGetters() {
        ModelProdutosVendasProdutos produtosVendas = new ModelProdutosVendasProdutos();

        ModelProdutos modelProdutos = new ModelProdutos();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();

        produtosVendas.setModelProdutos(modelProdutos);
        produtosVendas.setModelVendasProdutos(modelVendasProdutos);

        assertEquals(modelProdutos, produtosVendas.getModelProdutos());
        assertEquals(modelVendasProdutos, produtosVendas.getModelVendasProdutos());
    }
}
