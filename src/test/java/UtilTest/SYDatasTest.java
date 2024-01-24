/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UtilTest;

import a.vendasy2.util.SYDatas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose_
 */
public class SYDatasTest {
 
     @Test
    public void testConverterDataParaDateUS() {
        SYDatas syDatas = new SYDatas();

        try {
            // Data a ser convertida
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date dataParaConverter = sdf.parse("2023/11/15");

            // Chama o método que será testado
            java.sql.Date dataConvertida = syDatas.converterDataParaDateUS(dataParaConverter);

            // Verifica se a data convertida não é nula
            assertNotNull(dataConvertida);

            // Verifica se a data convertida é igual à data original
            assertEquals(sdf.format(dataParaConverter), sdf.format(dataConvertida));

        } catch (ParseException e) {
            fail("Exceção lançada durante o teste: " + e.getMessage());
        } catch (Exception e) {
            fail("Outra exceção foi lançada durante o teste: " + e.getMessage());
        }
    }
}
