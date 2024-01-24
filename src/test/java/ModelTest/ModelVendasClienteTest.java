package ModelTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import a.vendasy2.model.ModelCliente;
import a.vendasy2.model.ModelVendas;
import a.vendasy2.model.ModelVendasCliente;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
/**
 *
 * @author jose_
 */
public class ModelVendasClienteTest {

    @Test
    public void testConstrutorPadrao() {
        ModelVendasCliente vendasCliente = new ModelVendasCliente();
        assertNotNull(vendasCliente);
    }

    @Test
    public void testSettersAndGetters() {
        ModelVendasCliente vendasCliente = new ModelVendasCliente();

        ModelVendas modelVendas = new ModelVendas();
        ModelCliente modelCliente = new ModelCliente();
        ArrayList<ModelVendasCliente> listaVendasCliente = new ArrayList<>();

        vendasCliente.setModelVendas(modelVendas);
        vendasCliente.setModelCliente(modelCliente);
        vendasCliente.setListaModelVendasCliente(listaVendasCliente);

        assertEquals(modelVendas, vendasCliente.getModelVendas());
        assertEquals(modelCliente, vendasCliente.getModelCliente());
        assertEquals(listaVendasCliente, vendasCliente.getListaModelVendasCliente());
    }
}
