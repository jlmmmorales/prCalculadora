package prCalculadora;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalcParamSumarTest {
	private Calculadora calc = new Calculadora();
	private int op1;
	private int op2;
	private int resultado;
	
	// Defino la lista de datos que quiero dar
	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][]{
			{5, 8, 13},
			{8, 5, 13},
			{5, 0, 5},
			{0, 5, 5},
			{0, 0, 0},
			{5, -8, -3},
			{-5, 8, 3},
			{-5, -8, -13}
		});
	}

	// Defino el constructor de mi clase
	public CalcParamSumarTest(int op1, int op2, int resultado) {
		this.op1 = op1;
		this.op2 = op2;
		this.resultado = resultado;
	}
	
	// Defino el Test que quiero realizar
	@Test
	public void testSumar() {
		assertEquals(calc.sumar(op1, op2), resultado);
	}

}
