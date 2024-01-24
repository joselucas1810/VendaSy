package ModelTest;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import a.vendasy2.model.ModelVendas;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;
/**
 *
 * @author jose_
 */
public class ModelVendasTest {
     @Test
    public void testConstrutorPadrao() {
        ModelVendas venda = new ModelVendas();
        assertNotNull(venda);
    }

    @Test
    public void testSettersAndGetters() {
        ModelVendas venda = new ModelVendas();

        venda.setIdVenda(1);
        venda.setCliente(2);
        Date data = new Date();
        venda.setVenData(data);
        venda.setVenValorLiquido(100.0);
        venda.setVenValorBruto(120.0);
        venda.setVenDesconto(20.0);

        assertEquals(1, venda.getIdVenda());
        assertEquals(2, venda.getCliente());
        assertEquals(data, venda.getVenData());
        assertEquals(100.0, venda.getVenValorLiquido(), 0.001);
        assertEquals(120.0, venda.getVenValorBruto(), 0.001);
        assertEquals(20.0, venda.getVenDesconto(), 0.001);
    }
}
