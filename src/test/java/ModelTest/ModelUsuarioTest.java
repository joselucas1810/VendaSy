package ModelTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import a.vendasy2.model.ModelUsuario;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author jose_
 */
public class ModelUsuarioTest {
     @Test
    public void testConstrutorPadrao() {
        ModelUsuario usuario = new ModelUsuario();
        assertNotNull(usuario);
    }

    @Test
    public void testSettersAndGetters() {
        ModelUsuario usuario = new ModelUsuario();

        usuario.setIdUsuario(1);
        usuario.setUsuNome("Teste");
        usuario.setUsuLogin("usuario123");
        usuario.setUsuSenha("senha123");

        assertEquals(1, usuario.getIdUsuario());
        assertEquals("Teste", usuario.getUsuNome());
        assertEquals("usuario123", usuario.getUsuLogin());
        assertEquals("senha123", usuario.getUsuSenha());
    }
}


