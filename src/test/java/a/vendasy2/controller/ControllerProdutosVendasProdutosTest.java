/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package a.vendasy2.controller;

import a.vendasy2.model.ModelProdutosVendasProdutos;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jose_
 */
public class ControllerProdutosVendasProdutosTest {
    
    public ControllerProdutosVendasProdutosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getListaProdutosVendasProdutosController method, of class ControllerProdutosVendasProdutos.
     */
    @Test
    public void testGetListaProdutosVendasProdutosController() {
        System.out.println("getListaProdutosVendasProdutosController");
        int pCodigoVenda = 0;
        ControllerProdutosVendasProdutos instance = new ControllerProdutosVendasProdutos();
        ArrayList<ModelProdutosVendasProdutos> expResult = null;
        ArrayList<ModelProdutosVendasProdutos> result = instance.getListaProdutosVendasProdutosController(pCodigoVenda);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
