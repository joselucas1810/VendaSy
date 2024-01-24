package ModelTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import a.vendasy2.model.ModelProdutos;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author jose_
 */
public class ModelProdutosTest {
      @Test
    public void testSetAndGetIdProduto() {
        ModelProdutos produto = new ModelProdutos();
        produto.setIdProduto(1);
        assertEquals(1, produto.getIdProduto());
    }

    @Test
    public void testSetAndGetProNome() {
        ModelProdutos produto = new ModelProdutos();
        produto.setProNome("Produto Teste");
        assertEquals("Produto Teste", produto.getProNome());
    }

    @Test
    public void testSetAndGetProValor() {
        ModelProdutos produto = new ModelProdutos();
        produto.setProValor(10.99);
        assertEquals(10.99, produto.getProValor(), 0.001); // Usando delta para lidar com comparação de valores de ponto flutuante
    }

    @Test
    public void testSetAndGetProEstoque() {
        ModelProdutos produto = new ModelProdutos();
        produto.setProEstoque(50);
        assertEquals(50, produto.getProEstoque());
    }
}
