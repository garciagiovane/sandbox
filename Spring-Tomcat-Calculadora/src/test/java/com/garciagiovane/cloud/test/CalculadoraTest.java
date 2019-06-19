package com.garciagiovane.cloud.test;
import com.garciagiovane.cloud.calculadora.Calculadora;
import com.garciagiovane.cloud.configuracao.ConfiguracaoCalculadora;
import com.garciagiovane.cloud.exception.NaoPodeDividirPorZeroException;
import com.garciagiovane.cloud.exception.OperacaoInvalidaException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfiguracaoCalculadora.class})
public class CalculadoraTest {
	private ApplicationContext ac;
    private Calculadora calculadora;

    @Before
    public void inicializarCalculadora(){
        ac = new AnnotationConfigApplicationContext(ConfiguracaoCalculadora.class);
        calculadora = new Calculadora(ac);
    }

    @Test
    public void testSoma(){
        assertEquals(5, calculadora.calcular(2, 3, "+"), 0);
    }

    @Test
    public void testSubtracao(){
        assertEquals(10, calculadora.calcular(17, 7, "-"), 0);
    }

    @Test
    public void testMultiplicacao(){
        assertEquals(25, calculadora.calcular(5, 5, "*"), 0);
    }

    @Test
    public void testDivisao(){
        assertEquals(2, calculadora.calcular(4, 2,"/"), 0);
    }
    
    @Test(expected = NaoPodeDividirPorZeroException.class)
    public void testDivisaoException(){
        calculadora.calcular(4, 0,"/");
    }

    @Test
    public void testPotenciacao(){
        assertEquals(4, calculadora.calcular(2, 2, "^"), 0);
    }
    
    @Test(expected = OperacaoInvalidaException.class)
    public void testOperacaoException(){
        calculadora.calcular(2, 2, "vaiDarErro");
    }
    
    @Test
    public void testHistorico(){
    	calculadora.calcular(15, 5, "-");
        calculadora.calcular(110, 23, "-");
        calculadora.calcular(10, 5, "+");
        calculadora.calcular(5, 10, "+");
        calculadora.calcular(40, 20, "/");
        calculadora.calcular(81, 9, "/");
        calculadora.calcular(10, 5, "*");
        calculadora.calcular(2, 80, "*");
        calculadora.calcular(2, 2, "^");
        calculadora.calcular(4, 2, "^");

        assertEquals(10, calculadora.mostrarHistorico().get(0).calcular(), 0);
        assertEquals(15, calculadora.mostrarHistorico().get(2).calcular(), 0);
        assertEquals(2, calculadora.mostrarHistorico().get(4).calcular(), 0);
        assertEquals(50, calculadora.mostrarHistorico().get(6).calcular(), 0);
        assertEquals(4, calculadora.mostrarHistorico().get(8).calcular(), 0);
    }
}