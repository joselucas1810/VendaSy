package ModelTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import a.vendasy2.model.ModelCliente;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author jose_
 */
public class ModelClienteTest {
     @Test
    public void testConstrutorPadrao() {
        ModelCliente cliente = new ModelCliente();
        assertNotNull(cliente);
    }

    @Test
    public void testSettersAndGetters() {
        ModelCliente cliente = new ModelCliente();

        cliente.setIdCliente(1);
        assertEquals(1, cliente.getIdCliente());

        cliente.setCliNome("João");
        assertEquals("João", cliente.getCliNome());

        cliente.setCliEndereco("Rua Teste");
        assertEquals("Rua Teste", cliente.getCliEndereco());

        cliente.setCliBairro("Bairro Teste");
        assertEquals("Bairro Teste", cliente.getCliBairro());

        cliente.setCliCidade("Cidade Teste");
        assertEquals("Cidade Teste", cliente.getCliCidade());

        cliente.setCliUf("UF");
        assertEquals("UF", cliente.getCliUf());

        cliente.setCliCep("12345-678");
        assertEquals("12345-678", cliente.getCliCep());

        cliente.setCliTelefone("1234567890");
        assertEquals("1234567890", cliente.getCliTelefone());
    }
}
