package prCalculadora;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.*;

public class CalculadoraTest {
	
	Calculadora calc = null;
	
	@Before
	public void setUp() throws Exception {
		calc = new Calculadora();
	}

	@After
	public void tearDown() throws Exception {
		calc = null;
	}

	/*@Test
	public void crearCalculadora() {
		 calc = new Calculadora();
		
		assertNotNull(calc);
		assertTrue(calc instanceof Calculadora);
	}*/
	
	/*
	 *  Con assertos de Matchers
	 */
	@Test
	public void crearCalculadora() {
		 calc = new Calculadora();
		
		//assertNotNull(calc);
		//assertTrue(calc instanceof Calculadora);
		 assertThat(calc, notNullValue());
		 assertThat(calc, instanceOf(Calculadora.class));
	}
	
	/*
	 * Metodo suma pasamos dos operando y devuelve 
	 * el resultado (int)
	 * op1 = 5
	 * op2 = 8
	 * resultado = 13
	 */
	@Test
	public void sumarDosEnteros_ResultadoEntero() {
		int op1 = 5;
		int op2 = 8;
		int resultadoEsperado = 13;
		
		
		//assertEquals(resultadoEsperado, calc.sumar(op1, op2));
		// Usando Hamcrest Matchers
		assertThat(calc.sumar(op1, op2), is(resultadoEsperado));
		assertThat(calc.sumar(op1, op2), greaterThanOrEqualTo(op1));
	}
	
	
	/*
	 * Controlar que la suma o resta no se sale de rango
	 */
	/*@Test(expected = ArithmeticException.class)
	public void sumaFueraDeRango_LanzarExcepcion() {
		int op1 = Integer.MAX_VALUE/2;
		int op2 = Integer.MAX_VALUE/2 + 2;
		
		//long resultado = calc.sumar(op1, op2);
		//System.out.println(op1);
		//System.out.println(op2);
		//System.out.println(resultado);
		
		assertEquals(op1+op2, calc.sumar(op1, op2));
		
	}*/
	
	/*
	 * Controlar que la suma o resta no se sale de rango
	 * usando una regla @Rule
	 */
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test //(expected = ArithmeticException.class)
	public void sumaFueraDeRangoDosPositivos_LanzarExcepcion() {
		int op1 = Integer.MAX_VALUE/2;		
		int op2 = Integer.MAX_VALUE/2 + 2;
		
		exception.expect(ArithmeticException.class);
		exception.expectMessage(not(isEmptyOrNullString()));
		exception.expectMessage(startsWith("Fuera de rango:"));
		exception.expectMessage(containsString(String.valueOf(op1)));
		exception.expectMessage(containsString(Integer.toString(op2)));
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(op1);
		exception.expectMessage(containsString(sb.toString()));
		sb = new StringBuilder();
		sb.append(op2);
		exception.expectMessage(containsString(sb.toString()));
		
		//long resultado = calc.sumar(op1, op2);
		//System.out.println(op1);
		//System.out.println(op2);
		//System.out.println(resultado);
		
		calc.sumar(op1, op2);
		
	}
	
	@Test //(expected = ArithmeticException.class)
	public void sumaFueraDeRangoDosNegativos_LanzarExcepcion() {
		int op1 = -(Integer.MAX_VALUE/2);		
		int op2 = -(Integer.MAX_VALUE/2) - 3;
		
		exception.expect(ArithmeticException.class);
		exception.expectMessage(not(isEmptyOrNullString()));
		exception.expectMessage(startsWith("Fuera de rango:"));
		exception.expectMessage(containsString(String.valueOf(op1)));
		exception.expectMessage(containsString(Integer.toString(op2)));
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(op1);
		exception.expectMessage(containsString(sb.toString()));
		sb = new StringBuilder();
		sb.append(op2);
		exception.expectMessage(containsString(sb.toString()));
		
		//long resultado = calc.sumar(op1, op2);
		//System.out.println(op1);
		//System.out.println(op2);
		//System.out.println(resultado);
		
		calc.sumar(op1, op2);
		
	}
	
	//********************* PRUEBAS PARA RESTA ************************
	/*
	 * Restar dos enteros positivos N y M, si N > M,
	 * el resultado debe ser N-M
	 */
	@Test
	public void restaDosEnterosPositivos_NmayorqueM() {
		int n = Integer.MAX_VALUE;
		int m = 101;
		int resultado = calc.restar(n, m);
		
		assertThat(calc.restar(n, m), is(resultado));
	}
	
	/*
	 * Restar dos enteros positivos N y M, si N < M,
	 * el resultado debe ser -(M-N)
	 */
	@Test
	public void restaDosEnterosPositivos_NmenorqueM() {
		int n = 101;
		int m = Integer.MAX_VALUE;
		int resultado = -(calc.restar(m, n));
		
		assertThat(calc.restar(n, m), is(resultado));
	}

	/*
	 * Dos enteros positivos N y M, la operación (N-M)+M debe dar N
	 */
	@Test
	public void operacionNmenosMmasM_resultadoN() {
		int n = Integer.MAX_VALUE;
		int m = 101;
		
		assertThat(calc.sumar(calc.restar(n,m),m), is(n));
	}

}
