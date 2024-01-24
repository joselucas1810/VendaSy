package UtilTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import a.vendasy2.util.Formatador;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author jose_
 */
public class FormatadorTest {
    
       @Test
    public void testConverterVirgulaParaPonto() {
        Formatador formatador = new Formatador();

        // Teste para verificar a conversão de vírgula para ponto
        assertEquals(123.45, formatador.converterVirgulaParaPonto("123,45"), 0.001);

        // Teste para verificar a conversão de vírgula para ponto com valor negativo
        assertEquals(-12.34, formatador.converterVirgulaParaPonto("-12,34"), 0.001);

        // Teste para verificar a conversão de vírgula para ponto com várias casas decimais
        assertEquals(3.14159, formatador.converterVirgulaParaPonto("3,14159"), 0.001);
    }
}
    

